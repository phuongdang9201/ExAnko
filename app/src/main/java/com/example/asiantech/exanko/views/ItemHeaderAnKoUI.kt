package com.example.asiantech.exanko.views

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.asiantech.exanko.R
import org.jetbrains.anko.*

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 14/11/2017.
 */
class ItemHeaderAnKoUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        relativeLayout {

            // ImageView background
            imageView(R.drawable.bg_navigation) {
                scaleType = ImageView.ScaleType.CENTER_CROP
            }.lparams(width = matchParent, height = dip(200))

            // TextView title
            textView("Item Header") {
                id = R.id.tvTitleHeader
                typeface = Typeface.DEFAULT
                textSize = 18f
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
            }
        }
    }
}