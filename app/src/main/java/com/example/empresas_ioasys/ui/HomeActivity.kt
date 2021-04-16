package com.example.empresas_ioasys.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.empresas_ioasys.R

class HomeActivity : AppCompatActivity() {

    private val navController: NavController by lazy { findNavController(R.id.navHostFragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}