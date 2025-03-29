package com.mobbelldev.personax.presentation.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobbelldev.personax.MainActivity
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int,
        ) {
        }

        override fun onTextChanged(
            s: CharSequence?,
            start: Int,
            before: Int,
            count: Int,
        ) {
        }

        override fun afterTextChanged(s: Editable?) {
            with(binding) {
                btnLogin.isEnabled = etUsername.text.toString().isNotEmpty() &&
                        etPassword.text.toString().isNotEmpty()
                btnLogin.isClickable = btnLogin.isEnabled
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        with(binding) {
            // Toolbar
            toolbarLogin.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

            // EditText Username and Password
            etUsername.addTextChangedListener(textWatcher)
            etPassword.addTextChangedListener(textWatcher)

            // Button Login
            btnLogin.setOnClickListener {
                startActivity(
                    Intent(
                        this@LoginActivity,
                        MainActivity::class.java
                    )
                )
            }
        }
    }
}