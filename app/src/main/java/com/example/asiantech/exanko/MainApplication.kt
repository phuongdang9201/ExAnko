package com.example.asiantech.exanko

import android.app.Application

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 13/11/2017.
 */
class MainApplication : Application() {

    companion object {
        lateinit var instance: MainApplication private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
