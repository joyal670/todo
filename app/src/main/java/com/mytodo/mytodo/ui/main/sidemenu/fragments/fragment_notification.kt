package com.mytodo.mytodo.ui.main.sidemenu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mytodo.mytodo.R
import com.mytodo.mytodo.base.BaseFragment
import com.mytodo.mytodo.databinding.FragmentNotificationBinding
import com.mytodo.mytodo.ui.main.sidemenu.adapter.MyTaskPendingAdapter
import com.mytodo.mytodo.ui.main.sidemenu.adapter.NotificationAdapter


class fragment_notification : BaseFragment()
{
    private lateinit var binding: FragmentNotificationBinding

    override fun setView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationBinding.inflate(inflater!!,container,false)
        return binding.root
    }

    override fun initData() {
    }

    override fun setupUI() {
        binding.rvNotification.layoutManager = LinearLayoutManager(context)
        binding.rvNotification.adapter = NotificationAdapter()
    }

    override fun setupViewModel() {
    }

    override fun setupObserver() {
    }

    override fun onClicks() {
    }

}