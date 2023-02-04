package com.vangelnum.pokemon_api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vangelnum.pokemon_api.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("EXTRA_NAME")
        binding.tvMyName.text = name

    }
}