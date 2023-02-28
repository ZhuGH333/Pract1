package dadm.zyang.practica1.ui.newquotation

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import dadm.zyang.practica1.R
import dadm.zyang.practica1.databinding.FragmentNewQuotationBinding

class NewQuotationFragment: Fragment(R.layout.fragment_new_quotation), MenuProvider {
    private var _binding: FragmentNewQuotationBinding? = null;
    private val binding get() = _binding!!

    private val viewModel: NewQuotationViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)

        viewModel.userName.observe(viewLifecycleOwner) {userName->
            binding.msgBienvenida.text = getString(R.string.msgBienvenida, userName)
        }

        viewModel.cita.observe(viewLifecycleOwner) { cita ->
            binding.msgCita.text = cita.cita
            if (cita.author == "") {
                binding.msgAutor.text = "Anonymous"
            } else {
                binding.msgAutor.text = cita.author
            }
        }

        viewModel.isRefreshing.observe(viewLifecycleOwner) { isRefreshing ->
            binding.swipeRefresh.isRefreshing = isRefreshing
        }

        viewModel.isGreetingsVisible.observe(viewLifecycleOwner) {
            binding.msgBienvenida.visibility = if (it) View.VISIBLE else View.INVISIBLE
        }

        binding.swipeRefresh.setOnRefreshListener {
            getNewQuotation()
        }

        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_new_quotation, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.refresh -> {
                getNewQuotation()
                true
            }
            else -> false
        }
    }
    private fun getNewQuotation() {
        viewModel.getNewQuotation()
    }

    override fun onDestroyView() {
        _binding =  null
        super.onDestroyView()
    }
}
