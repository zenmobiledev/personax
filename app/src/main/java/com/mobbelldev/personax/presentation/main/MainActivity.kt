package com.mobbelldev.personax.presentation.main

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.ActivityMainBinding
import com.mobbelldev.personax.presentation.favorite.FavoriteActivity
import com.mobbelldev.personax.presentation.list.UserListFragment
import com.mobbelldev.personax.presentation.main.viewmodel.MainViewModel
import com.mobbelldev.personax.presentation.walkthrough.WalkthroughActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setupUI()

        setSupportActionBar(binding.toolbar)
        val isTablet = findViewById<View?>(R.id.fragment_detail_container) != null

        if (isTablet) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_list_container, UserListFragment())
                .commit()
        }
    }

    private fun setupUI() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(
            R.menu.top_bar_menu,
            menu
        )
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.theme_menu -> {
            val currentNightMode =
                resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

            when (currentNightMode) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    Toast.makeText(this, "Switched to Light Mode", Toast.LENGTH_SHORT).show()
                }

                Configuration.UI_MODE_NIGHT_NO -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    Toast.makeText(this, "Switched to Dark Mode", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        R.id.favorite_menu -> {
            startActivity(Intent(this@MainActivity, FavoriteActivity::class.java))
            true
        }

        R.id.logout_menu -> {
            Toast.makeText(this@MainActivity, "Logout", Toast.LENGTH_SHORT).show()
            mainViewModel.setLogin(
                isLogin = false
            ).also {
                startActivity(Intent(this@MainActivity, WalkthroughActivity::class.java))
                finish()
            }
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}