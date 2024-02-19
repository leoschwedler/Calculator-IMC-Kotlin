package com.example.calculatorimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorimc.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        if (bundle != null) {

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            binding.txtPeso.text = "Peso informado: $peso Kg"
            binding.txtAltura.text = "Altura infromada: $altura m"

            val imc = peso / (altura * altura)

            val resultado = if (imc < 18.5) {
                "Abaixo do peso"
            } else if (imc in 18.5..24.9) {
                "Peso normal"
            } else if (imc in 25.0..29.9) {
                "Sobrepeso"
            } else {
                "Obesidade"
            }
            binding.txtResultado.text = resultado
        }
    }
}