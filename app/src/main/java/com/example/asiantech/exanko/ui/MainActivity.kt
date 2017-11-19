package com.example.asiantech.exanko.ui

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUi().setContentView(this)
    }

    // Define class main activity ui
    class MainActivityUi : AnkoComponent<MainActivity> {

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            // Root layout
            verticalLayout {
                gravity = Gravity.CENTER
                padding = dip(10)

                // Text title
                textView("This is demo test function lib anko sp with kotlin android.") {
                    typeface = Typeface.DEFAULT
                    padding = dip(10)
                    textSize = 18f
                }.lparams(width = matchParent, height = wrapContent) {
                    verticalMargin = dip(5)
                }

                // Button demo anko common
                button("Demo Anko Common") {
                    gravity = Gravity.CENTER
                    textSize = 18f
                    onClick { startActivity<AnKoCommonActivity>() }
                }.lparams(width = matchParent, height = wrapContent) {
                    verticalMargin = dip(5)
                }

                // Button demo anko layout
                button("Demo Anko Layout") {
                    gravity = Gravity.CENTER
                    textSize = 18f
                    onClick { startActivity<AnKoLayoutActivity>() }
                }.lparams(width = matchParent, height = wrapContent) {
                    verticalMargin = dip(5)
                }

                // Button demo anko
                button("Demo Anko Sql") {
                    gravity = Gravity.CENTER
                    textSize = 18f
                    onClick { startActivity<AnKoSqlActivity>() }
                }.lparams(width = matchParent, height = wrapContent) {
                    verticalMargin = dip(5)
                }
            }
        }

    }
}
