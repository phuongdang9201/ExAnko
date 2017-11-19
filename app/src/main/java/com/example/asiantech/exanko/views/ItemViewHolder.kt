package com.example.asiantech.exanko.views

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.asiantech.exanko.R
import com.example.asiantech.exanko.models.Student

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 13/11/2017.
 */
class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvUserAge: TextView = itemView.findViewById(R.id.tvUserAge)
    private val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
    private val tvUserSchool: TextView = itemView.findViewById(R.id.tvUserSchool)
    private val tvUserAddress: TextView = itemView.findViewById(R.id.tvUerAddress)

    /**
     * bind data for list item
     */
    fun bindData(student: Student) {
        tvUserName.text = student.name
        tvUserSchool.text = student.school
        tvUserAddress.text = student.address
        tvUserAge.text = student.age.toString()
    }
}
