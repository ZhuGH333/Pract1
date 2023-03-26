package dadm.zyang.practica1.ui.favourites

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dadm.zyang.practica1.R
import dadm.zyang.practica1.databinding.FragmentFavouritesBinding
import dadm.zyang.practica1.databinding.FragmentNewQuotationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesFragment: Fragment(R.layout.fragment_favourites),  MenuProvider{
    private var _binding: FragmentFavouritesBinding? = null;
    private val binding get() = _binding!!

    private val viewModel: FavouritesViewModel by activityViewModels()

    private val itemTouchHelper = ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END){
        override fun onMove(
            recyclerView: androidx.recyclerview.widget.RecyclerView,
            viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder,
            target: androidx.recyclerview.widget.RecyclerView.ViewHolder):
                Boolean {
            return false
        }

        override fun isLongPressDragEnabled(): Boolean {
            return false
        }

        override fun isItemViewSwipeEnabled(): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, direction: Int) {
            viewModel.deleteQuotationAsPosition(viewHolder.adapterPosition)
        }
    })

    private val itemClicked = object: QuotationListAdapter.ItemClicked{
        override fun onClick(author: String) {
            if(author == "Anonymous"){
                Snackbar.make(binding.root, "No se puede mostrar información si el autor es anónimo", Snackbar.LENGTH_SHORT).show()
            }else{
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://en.wikipedia.org/wiki/Special:Search?search=$author")
                try{
                    startActivity(intent)
                }catch (e: ActivityNotFoundException){
                    Snackbar.make(binding.root, "No es posible gestionar la acción solicitada", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFavouritesBinding.bind(view)

        val adapter = QuotationListAdapter(itemClicked)

        binding.recyclerView.adapter = adapter

        viewModel.listaFavs.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewModel.isDeleteAllVisible.observe(viewLifecycleOwner) {
            requireActivity().invalidateMenu()
        }

        itemTouchHelper.attachToRecyclerView(binding.recyclerView)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

        menuInflater.inflate(R.menu.menu_favourites, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.menu_item_delete -> {
                DeleteAllDialogFragment().show(childFragmentManager, null)
                true
            }
            else -> false
        }
    }

    override fun onPrepareMenu(menu: Menu) {
        menu.findItem(R.id.menu_item_delete).isVisible = viewModel.isDeleteAllVisible.value ?: false
        super.onPrepareMenu(menu)
    }
}