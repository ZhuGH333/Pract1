package dadm.zyang.practica1.ui.newquotation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dadm.zyang.practica1.R
import dadm.zyang.practica1.databinding.FragmentNewQuotationBinding

class NewQuotationFragment: Fragment(R.layout.fragment_new_quotation) {
    private var _binding: FragmentNewQuotationBinding? = null;
    private val binding get() = _binding!!

    private val viewModel: NewQuotationViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)

        viewModel.userName.observe(viewLifecycleOwner) {userName->
            binding.msgBienvenida.text = getString(R.string.msgBienvenida, userName)
        }
    }

    override fun onDestroyView() {
        _binding =  null
        super.onDestroyView()
    }
}
