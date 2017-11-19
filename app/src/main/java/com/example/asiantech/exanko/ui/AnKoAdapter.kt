package com.example.asiantech.exanko.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.asiantech.exanko.models.Student
import com.example.asiantech.exanko.views.*
import org.jetbrains.anko.AnkoContext

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 13/11/2017.
 */
class AnKoAdapter(private var students: MutableList<Student>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER = 1
    private val TYPE_BOTTOM = 2
    private val TYPE_VIEW_ITEM = 3
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (holder) {
            is ItemViewHeader -> holder.bindData()
            is ItemViewBottom -> holder.bindData()
            else -> (holder as ItemViewHolder).bindData(students[position])
        }
    }

    override fun getItemCount(): Int = students.size

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            students.size - 1 -> TYPE_BOTTOM
            else -> TYPE_VIEW_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        return when (viewType) {
            TYPE_HEADER -> ItemViewHeader(ItemHeaderAnKoUI().createView(AnkoContext.create(parent!!.context, parent)))
            TYPE_BOTTOM -> ItemViewBottom(ItemBottomAnKoUI().createView(AnkoContext.create(parent!!.context, parent)))
            else -> ItemViewHolder(ItemViewAnKoUI().createView(AnkoContext.create(parent!!.context, parent)))
        }
    }
}