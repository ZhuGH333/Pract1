package dadm.zyang.practica1.ui.favourites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dadm.zyang.practica1.R
import dadm.zyang.practica1.databinding.FragmentFavouritesBinding
import dadm.zyang.practica1.databinding.FragmentNewQuotationBinding

class FavouritesFragment: Fragment(R.layout.fragment_favourites) {
    private var _binding: FragmentFavouritesBinding? = null;
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouritesBinding.bind(view)
    }

    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }
}