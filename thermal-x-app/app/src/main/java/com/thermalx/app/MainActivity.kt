package com.thermalx.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMagisk: MaterialButton = findViewById(R.id.btnMagisk)
        val btnKernelsu: MaterialButton = findViewById(R.id.btnKernelsu)
        val switchThermal: MaterialSwitch = findViewById(R.id.switchThermal)
        val switchFastCharge: MaterialSwitch = findViewById(R.id.switchFastCharge)

        // Tombol Module
        btnMagisk.setOnClickListener {
            startActivity(Intent(this, ModuleActivity::class.java).apply {
                putExtra("module", "magisk")
            })
        }

        btnKernelsu.setOnClickListener {
            startActivity(Intent(this, ModuleActivity::class.java).apply {
                putExtra("module", "kernelsu")
            })
        }

        // Toggle Global (default off)
        switchThermal.setOnCheckedChangeListener { _, isChecked ->
            toggleThermal(isChecked)
        }

        switchFastCharge.setOnCheckedChangeListener { _, isChecked ->
            toggleFastCharge(isChecked)
        }
    }

    private fun toggleThermal(enable: Boolean) {
        // TODO: implement root toggle (nanti pakai su atau magiskd)
    }

    private fun toggleFastCharge(enable: Boolean) {
        // TODO: implement root toggle
    }
}
