package com.mytodo.mytodo.ui.main.sidemenu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexboxLayoutManager
import com.mytodo.mytodo.databinding.RecycleDashboardListItemBinding
import java.util.*


class DashBoardAdapter : RecyclerView.Adapter<DashBoardAdapter.ViewHold>() {
    private var context: Context? = null
    private val taskList1 = listOf(
        "lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_sed_do",
        "lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_sed_do_eiusmod_tempor_incididunt_ut_labore_et_dolore_magna_aliqua_ut_enim_ad_minim_veniam_quis_nostrud_exercitation_ullamco_laboris_nisi_ut_aliquip_ex_ea_commodo_consequat_duis_aute_irure_dolor_in_reprehenderit_in_voluptate_velit_esse_cillum_dolore_eu_fugiat_nulla_pariatur",
        "tempor_incididunt_ut_labore_et_dolore_magna_aliqua_ut_enim_ad_minim_veniam_quis_nostrud_exer",
        "Assignment Deadline",
        "Deadline",
        "agna_aliqua_ut_enim_ad_minim_veniam_quis_nostrud_exercitation_ullamco_laboris_nisi_ut_aliquip"
        )


    class ViewHold(var binding: RecycleDashboardListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        context = parent.context
        val view =
            RecycleDashboardListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHold(view)
    }

    override fun getItemCount(): Int {
        return taskList1.size
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int)
    {
        val lp: ViewGroup.LayoutParams = holder.binding.imageCard.layoutParams

        if (lp is FlexboxLayoutManager.LayoutParams) {
            val random = Random()
            var `val`: Int = random.nextInt(5)
            if (`val` == 0) {
                `val` = 1
            }
            lp.flexGrow = `val`.toFloat()
            lp.flexShrink = 1f
        }
        holder.binding.rvDashboardDes.text = taskList1[position]
    }
}
