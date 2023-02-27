package dadm.zyang.practica1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import dadm.zyang.practica1.R
import dadm.zyang.practica1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MenuProvider {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = binding.fragmentContainer.getFragment<NavHostFragment>().navController

        binding.bnNavigation as NavigationBarView
        binding.bnNavigation.setupWithNavController(navController)

        setSupportActionBar(binding.idMaterialTool)
        var appBarConfig = AppBarConfiguration(setOf(R.id.newQuotationFragment, R.id.favouritesFragment, R.id.settingsFragments)  )
        setupActionBarWithNavController(navController, appBarConfig)

        addMenuProvider(this)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_about, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.aboutDialogFragment -> {
                findNavController(R.id.fragmentContainer).navigate(R.id.aboutDialogFragment )
                true
            }
            else -> false
        }
    }
}