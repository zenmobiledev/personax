package com.mobbelldev.personax.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.ActivityMainBinding
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
        R.id.favorite_menu -> {
            Toast.makeText(this@MainActivity, "Move to Favorite page", Toast.LENGTH_SHORT).show()
            true
        }

        R.id.logout_menu -> {
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