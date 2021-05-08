package com.mytodo.mytodo.ui.main.sidemenu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mytodo.mytodo.R
import com.mytodo.mytodo.base.BaseFragment
import com.mytodo.mytodo.databinding.FragmentCalenderBinding
import com.mytodo.mytodo.ui.main.sidemenu.adapter.studentAssignmentAdapter
import com.mytodo.mytodo.utils.EventDecorator
import com.mytodo.mytodo.utils.MySelectorDecorator
import com.mytodo.mytodo.utils.OneDayDecorator
import com.prolificinteractive.materialcalendarview.CalendarDay
import org.threeten.bp.LocalDate


class fragment_calender : BaseFragment()
{
    private lateinit var binding: FragmentCalenderBinding
    val completedDates = ArrayList<CalendarDay>()

    override fun setView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalenderBinding.inflate(inflater!!, container, false)
        return binding.root
    }

    override fun initData() {

    }

    override fun setupUI() {
        val instance = LocalDate.now()
        binding.studentcalendarView.setSelectedDate(instance)
        binding.studentcalendarView.addDecorators(EventDecorator(activity, getEvents()), MySelectorDecorator(activity),
            OneDayDecorator()
        )

        binding.rvstudentAssignment.layoutManager = LinearLayoutManager(context)
        binding.rvstudentAssignment.adapter = studentAssignmentAdapter()

    }

    private fun getEvents(): ArrayList<CalendarDay> {
        var temp: LocalDate = LocalDate.now().minusMonths(2)

        for (i in 0..29) {
            val day = CalendarDay.from(temp)
            completedDates.add(day)
            temp = temp.plusDays(5)
        }

        return completedDates
    }

    override fun setupViewModel() {

    }

    override fun setupObserver() {

    }

    override fun onClicks() {

    }

}