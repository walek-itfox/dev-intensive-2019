package ru.skillbranch.devintensive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        println("Start")
    }

    override fun onRestart() {
        super.onRestart()
        println("Restart")
    }

    override fun onResume() {
        super.onResume()
        println("Resume")
    }

}
