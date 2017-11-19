package com.example.asiantech.exanko.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.asiantech.exanko.MainApplication
import org.jetbrains.anko.db.*

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 16/11/2017.
 */
class DBHelper(context: Context = MainApplication.instance) : ManagedSQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {

        @JvmField
        val DB_VERSION = 1

        @JvmField
        val DB_NAME = "dbFriend"

        private var instance: DBHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DBHelper {
            if (instance == null) {
                instance = DBHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    /**
     * Create data base
     */
    override fun onCreate(db: SQLiteDatabase?) {

        db!!.createTable(FriendTable.TABLE_NAME,
                true,
                FriendTable.ID to INTEGER + PRIMARY_KEY,
                FriendTable.FRIEND_ID to TEXT,
                FriendTable.NAME to TEXT,
                FriendTable.EMAIL to TEXT
        )
    }

    /**
     * up grade data base
     */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db!!.dropTable("User", true)
    }
}
