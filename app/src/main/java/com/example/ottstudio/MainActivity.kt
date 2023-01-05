package com.example.ottstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    setContent("Home")
                    true
                }
                R.id.menu_notification -> {
                    setContent("Notification")
                    true
                }
                R.id.add_device -> {
                    setContent("Add Device")
                    true
                }
                R.id.menu_search -> {
                    setContent("Search")
                    true
                }
                R.id.menu_profile -> {
                    setContent("Profile")
                    true
                }
                else -> false
            }
        }

//        bottomNav.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.menu_home -> {
//                    setContent("Home")
//                    true
//                }
//                R.id.menu_notification -> {
//                    setContent("Notification")
//                    true
//                }
//                R.id.add_device -> {
//                    setContent("Add Device")
//                    true
//                }
//                R.id.menu_search -> {
//                    setContent("Search")
//                    true
//                }
//                R.id.menu_profile -> {
//                    setContent("Profile")
//                    true
//                }
//                else -> false
//            }
//        }
    }

    private fun setContent(content: String) {
        setTitle(content)
        tvLabel.text = content
    }
}