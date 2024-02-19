package com.example.calculatorimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {

            val peso = binding.editPeso.text.toString()
            val altura = binding.editAltura.text.toString()

            if (peso.isNotEmpty() && altura.isNotEmpty()) {
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
                startActivity(intent)
            }
        }
    }
}