package com.example.asiantech.exanko.views

import android.graphics.Typeface
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.asiantech.exanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 14/11/2017.
 */
class ItemBottomAnKoUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.HORIZONTAL
            // Text show message
            textView("Show next step!") {
                id = R.id.tvShowMessageStep
                ellipsize = TextUtils.TruncateAt.END
                typeface = Typeface.DEFAULT
                singleLine = true
                textSize = 18f
            }.lparams(width = wrapContent, height = wrapContent) {
                leftMargin = dip(10)
                gravity = Gravity.CENTER
                weight = 1f
            }

            // Button next step
            button("Next") {
                typeface = Typeface.DEFAULT
                textSize = 18f
                onClick { toast("Can't go to next step!") }
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                weight = 1f
            }
        }
    }
}