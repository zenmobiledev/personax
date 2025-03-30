package com.mobbelldev.personax.presentation.walkthrough

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import com.mobbelldev.personax.MainActivity
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.ActivityWalkthroughBinding
import com.mobbelldev.personax.presentation.login.LoginActivity
import com.mobbelldev.personax.presentation.walkthrough.adapter.WalkthroughAdapter
import com.mobbelldev.personax.presentation.walkthrough.viewmodel.WalkthroughViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WalkthroughActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWalkthroughBinding
    private val walkthroughViewModel: WalkthroughViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            walkthroughViewModel.isLogin.collectLatest { isLogin ->
                if (isLogin) {
                    startActivity(Intent(this@WalkthroughActivity, MainActivity::class.java))
                    finish()
                } else {
                    setupUI()
                }
            }
        }
    }

    private fun setupViewPager() {
        binding.viewPager2.adapter = WalkthroughAdapter()
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { _, _ ->
        }.attach()
    }

    private fun setupUI() {
        enableEdgeToEdge()
        binding = ActivityWalkthroughBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupViewPager()
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this@WalkthroughActivity, LoginActivity::class.java))
        }
    }

    companion object {
        const val MAX_STEP = 5
    }
}