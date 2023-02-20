package dadm.zyang.practica1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dadm.zyang.practica1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}