package com.example.nursingstudio

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.nursingstudio.databinding.ActivityMainBinding
import com.example.nursingstudio.fragments.PdfFragment
import com.example.nursingstudio.fragments.QuizFragment
import com.example.nursingstudio.fragments.VideoFragment
import com.example.nursingstudio.fragments.MyPageFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Drawer toggle
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        // Bottom navigation listener
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_quiz -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, QuizFragment()).commit()
                    true
                }
                R.id.nav_pdf -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, PdfFragment()).commit()
                    true
                }
                R.id.nav_video -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, VideoFragment()).commit()
                    true
                }
                R.id.nav_mypage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MyPageFragment()).commit()
                    true
                }
                else -> false
            }
        }

        // Default fragment
        if (savedInstanceState == null) {
            binding.bottomNav.selectedItemId = R.id.nav_quiz
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.drawer_subscription -> {
                // Open subscription screen
            }
            R.id.drawer_notice -> {
                // Open notice board
            }
            R.id.drawer_social -> {
                // Open social links
            }
            R.id.drawer_share -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Download Nursing Studio App")
                startActivity(Intent.createChooser(shareIntent, "Share via"))
            }
            R.id.drawer_settings -> {
                // Open settings
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
