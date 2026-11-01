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
            // TODO: kirim ke service.sh via root
            toggleThermal(isChecked)
        }

        switchFastCharge.setOnCheckedChangeListener { _, isChecked ->
            toggleFastCharge(isChecked)
        }
    }

    private fun toggleThermal(enable: Boolean) {
        // Implementasi root (magiskd atau su)
    }

    private fun toggleFastCharge(enable: Boolean) {
        // Implementasi root
    }
}
