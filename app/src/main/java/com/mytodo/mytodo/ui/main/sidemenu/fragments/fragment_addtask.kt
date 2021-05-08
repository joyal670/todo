package com.mytodo.mytodo.ui.main.sidemenu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.mytodo.mytodo.R
import com.mytodo.mytodo.base.BaseFragment

import com.mytodo.mytodo.databinding.FragmentAddtaskBinding
import com.mytodo.mytodo.utils.replaceFragment
import java.text.SimpleDateFormat
import java.util.*


class fragment_addtask : BaseFragment()
{
    private lateinit var binding: FragmentAddtaskBinding
    val Time = arrayOf(
        "1:00am",
        "1:15am",
        "1:30am",
        "1:45am",
        "2:00am",
        "2:15am",
        "2:30am",
        "2:45am",
        "3:00am",
        "3:15am",
        "3:30am",
        "3:45am",
        "4:00am",
        "4:15am",
        "4:30am",
        "4:45am",
        "5:00am",
        "5:15am",
        "5:30am",
        "5:45am",
        "6:00am",
        "6:15am",
        "6:30am",
        "6:45am",
        "7:00am",
        "7:15am",
        "7:30am",
        "7:45am",
        "8:00am",
        "8:15am",
        "8:30am",
        "8:45am",
        "9:00am",
        "9:15am",
        "9:30am",
        "10:00am",
        "10:15am",
        "10:45am",
        "11:00am",
        "11:15am",
        "11:30am",
        "11:45am",
        "12:00pm",
        "12:15pm",
        "12:30pm",
        "12:45pm",
        "1:00pm",
        "1:15pm",
        "1:30pm",
        "1:45pm",
        "2:00pm",
        "2:15pm",
        "2:30pm",
        "2:45pm",
        "3:00pm",
        "3:15pm",
        "3:30pm",
        "3:45pm",
        "4:15pm",
        "4:30pm",
        "4:45pm",
        "5:00pm",
        "5:15pm",
        "5:30pm",
        "5:45pm",
        "6:00pm",
        "6:15pm",
        "6:30pm",
        "6:45pm",
        "7:00pm",
        "7:15pm",
        "7:30pm",
        "7:45pm",
        "8:00pm",
        "8:15pm",
        "8:30pm",
        "8:45pm",
        "9:00pm",
        "9:15pm",
        "9:30pm",
        "9:45pm",
        "10:00pm",
        "10:15pm",
        "10:30pm",
        "10:45pm",
        "11:00pm",
        "11:15pm",
        "11:30pm",
        "11:45pm"
    )

    override fun setView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddtaskBinding.inflate(inflater!!, container, false)
        return binding.root
    }

    override fun initData() {
    }

    override fun setupUI() {

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, Time)
        val sdf = SimpleDateFormat("EEE, MMM d, yyyy", Locale.getDefault())
        val currentDate = sdf.format(Date())

        val bottom = BottomSheetDialog(requireContext(),  R.style.ThemeOverlay_App_BottomSheetDialog)
        bottom.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottom.behavior.peekHeight = 300
        bottom.setCancelable(false)
        val bottomSheet : View = this.layoutInflater.inflate(R.layout.layout_addtask, null)

        val close =  bottomSheet.findViewById<ImageView>(R.id.ivClose)
        val current_date = bottomSheet.findViewById(R.id.tvcurrent_date) as TextView
        val StartTime = bottomSheet.findViewById(R.id.selectStartTime) as Spinner
        val EndTime = bottomSheet.findViewById(R.id.selectEndTime) as Spinner
        val btAddTask = bottomSheet.findViewById(R.id.btAddTask) as MaterialButton

        current_date.text = currentDate

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        StartTime.adapter = adapter
        EndTime.adapter = adapter

        close.setOnClickListener {
            bottom.dismiss()
            activity?.onBackPressed()
        }

        btAddTask.setOnClickListener {
            bottom.dismiss()
            activity?.onBackPressed()
        }

        bottom.setContentView(bottomSheet)
        bottom.show()
    }

    override fun setupViewModel() {
    }

    override fun setupObserver() {
    }

    override fun onClicks() {
    }

}