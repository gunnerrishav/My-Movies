package com.rishav.mymovies.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Rishab on 12/1/2017.
 */
data class Dates(
        @SerializedName("maximum")
        val maximum: String?,

        @SerializedName("minimum")
        val minimum: String?
)
