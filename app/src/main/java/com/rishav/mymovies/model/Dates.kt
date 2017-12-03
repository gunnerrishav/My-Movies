package com.rishav.mymovies.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

/**
 * Created by Rishab on 12/1/2017.
 */

open class Dates: RealmObject(){
        @SerializedName("maximum")
        var maximum: String? = null

        @SerializedName("minimum")
        var minimum: String? = null
}
