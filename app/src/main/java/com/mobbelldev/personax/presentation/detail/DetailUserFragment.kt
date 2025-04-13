package com.mobbelldev.personax.presentation.detail

import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.FragmentDetailUserBinding
import com.mobbelldev.personax.domain.model.UsersItem
import com.mobbelldev.personax.presentation.detail.constant.BloodType
import com.mobbelldev.personax.presentation.detail.constant.EyeColor
import com.mobbelldev.personax.presentation.detail.constant.HairColor
import com.mobbelldev.personax.presentation.detail.constant.HairType

class DetailUserFragment : Fragment() {
    private var _binding: FragmentDetailUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userDetail = arguments?.getParcelable<UsersItem>(USER_DETAIL)
        userDetail?.let { user ->
            binding.toolbarDetail.title = user.fullName
            binding.toolbarDetail.setNavigationOnClickListener {
                activity?.onBackPressedDispatcher?.onBackPressed()
            }

            Glide.with(requireContext())
                .load(user.image)
                .placeholder(R.drawable.baseline_broken_image_24)
                .into(binding.ivImage)

            binding.flPhone.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = "tel:${user.phone}".toUri()
                }
                startActivity(intent)
            }

            binding.flEmail.setOnClickListener {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = "mailto:${user.email}".toUri()
                }
                startActivity(Intent.createChooser(intent, "Send Email"))
            }

            binding.flMaps.setOnClickListener {
                val lat = (user.address?.coordinates?.lat as? Number)?.toDouble()
                val lng = (user.address?.coordinates?.lng as? Number)?.toDouble()

                if (lat != null && lng != null) {
                    val label =
                        Uri.encode("${user.address.address}, ${user.address.city}, ${user.address.state}")
                    val uri = "geo:0,0?q=$lat,$lng($label)".toUri()
                    val intent = Intent(Intent.ACTION_VIEW, uri).apply {
                        setPackage("com.google.android.apps.maps")
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(requireContext(), "Location not available", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            // WEIGHT
            val progressWeight = when (val h = userDetail.weight) {
                is Double -> h.toInt()
                is Float -> h.toInt()
                else -> 0
            }
            binding.progressIndicatorWeight.progress = progressWeight

            // HEIGHT
            val progressHeight = when (val w = userDetail.height) {
                is Double -> w.toInt()
                is Float -> w.toInt()
                else -> 0
            }
            binding.progressIndicatorAge.progress = user.age ?: 0
            binding.progressIndicatorWeight.progress = progressWeight
            binding.progressIndicatorHeight.progress = progressHeight

            // Hair, blood type, eye color, etc.
            val hairType =
                HairType.fromString(user.hair?.type ?: getString(R.string.text_not_found))
            val hairDrawable = hairType?.image ?: R.drawable.baseline_question_mark_24
            Glide.with(requireContext()).load(hairDrawable).into(binding.ivHairType)
            binding.tvHairType.text = hairType?.type

            val hairColor =
                HairColor.fromString(user.hair?.color ?: getString(R.string.text_not_found))
            hairColor?.let { color ->
                val colorRes = ContextCompat.getColor(requireContext(), color.value)
                binding.ivHairColor.backgroundTintList = ColorStateList.valueOf(colorRes)
                binding.tvHairColor.text = color.color
            }

            val bloodType =
                BloodType.fromString(user.bloodGroup ?: getString(R.string.text_not_found))
            val bloodDrawable = bloodType?.image ?: R.drawable.baseline_question_mark_24
            Glide.with(requireContext()).load(bloodDrawable).into(binding.ivBloodType)
            binding.tvBloodType.text = bloodType?.type

            val eyeColor = EyeColor.fromString(user.eyeColor ?: getString(R.string.text_not_found))
            val eyeDrawable = eyeColor?.image ?: R.drawable.baseline_question_mark_24
            Glide.with(requireContext()).load(eyeDrawable).into(binding.ivEyeColor)
            binding.tvEyeColor.text = eyeColor?.color
        }
    }

    companion object {
        const val USER_DETAIL = "user_detail"

        fun newInstance(user: UsersItem): DetailUserFragment {
            return DetailUserFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(USER_DETAIL, user)
                }
            }
        }
    }
}