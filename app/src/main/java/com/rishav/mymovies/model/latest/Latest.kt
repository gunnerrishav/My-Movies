package com.rishav.mymovies.model.latest

import com.google.gson.annotations.SerializedName

/**
 * Created by Rishab on 12/11/2017.
 */
data class Latest(
        @SerializedName("adult")
        val adult: Boolean?,

//        @SerializedName("backdrop_path")
//        val backdropPath: NullPointerException,

//        @SerializedName("belongs_to_collection")
//        val belongsToCollection: NullPointerException,

        @SerializedName("budget")
        val budget: Int?,

        @SerializedName("genres")
        val genres: List<Genres>?,

        @SerializedName("homepage")
        val homepage: String?,

        @SerializedName("id")
        val id: Int?,

//        @SerializedName("imdb_id")
//        val imdbId: NullPointerException?,

        @SerializedName("original_language")
        val originalLanguage: String?,

        @SerializedName("original_title")
        val originalTitle: String?,

        @SerializedName("overview")
        val overview: String?,

        @SerializedName("popularity")
        val popularity: Int?,

//        @SerializedName("poster_path")
//        val posterPath: NullPointerException,

        @SerializedName("production_companies")
        val productionCompanies: List<ProductionCompanies>?,

        @SerializedName("production_countries")
        val productionCountries: List<ProductionCountries>?,

        @SerializedName("release_date")
        val releaseDate: String?,

        @SerializedName("revenue")
        val revenue: Int?,

        @SerializedName("runtime")
        val runtime: Int?,

        @SerializedName("spoken_languages")
        val spokenLanguages: List<SpokenLanguages>?,

        @SerializedName("status")
        val status: String?,

        @SerializedName("tagline")
        val tagline: String?,

        @SerializedName("title")
        val title: String?,

        @SerializedName("video")
        val video: Boolean?,

        @SerializedName("vote_average")
        val voteAverage: Int?,

        @SerializedName("vote_count")
        val voteCount: Int?
) {
}