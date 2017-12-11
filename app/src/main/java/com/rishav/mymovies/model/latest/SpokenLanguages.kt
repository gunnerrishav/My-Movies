package com.rishav.mymovies.model.latest

import com.google.gson.annotations.SerializedName

/**
 * Created by Rishab on 12/11/2017.
 */
data class SpokenLanguages(
        @SerializedName("iso_639_1")
        val iso: String?,

        @SerializedName("name")
        val name: String?
) {
}