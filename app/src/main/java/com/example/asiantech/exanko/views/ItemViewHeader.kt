package com.example.asiantech.exanko.views

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.asiantech.exanko.R

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 14/11/2017.
 */
class ItemViewHeader(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvTitleHeader = itemView.findViewById<TextView>(R.id.tvTitleHeader)

    /**
     *  bind data header of list
     */
    fun bindData() {
        tvTitleHeader.text = "TITLE ITEM HEADER"
    }
}