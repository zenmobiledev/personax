package com.mobbelldev.personax.presentation.detail

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.ActivityDetailBinding
import com.mobbelldev.personax.domain.model.UsersItem

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbarDetail)
        binding.toolbarDetail.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        val userDetail = intent.getParcelableExtra<UsersItem>(USER_DETAIL)
        if (userDetail != null) {
            binding.toolbarDetail.title = userDetail.fullName
            with(binding) {
                Glide.with(this@DetailActivity)
                    .load(userDetail.image)
                    .placeholder(R.drawable.baseline_broken_image_24)
                    .into(ivImage)

                flPhone.setOnClickListener {
                    // intent tel
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = "tel:${userDetail.phone}".toUri()
                    startActivity(intent)
                }

                flEmail.setOnClickListener {
                    // intent email
                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = "mailto:${userDetail.email}".toUri()
                    startActivity(Intent.createChooser(intent, "Send Email"))
                }

                flMaps.setOnClickListener {
                    // intent maps
                    val lat = (userDetail.address?.coordinates?.lat as? Number)?.toDouble()
                    val lng = (userDetail.address?.coordinates?.lng as? Number)?.toDouble()

                    if (lat != null && lng != null) {
                        val uri = "geo:$lat,$lng".toUri()
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        intent.setPackage("com.google.android.apps.maps")
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this@DetailActivity,
                            "Location not available",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    companion object {
        const val USER_DETAIL = "user_detail"
    }
}