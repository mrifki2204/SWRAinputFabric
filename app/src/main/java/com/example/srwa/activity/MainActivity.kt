package com.example.srwa.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import com.example.srwa.R
import com.example.srwa.databinding.ActivityMainBinding
import com.example.srwa.ui.DashboardFragment

import com.example.srwa.ui.InputFragment
import com.example.srwa.ui.OutputFragment
import com.example.srwa.ui.ProductionFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var navview: BottomNavigationView
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Mengatur window flag agar elemen UI tidak memasuki area status bar
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.statusBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        navview = binding.navView
        replace(DashboardFragment())

        navview.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_dasboard -> replace(DashboardFragment())
                R.id.navigation_input -> replace(InputFragment())
                R.id.navigation_production -> replace(ProductionFragment())
                R.id.navigation_output -> replace(OutputFragment())
            }
            true
        }

        // Trigger button scan QR
        binding.btnScanQR.setOnClickListener {
            scanQRCode()
        }

        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            // Optional: Update UI with user information
            // binding.textFullName.text = firebaseUser.displayName
            // binding.textEmail.text = firebaseUser.email
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, InputFragment())
//                .commit()
//        }


    }

    private fun replace(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host, fragment)
        fragmentTransaction.commit()
    }

    // Function to scan QR code
    private fun scanQRCode() {
        val intent = Intent(this, CodeScannerActivity::class.java)
        startActivity(intent)
    }
}
