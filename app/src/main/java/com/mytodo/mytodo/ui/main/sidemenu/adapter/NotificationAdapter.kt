package com.mytodo.mytodo.ui.main.sidemenu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mytodo.mytodo.databinding.RecycleNotificationListItemBinding


class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.ViewHold>()
{
    private var context: Context? = null
    private val taskList1 = listOf(
        "Assignment Deadline",
        "Assignment Deadline",
        "Assignment Deadline",
        "Assignment Deadline",
        "Assignment Deadline",

        )


    class ViewHold(var binding : RecycleNotificationListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold
    {
        context = parent.context
        val view = RecycleNotificationListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHold(view)
    }

    override fun getItemCount(): Int
    {
        return taskList1.size
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int)
    {

    }
}