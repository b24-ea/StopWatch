package com.aldanmaz.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.aldanmaz.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var stopTime: Long = 0

        binding.startButton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + stopTime
            binding.chronometer.start()

            binding.startButton.visibility = View.GONE
            binding.pauseButton.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }


            binding.pauseButton.setOnClickListener {
                stopTime = binding.chronometer.base - SystemClock.elapsedRealtime()
                binding.chronometer.stop()
                binding.pauseButton.visibility = View.GONE
                binding.startButton.visibility = View.VISIBLE
                binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
            }
        binding.resetButton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            stopTime = 0
            binding.pauseButton.visibility = View.GONE
            binding.startButton.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }

    }
}