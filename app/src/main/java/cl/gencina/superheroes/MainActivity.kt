package cl.gencina.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.gencina.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)    }
}