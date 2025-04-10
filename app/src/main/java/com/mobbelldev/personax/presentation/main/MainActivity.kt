package com.mobbelldev.personax.presentation.main

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.ActivityMainBinding
import com.mobbelldev.personax.presentation.detail.DetailActivity
import com.mobbelldev.personax.presentation.main.adapter.MainAdapter
import com.mobbelldev.personax.presentation.main.viewmodel.MainViewModel
import com.mobbelldev.personax.presentation.walkthrough.WalkthroughActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val mainAdapter by lazy {
        MainAdapter(
            clickItemListener = { user ->
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.USER_DETAIL, user)
                }
                startActivity(intent)
            },
            clickSaved = { user ->
                mainViewModel.insertFavoriteUser(user = user)
                Toast.makeText(this@MainActivity, "SAVED", Toast.LENGTH_SHORT).show()
            },
            clickUnsaved = { user ->
                mainViewModel.deleteFavoriteUser(user = user)
                Toast.makeText(this@MainActivity, "UNSAVED", Toast.LENGTH_SHORT).show()
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setupUI()
        setSupportActionBar(binding.toolbar)
        setupRecyclerView()
        setupObserver()
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    mainViewModel.isLoading.collect {
                        binding.progressBar.isVisible = it
                    }
                }

                launch {
                    mainViewModel.errorMessage.collect {
                        Toast.makeText(this@MainActivity, "Error: $it", Toast.LENGTH_SHORT).show()
                    }
                }

                launch {
                    mainViewModel.userList.collect { users ->
                        mainAdapter.submitList(users)
                    }
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvUser.adapter = mainAdapter
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