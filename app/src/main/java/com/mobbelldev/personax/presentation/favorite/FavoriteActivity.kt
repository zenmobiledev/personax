package com.mobbelldev.personax.presentation.favorite

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.ActivityFavoriteBinding
import com.mobbelldev.personax.presentation.favorite.adapter.FavoriteAdapter
import com.mobbelldev.personax.presentation.favorite.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModels()
    private val favoriteAdapter by lazy {
        FavoriteAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        setupRecyclerView()
        setupObserver()
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    favoriteViewModel.userList.collect {
                        if (it.isNotEmpty()) {
                            binding.rvUser.isVisible = true
                            favoriteAdapter.submitList(it)
                            binding.ivEmptyState.isVisible = false
                            binding.tvEmptyState.isVisible = false
                        } else {
                            binding.rvUser.isVisible = false
                            binding.ivEmptyState.isVisible = true
                            binding.tvEmptyState.isVisible = true
                        }
                    }
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvUser.adapter = favoriteAdapter
    }
}