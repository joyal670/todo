package com.mytodo.mytodo.ui.main.sidemenu.fragments

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mytodo.mytodo.base.BaseFragment
import com.mytodo.mytodo.databinding.FragmentMytaskBinding
import com.mytodo.mytodo.dialog.MyTaskTutorialDialog
import com.mytodo.mytodo.ui.main.sidemenu.activity.MyTaskActivity
import com.mytodo.mytodo.ui.main.sidemenu.adapter.MyTaskPendingAdapter
import com.mytodo.mytodo.utils.AppPreferences.prefIsTaskTutorial
import com.mytodo.mytodo.utils.Constants
import com.mytodo.mytodo.utils.EnumFromPage


class fragment_mytask : BaseFragment() {
    private lateinit var binding: FragmentMytaskBinding

    override fun setView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMytaskBinding.inflate(inflater!!, container, false)
        return binding.root
    }

    override fun initData() {

        if(!prefIsTaskTutorial)
        {
            val dialog = MyTaskTutorialDialog()
            dialog.show(parentFragmentManager, "TAG")
            prefIsTaskTutorial = true
        }


    }

    override fun setupUI() {

        binding.tvView1.paintFlags = binding.tvView1.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        binding.rvTask1.layoutManager = LinearLayoutManager(context)
        binding.rvTask1.adapter = MyTaskPendingAdapter()

    }

    override fun setupViewModel() {
    }

    override fun setupObserver() {
    }

    override fun onClicks() {
        binding.fbCompleted.setOnClickListener {
            val intent = Intent(requireContext(), MyTaskActivity::class.java)
            intent.putExtra(Constants.TASKTYPE, EnumFromPage.COMPLETED_TASK.name)
            startActivity(intent)
        }


    }

}