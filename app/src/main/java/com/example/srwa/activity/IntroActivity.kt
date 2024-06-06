package com.example.srwa.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.srwa.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()
        },3000L)
    }

    private fun goToMainActivity(){
        Intent(this,MainActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }
}