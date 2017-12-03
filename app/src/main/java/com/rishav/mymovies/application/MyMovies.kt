package com.rishav.mymovies.application

import android.app.Application
import io.realm.Realm

/**
 * Created by Rishab on 12/3/2017.
 */

class MyMovies: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(applicationContext)
    }
}