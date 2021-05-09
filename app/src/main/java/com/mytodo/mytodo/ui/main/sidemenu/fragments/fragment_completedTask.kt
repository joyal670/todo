package com.mytodo.mytodo.ui.main.sidemenu.fragments

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mytodo.mytodo.base.BaseFragment
import com.mytodo.mytodo.databinding.FragmentCompletedTaskBinding
import com.mytodo.mytodo.ui.main.sidemenu.adapter.MyTaskCompletedAdapter


class fragment_completedTask : BaseFragment() {
    private lateinit var binding: FragmentCompletedTaskBinding

    override fun setView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompletedTaskBinding.inflate(inflater!!, container, false)
        return binding.root
    }

    override fun initData() {
    }

    override fun setupUI() {
        binding.tvView1.paintFlags = binding.tvView1.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        binding.rvTask1.layoutManager = LinearLayoutManager(context)
        binding.rvTask1.adapter = MyTaskCompletedAdapter()
    }

    override fun setupViewModel() {
    }

    override fun setupObserver() {
    }

    override fun onClicks() {
    }


}

