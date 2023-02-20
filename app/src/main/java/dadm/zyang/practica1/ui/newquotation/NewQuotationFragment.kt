package dadm.zyang.practica1.ui.newquotation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dadm.zyang.practica1.R
import dadm.zyang.practica1.databinding.FragmentNewQuotationBinding

class NewQuotationFragment: Fragment(R.layout.fragment_new_quotation) {
    private var _binding: FragmentNewQuotationBinding? = null;
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)
    }

    override fun onDestroyView() {
        _binding =  null
        super.onDestroyView()
    }
}
