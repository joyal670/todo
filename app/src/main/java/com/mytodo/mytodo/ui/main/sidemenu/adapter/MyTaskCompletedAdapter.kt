package com.mytodo.mytodo.ui.main.sidemenu.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mytodo.mytodo.databinding.RecycleMytaskCompletedListItemBinding


class MyTaskCompletedAdapter : RecyclerView.Adapter<MyTaskCompletedAdapter.ViewHold>()
{
    private var context: Context? = null
    private val taskList1 = listOf(
        "Assignment Deadline",
        "Assignment Deadline",
        "Assignment Deadline",
        "Assignment Deadline",
        "Assignment Deadline",

        )


    class ViewHold(var binding : RecycleMytaskCompletedListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold
    {
        context = parent.context
        val view = RecycleMytaskCompletedListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHold(view)
    }

    override fun getItemCount(): Int
    {
        return taskList1.size
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int)
    {
        holder.binding.MyTaskCompletedAdapterTaskName.paintFlags =
            holder.binding.MyTaskCompletedAdapterTaskName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        holder.binding.MyTaskCompletedAdapterTaskDate.paintFlags =
            holder.binding.MyTaskCompletedAdapterTaskDate.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        holder.binding.MyTaskCompletedAdapterTaskLine.paintFlags =
            holder.binding.MyTaskCompletedAdapterTaskLine.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        holder.binding.MyTaskCompletedAdapterTasktime.paintFlags =
            holder.binding.MyTaskCompletedAdapterTasktime.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        holder.binding.MyTaskCompletedAdapterTaskDesc.paintFlags =
            holder.binding.MyTaskCompletedAdapterTaskDesc.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
}
