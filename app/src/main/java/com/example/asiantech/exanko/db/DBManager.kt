package com.example.asiantech.exanko.db

import android.util.Log
import com.example.asiantech.exanko.models.Friends
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 17/11/2017.
 */
class DBManager(private var dbHelper: DBHelper) : DBSource {

    /**
     * Save user for data base
     */
    override fun saveFriendsList(friend: Friends.User) {
        try {
            insertPost(friend)
        } catch (e: Throwable) {
            Log.d("XXX", "Error ! ${e.message}")
        }
    }

    /**
     * Insert user for table
     */
    private fun insertPost(friend: Friends.User): Boolean = dbHelper.use {
        try {
            beginTransaction()
            val insertedId = insert(FriendTable.TABLE_NAME,
                    FriendTable.ID to friend.id,
                    FriendTable.FRIEND_ID to friend.idFriend,
                    FriendTable.NAME to friend.name,
                    FriendTable.EMAIL to friend.email)
            if (insertedId == -1L) {
                setTransactionSuccessful()
                true
            } else {
                throw RuntimeException("Fail to insert")
            }
        } finally {
            endTransaction()
        }
    }

    /**
     * Load list friends from data base
     */
    override fun loadFriends(): MutableList<Friends.User> {
        val friends: MutableList<Friends.User> = mutableListOf()
        dbHelper.use {
            select(FriendTable.TABLE_NAME).parseList(object : MapRowParser<MutableList<Friends.User>> {
                override fun parseRow(columns: Map<String, Any?>): MutableList<Friends.User> {
                    val id: Long = columns.getValue(FriendTable.ID) as Long
                    val idFriend = columns.getValue(FriendTable.FRIEND_ID)
                    val name = columns.getValue(FriendTable.NAME)
                    val email = columns.getValue(FriendTable.EMAIL)
                    val user = Friends.User(id, idFriend.toString(), name.toString(), email.toString())
                    friends.add(user)
                    return friends
                }
            })
        }
        return friends
    }

    /**
     * Show detail user friend
     */
    override fun detailFriend(friendsId: String): Friends.User {
        var user: Friends.User? = null
        dbHelper.use {
            select(FriendTable.TABLE_NAME)
                    .whereSimple("${FriendTable.FRIEND_ID} = ?", friendsId)
                    .parseOpt(object : MapRowParser<Friends.User> {
                        override fun parseRow(columns: Map<String, Any?>): Friends.User {
                            val id: Long = columns.getValue(FriendTable.ID) as Long
                            val idFriend = columns.getValue(FriendTable.FRIEND_ID)
                            val name = columns.getValue(FriendTable.NAME)
                            val email = columns.getValue(FriendTable.EMAIL)
                            user = Friends.User(id, idFriend.toString(), name.toString(), email.toString())
                            return user!!
                        }
                    })
        }
        return user!!
    }

    /**
     * delete user in table friend
     */
    override fun deleteFriend(friend: Friends.User): Boolean {
        var isDelete: Boolean? = null
        dbHelper.use {
            try {
                beginTransaction()
                val result = delete(FriendTable.TABLE_NAME,
                        "${FriendTable.ID} = {_id}",
                        "_id" to friend.id) > 0
                isDelete = if (result) {
                    setTransactionSuccessful()
                    true
                } else {
                    false
                }
            } catch (e: Throwable) {
                isDelete = true
                Log.d("XXX", "Error! ${e.message}")
            } finally {
                endTransaction()
            }
        }
        return isDelete!!
    }
}