package com.example.asiantech.exanko.views

import android.graphics.Color
import android.graphics.Typeface
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.asiantech.exanko.R
import org.jetbrains.anko.*

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 13/11/2017.
 */
class ItemViewAnKoUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        relativeLayout {
            // Image user
            imageView(R.drawable.ic_teacher) {
                id = R.id.imgUser
                scaleType = ImageView.ScaleType.CENTER_INSIDE
            }.lparams(width = wrapContent, height = wrapContent) {
                margin = dip(10)
                centerVertically()
            }

            // Text user name
            textView("Student name") {
                id = R.id.tvUserName
                ellipsize = TextUtils.TruncateAt.END
                typeface = Typeface.DEFAULT
                textColor = Color.BLUE
                singleLine = true
                textSize = 12f
            }.lparams(width = wrapContent, height = wrapContent) {
                rightMargin = dip(10)
                rightOf(R.id.imgUser)
            }

            // Text age user
            textView(" Age : 20") {
                id = R.id.tvUserAge
                ellipsize = TextUtils.TruncateAt.END
                typeface = Typeface.DEFAULT
                textColor = Color.RED
                singleLine = true
                textSize = 12f
            }.lparams(width = wrapContent, height = wrapContent) {
                rightMargin = dip(10)
                rightOf(R.id.tvUserName)
            }

            // Text Address
            textView("Address : Da Nang") {
                id = R.id.tvUerAddress
                typeface = Typeface.DEFAULT
                singleLine = false
                textSize = 12f
                maxLines = 2
            }.lparams(width = wrapContent, height = wrapContent) {
                rightMargin = dip(10)
                below(R.id.tvUserName)
                rightOf(R.id.imgUser)
            }

            // Text School
            textView("DHBK") {
                id = R.id.tvUserSchool
                ellipsize = TextUtils.TruncateAt.END
                typeface = Typeface.DEFAULT
                singleLine = true
                textSize = 12f
            }.lparams(width = wrapContent, height = wrapContent) {
                rightMargin = dip(10)
                below(R.id.tvUerAddress)
                rightOf(R.id.imgUser)
            }
        }
    }
}