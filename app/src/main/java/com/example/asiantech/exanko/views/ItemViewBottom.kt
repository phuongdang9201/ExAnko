package com.example.asiantech.exanko.views

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.asiantech.exanko.R

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 14/11/2017.
 */
class ItemViewBottom(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvTitleMessage: TextView = itemView.findViewById(R.id.tvShowMessageStep)
    /**
     * bind data bottom for list
     */
    fun bindData() {
        tvTitleMessage.text = "Show next step!"
    }
}