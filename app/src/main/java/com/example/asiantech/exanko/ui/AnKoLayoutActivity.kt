package com.example.asiantech.exanko.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.asiantech.exanko.models.Student
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 13/11/2017.
 */
class AnKoLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AnKoLayoutActivityUi().setContentView(this)
    }

    class AnKoLayoutActivityUi : AnkoComponent<AnKoLayoutActivity> {
        override fun createView(ui: AnkoContext<AnKoLayoutActivity>) = with(ui) {
            frameLayout {
                lparams(width = matchParent, height = matchParent)
                recyclerView {
                    layoutManager = LinearLayoutManager(ctx)
                    adapter = AnKoAdapter(getStudents())
                }.lparams(width = matchParent, height = matchParent) {
                    verticalMargin = dip(5)
                }
            }
        }

        private fun getStudents(): MutableList<Student> {
            val students = mutableListOf<Student>()
            (0..10).mapTo(students) {
                Student("Ukttral Zed $it"
                        , 20 + it
                        , "Address $it"
                        , "School $it")
            }
            return students
        }
    }
}