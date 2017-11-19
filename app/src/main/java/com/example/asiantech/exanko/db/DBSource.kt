package com.example.asiantech.exanko.db

import com.example.asiantech.exanko.models.Friends

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 17/11/2017.
 */
interface DBSource {

    fun saveFriendsList(friend: Friends.User)

    fun loadFriends(): MutableList<Friends.User>

    fun detailFriend(friendsId: String): Friends.User

    fun deleteFriend(friend: Friends.User): Boolean
}