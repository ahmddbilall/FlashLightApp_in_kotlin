package com.bilal.flashlight

import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService
import com.bilal.flashlight.R.*
import com.bilal.flashlight.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            if (binding.btn.text == "TURN ON") {
                binding.btn.text = "TURN OFF"
                binding.img.setImageResource(drawable.on)
                changeLightState(true)

            }
            else if (binding.btn.text == "TURN OFF") {
                binding.btn.text = "TURN ON"
                binding.img.setImageResource(drawable.light)
                changeLightState(false)
            }
        }
    }
    private fun changeLightState(state: Boolean) {
        var camera =  (getSystemService(CAMERA_SERVICE)) as CameraManager
        var camId = camera.cameraIdList[0]
        camera.setTorchMode(camId,state)
    }
}