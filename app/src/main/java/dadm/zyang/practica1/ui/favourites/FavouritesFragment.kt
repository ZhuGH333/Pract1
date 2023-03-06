package dadm.zyang.practica1.ui.favourites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dadm.zyang.practica1.R
import dadm.zyang.practica1.databinding.FragmentFavouritesBinding
import dadm.zyang.practica1.databinding.FragmentNewQuotationBinding

class FavouritesFragment: Fragment(R.layout.fragment_favourites) {
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
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}