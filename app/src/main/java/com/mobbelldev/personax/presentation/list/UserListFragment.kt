package com.mobbelldev.personax.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.FragmentUserListBinding
import com.mobbelldev.personax.domain.model.UsersItem
import com.mobbelldev.personax.presentation.detail.DetailUserFragment
import com.mobbelldev.personax.presentation.list.adapter.UserAdapter
import com.mobbelldev.personax.presentation.list.viewmodel.UserListViewModel
import com.mobbelldev.personax.utils.isTabletLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserListFragment : Fragment() {
    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    private val userAdapter by lazy {
        UserAdapter(
            clickItemListener = { user ->
                onUserClicked(
                    user = user
                )
            },
            clickSaved = { user ->
                viewModel.insertFavoriteUser(user = user)
                Toast.makeText(activity, "SAVED", Toast.LENGTH_SHORT).show()
            },
            clickUnsaved = { user ->
                viewModel.deleteFavoriteUser(user = user)
                Toast.makeText(activity, "UNSAVED", Toast.LENGTH_SHORT).show()
            }
        )
    }
    private val viewModel: UserListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObserver()
    }

    private fun setupObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.isLoading.collect {
                        binding.progressBar.isVisible = it
                    }
                }

                launch {
                    viewModel.errorMessage.collect {
                        Toast.makeText(activity, "Error: $it", Toast.LENGTH_SHORT).show()
                    }
                }

                launch {
                    viewModel.userList.collect { users ->
                        userAdapter.submitList(users)
                    }
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvUser.adapter = userAdapter
    }

    private fun onUserClicked(user: UsersItem) {
        if (requireContext().isTabletLayout()) {
            val fragment = DetailUserFragment.newInstance(user)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_detail_container, fragment)
                .commit()
        } else {
            val bundle = Bundle().apply {
                putParcelable(DetailUserFragment.USER_DETAIL, user)
            }
            findNavController().navigate(R.id.action_userListFragment_to_detailUserFragment, bundle)
        }
    }

}