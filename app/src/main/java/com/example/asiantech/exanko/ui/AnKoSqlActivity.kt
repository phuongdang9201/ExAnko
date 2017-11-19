package com.example.asiantech.exanko.ui

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.asiantech.exanko.R
import com.example.asiantech.exanko.db.DBHelper
import com.example.asiantech.exanko.db.DBManager
import com.example.asiantech.exanko.db.FriendTable
import com.example.asiantech.exanko.models.Friends
import com.nightonke.boommenu.BoomButtons.HamButton
import kotlinx.android.synthetic.main.activity_anko_sql.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 13/11/2017.
 */
class AnKoSqlActivity : AppCompatActivity() {


    private val Context.database: DBHelper
        get() = DBHelper.getInstance(applicationContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anko_sql)
        initViews()
        // Init data first
        //initData()

//        val friends: MutableList<Friends.User> = DBManager(database).loadFriends()
//        friends.forEach { Log.d("XXX", "User ${it.id} - ${it.name} - ${it.email}") }
//
//        val use: Friends.User = DBManager(database).detailFriend(friends[1].idFriend.toString())
//        Log.d("XXX", "User = ${use.name} - ${use.email}")
//
//        val delete: Boolean = DBManager(database).deleteFriend(friends[5])
//        Log.d("XXX", "delete  = $delete")

//        val friends1: MutableList<Friends.User> = DBManager(database).loadFriends()
//        friends1.forEach { Log.d("XXX", "User ${it.id} - ${it.name} - ${it.email}") }
    }

    private fun initViews() {
        // Add new student
        val builderNew = HamButton.Builder()
                .normalImageRes(R.drawable.ic_add)
                .imagePadding(Rect(20, 30, 10, 30))
                .normalTextRes(R.string.btn_boom_menu_new)
                .subNormalTextRes(R.string.btn_boom_menu_new_sub)
                .listener {
                    toast("Add Student")
                }
        btnBoomMenu.addBuilder(builderNew)

        // Insert Student with position
        val builderInsert = HamButton.Builder()
                .normalImageRes(R.drawable.ic_insert)
                .imagePadding(Rect(20, 30, 10, 30))
                .normalTextRes(R.string.btn_boom_menu_insert)
                .subNormalTextRes(R.string.btn_boom_menu_insert_sub)
                .listener {
                    toast("Insert Student")
                }
        btnBoomMenu.addBuilder(builderInsert)

        // Clear all student
        val builderClear = HamButton.Builder()
                .normalImageRes(R.drawable.ic_clear)
                .imagePadding(Rect(20, 30, 10, 30))
                .normalTextRes(R.string.btn_boom_menu_clear)
                .subNormalTextRes(R.string.btn_boom_menu_cler_sub)
                .listener {
                    toast("Clear list student")
                }
        btnBoomMenu.addBuilder(builderClear)

        // Fresh all student list
        val builderRefresh = HamButton.Builder()
                .normalImageRes(R.drawable.ic_refresh)
                .imagePadding(Rect(20, 30, 10, 30))
                .normalTextRes(R.string.btn_boom_menu_refresh)
                .subNormalTextRes(R.string.btn_boom_menu_refresh_sub)
                .listener {
                    toast("Refresh student")
                }
        btnBoomMenu.addBuilder(builderRefresh)


        // Get data
//        val friends: MutableList<Friends.User> = DBManager(database).loadFriends()
//        recyclerViewDetailSQl.layoutManager = LinearLayoutManager(this)
//        recyclerViewDetailSQl.adapter = AnKoFriendAdapter(friends) {
//            Log.d("XXX", "Item Click implement")
//        }
//        recyclerViewDetailSQl.adapter.notifyDataSetChanged()

        loadAsync()
    }

    private fun loadAsync() {
        recyclerViewDetailSQl.layoutManager = LinearLayoutManager(this)
        doAsync {
            val friends: MutableList<Friends.User> = mutableListOf()
            friends.addAll(DBManager(database).loadFriends())
            Log.d("XXX", "Size = ${friends.size}")
            activityUiThread {
                Log.d("XXX", "Size = ${friends.size}")
                recyclerViewDetailSQl.adapter = AnKoFriendAdapter(friends) {
                    Log.d("XXX", "Item Click implement")
                }
                recyclerViewDetailSQl.adapter.notifyDataSetChanged()
            }
        }
    }

    private fun initData() {
        for (index in 0..10) {
            insertPost(Friends.User(index.toLong(),
                    "id student$index",
                    "friend $index",
                    "email$index@gmail.com"),
                    database
            )
        }
    }

    private fun insertPost(friends: Friends.User, dbHelper: DBHelper): Boolean = dbHelper.use {
        try {
            beginTransaction()
            val insertedId = insert(FriendTable.TABLE_NAME
                    , FriendTable.ID to friends.id
                    , FriendTable.FRIEND_ID to friends.idFriend
                    , FriendTable.NAME to friends.name
                    , FriendTable.EMAIL to friends.email)

            if (insertedId != -1L) {
                setTransactionSuccessful()
                true
            } else {
                false
                throw RuntimeException("Fail to insert")
            }

        } finally {
            endTransaction()
        }

    }
}


