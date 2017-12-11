package com.rishav.mymovies.model.latest

import com.google.gson.annotations.SerializedName

/**
 * Created by Rishab on 12/11/2017.
 */
data class ProductionCountries(
        @SerializedName("iso_3166_1")
        val iso: String?,

        @SerializedName("name")
        val name: String?
) {
}