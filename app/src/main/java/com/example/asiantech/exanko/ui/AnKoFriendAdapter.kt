package com.example.asiantech.exanko.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.asiantech.exanko.R
import com.example.asiantech.exanko.models.Friends

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 17/11/2017.
 */
class AnKoFriendAdapter(private var friends: MutableList<Friends.User>, private val itemClick: (Friends.User) -> Unit) : RecyclerView.Adapter<AnKoFriendAdapter.FriendViewHolder>() {

    override fun onBindViewHolder(holder: FriendViewHolder?, position: Int) {
        holder!!.bindData(friends[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list_friend, parent, false)
        return FriendViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = friends.size

    class FriendViewHolder(itemView: View?, private val itemClick: (Friends.User) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val tvUserName: TextView = itemView!!.findViewById(R.id.tvUserName)
        private val tvEmailAddress: TextView = itemView!!.findViewById(R.id.tvEmail)
        private val tvIdStudent: TextView = itemView!!.findViewById(R.id.tvIdFriend)
        private val btnDelete: ImageView = itemView!!.findViewById(R.id.imgDelete)

        fun bindData(friend: Friends.User) {

            with(friend) {
                tvUserName.text = friend.name
                tvIdStudent.text = friend.id.toString()
                tvEmailAddress.text = friend.email
                btnDelete.setOnClickListener { itemClick(this) }
            }
        }
    }
}