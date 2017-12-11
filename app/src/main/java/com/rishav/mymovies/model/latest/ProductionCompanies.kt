package com.rishav.mymovies.model.latest

import com.google.gson.annotations.SerializedName

/**
 * Created by Rishab on 12/11/2017.
 */
data class ProductionCompanies(
        @SerializedName("name")
        val name: String?,

        @SerializedName("id")
        val id: Int?
) {
}