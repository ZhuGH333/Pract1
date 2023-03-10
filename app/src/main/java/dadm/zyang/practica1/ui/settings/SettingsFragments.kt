package dadm.zyang.practica1.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dadm.zyang.practica1.R
import dadm.zyang.practica1.databinding.FragmentNewQuotationBinding
import dadm.zyang.practica1.databinding.FragmentSettingsBinding

class SettingsFragments: Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null;
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
    }

    override fun onDestroyView() {
        _binding =  null
        super.onDestroyView()
    }
}