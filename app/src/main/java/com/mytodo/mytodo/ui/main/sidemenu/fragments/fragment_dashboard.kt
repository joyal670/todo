package com.mytodo.mytodo.ui.main.sidemenu.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.*
import com.mytodo.mytodo.base.BaseFragment
import com.mytodo.mytodo.databinding.FragmentDashboardBinding
import com.mytodo.mytodo.dialog.DashboardTutorialDialog
import com.mytodo.mytodo.ui.main.sidemenu.activity.MyTaskActivity
import com.mytodo.mytodo.ui.main.sidemenu.adapter.DashBoardAdapter
import com.mytodo.mytodo.utils.AppPreferences.prefIsDashboardTutorial
import com.mytodo.mytodo.utils.Constants
import com.mytodo.mytodo.utils.EnumFromPage


class fragment_dashboard : BaseFragment() {
    private lateinit var binding: FragmentDashboardBinding

    override fun setView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater!!, container, false)
        return binding.root
    }

    override fun initData() {

        if(!prefIsDashboardTutorial)
        {
            val dialog = DashboardTutorialDialog()
            dialog.show(parentFragmentManager, "TAG")
            prefIsDashboardTutorial = true
        }

    }

    override fun setupUI() {
        val layoutManager = FlexboxLayoutManager(requireContext())
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.flexWrap = FlexWrap.WRAP
        layoutManager.justifyContent = JustifyContent.FLEX_START
        layoutManager.alignItems = AlignItems.STRETCH

        binding.rvDashboard.layoutManager = layoutManager
        binding.rvDashboard.adapter = DashBoardAdapter()

        binding.fbAddTask.setOnClickListener {
            val intent = Intent(requireContext(), MyTaskActivity::class.java)
            intent.putExtra(Constants.TASKTYPE, EnumFromPage.ADD_TASK.name)
            startActivity(intent)
        }

    }

    override fun setupViewModel() {

    }

    override fun setupObserver() {

    }

    override fun onClicks() {

    }

}