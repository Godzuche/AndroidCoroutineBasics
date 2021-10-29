package com.example.androidcoroutinebasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidcoroutinebasics.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private var i = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnCount = binding.btnCount
        btnCount.text = "$i"

        btnCount.setOnClickListener {
            runBlocking {
                launch {
                    for(j in 1..10) {
                        i++
                        btnCount.text = "$i"
                        Log.d("DEMO", "$i")
                        delay(1000)
                    }
                }
            }
        }
    }
}