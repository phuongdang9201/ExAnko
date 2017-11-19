package com.example.asiantech.exanko.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout
import com.example.asiantech.exanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 13/11/2017.
 */
class AnKoCommonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AnKoCommonActivityUi().setContentView(this)
    }

    class AnKoCommonActivityUi : AnkoComponent<AnKoCommonActivity> {
        override fun createView(ui: AnkoContext<AnKoCommonActivity>) = with(ui) {
            verticalLayout {
                toolbar {
                    lparams(width = matchParent, height = wrapContent)
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    setNavigationIcon(R.drawable.abc_ic_menu_copy_mtrl_am_alpha)

                    // Title text
                    setTitleTextColor(Color.WHITE)
                    title = "Lunch"
                }
                // Text view title
                textView("This demo implement component common of AnKo Kotlin") {
                    typeface = Typeface.DEFAULT
                    textSize = 18f
                }.lparams(width = wrapContent, height = wrapContent) {
                    margin = dip(10)
                    gravity = Gravity.CENTER
                }
                // Show snack bar
                button("SnackBar") {
                    onClick {
                        snackbar(this@button, "message", "Show Detail") { toast("Message show error!") }
                    }
                }.lparams(width = matchParent, height = wrapContent) {
                    verticalMargin = dip(10)
                    gravity = Gravity.CENTER
                }
                // Show alert dialog
                button("Alert Dialog") {
                    onClick {
                        alert("Dialog confirm") {
                            yesButton { toast("Test success!") }
                            noButton { toast("Cancel progress!") }
                        }.show()
                    }
                }.lparams(width = matchParent, height = wrapContent) {
                    verticalMargin = dip(10)
                    gravity = Gravity.CENTER
                }

                // Show custom dialog
                button("Custom dialog") {
                    onClick {
                        alert {
                            customTitle {
                                linearLayout {
                                    orientation = LinearLayout.HORIZONTAL
                                    imageView(R.drawable.ic_setting_select)
                                    textView("Dialog Custom")
                                }
                            }

                            customView {
                                verticalLayout {
                                    linearLayout {
                                        orientation = LinearLayout.HORIZONTAL
                                        textView("Email : ")
                                        editText("Enter Your Email")
                                                .lparams(width = matchParent, height = wrapContent)
                                    }
                                    linearLayout {
                                        orientation = LinearLayout.HORIZONTAL
                                        textView("Pass : ")
                                        editText("Enter Your Password")
                                                .lparams(width = matchParent, height = wrapContent)
                                    }
                                    button("Login")
                                            .lparams(width = matchParent, height = wrapContent)
                                            .onClick { this@alert.onCancelled { } }
                                }

                            }
                        }.show()
                    }
                }.lparams(width = matchParent, height = wrapContent) {
                    verticalMargin = dip(10)
                    gravity = Gravity.CENTER
                }

                // Button show selector
                button("Show Selector") {
                    onClick {
                        val items = mutableListOf("Android", "Java", "Kotlin", "Object C")
                        selector("Language your develop?", items, { dialogInterface, i -> toast("Developer ${items[i]}") })
                    }
                }.lparams(width = matchParent, height = wrapContent) {
                    gravity = Gravity.CENTER
                }

                // Button show progress dialog
                button("Show progress dialog") {
                    onClick {
                        progressDialog("Please watting ..", "Fetching data")
                    }
                }.lparams(width = matchParent, height = wrapContent) {
                    verticalMargin = dip(10)
                    gravity = Gravity.CENTER
                }
            }

        }
    }
}