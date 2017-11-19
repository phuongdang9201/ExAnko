package com.example.asiantech.exanko.models

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 16/11/2017.
 */
class Friends {

    var users: MutableList<User>? = null

    class User {
        var idFriend: String? = null
        var name: String? = null
        var email: String? = null
        var id: Long = 0

        constructor(id: Long, idFriend: String, name: String, email: String) {
            this.id = id
            this.idFriend = idFriend
            this.name = name
            this.email = email
        }
    }
}