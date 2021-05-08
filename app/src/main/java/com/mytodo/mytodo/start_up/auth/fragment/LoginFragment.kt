package com.mytodo.mytodo.start_up.auth.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.finishAffinity
import com.mytodo.mytodo.R
import com.mytodo.mytodo.base.BaseFragment
import com.mytodo.mytodo.databinding.FragmentLoginBinding
import com.mytodo.mytodo.ui.main.home.activity.DashboardActivity
import io.reactivex.disposables.CompositeDisposable


class LoginFragment : BaseFragment()
{
    private lateinit var binding: FragmentLoginBinding

    override fun setView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater!!,container,false)
        return binding.root
    }

    override fun initData() {
    }
    override fun setupUI() {

    }

    override fun setupViewModel() {

    }

    override fun setupObserver() {

    }

    override fun onClicks() {
        binding.ivGoogle.setOnClickListener {
            val intent = Intent(requireContext(), DashboardActivity::class.java)
            startActivity(intent)
            finishAffinity(requireActivity())
        }

        binding.ivFacebook.setOnClickListener {

        }
    }

}