package dadm.zyang.practica1.ui.favourites

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dadm.zyang.practica1.R
import dadm.zyang.practica1.databinding.FragmentFavouritesBinding
import dadm.zyang.practica1.databinding.FragmentNewQuotationBinding

class FavouritesFragment: Fragment(R.layout.fragment_favourites), DeleteAllDialogFragment.DeleteAllDialogListener, MenuProvider{
    private var _binding: FragmentFavouritesBinding? = null;
    private val binding get() = _binding!!

    private val viewModel: FavouritesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFavouritesBinding.bind(view)

        val adapter = QuotationListAdapter()

        binding.recyclerView.adapter = adapter

        viewModel.listaFavs.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        //observar
        //la propiedad de visibilidad e invalidar el menú de opciones cuando cambie su valor –
        //requireActivity().invalidateMenu(). Sobrescribe el método onPrepareMenu() para
        //mostrar u ocultar el elemento de acción del menú de opciones en base al valor de la
        //propiedad observada.
        viewModel.isDeleteAllVisible.observe(viewLifecycleOwner) {
            requireActivity().invalidateMenu()
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    override fun onDeleteAllConfirmed() {
        viewModel.deleteAllQuotation()
    }

    override fun onDeleteAllCancelled() {
        // Do nothing
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

        menuInflater.inflate(R.menu.menu_favourites, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.menu_item_delete -> {
                DeleteAllDialogFragment(this).show(childFragmentManager, null)
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