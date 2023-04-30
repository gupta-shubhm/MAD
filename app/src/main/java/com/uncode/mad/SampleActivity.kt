package com.uncode.mad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uncode.mad.databinding.ActivityMainBinding
import com.uncode.mad.databinding.ActivitySampleBinding

class SampleActivity : AppCompatActivity() {

    private lateinit var activitySampleBinding: ActivitySampleBinding
    private val binding get() = activitySampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySampleBinding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textbutton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )
        }
    }
}