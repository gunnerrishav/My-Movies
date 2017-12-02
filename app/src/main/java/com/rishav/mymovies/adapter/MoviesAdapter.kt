package com.rishav.mymovies.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.rishav.mymovies.R
import com.rishav.mymovies.model.Results
import com.rishav.mymovies.util.ApiConstants
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.movies_list_row.*

/**
 * Created by Rishab on 12/1/2017.
 */
class MoviesAdapter(private val context: Context, private val resultsList: List<Results>) : RecyclerView.Adapter<MoviesAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.movies_list_row, parent, false)
        return RecyclerViewHolder(view, context, resultsList)
    }


    override fun onBindViewHolder(holder: RecyclerViewHolder?, position: Int) {
        val results = resultsList.get(position)
        holder?.textTitle?.text = results.title
        holder?.textOverview?.text = results.overview
        holder?.textReleaseDate?.text = results.releaseDate
        Picasso.with(context)
                .load(ApiConstants.baseUrl + results.backdropPath)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder?.image)

    }

    override fun getItemCount(): Int {
        return resultsList.size
    }

    public class RecyclerViewHolder(view: View, var context: Context, resultsList: List<Results>) : RecyclerView.ViewHolder(view) {
        var resultsList: List<Results> = ArrayList() //why is this done ??
        var textTitle: TextView
        var textOverview: TextView
        var textReleaseDate: TextView
        var image: ImageView

        init {
            this.resultsList = resultsList
            textTitle = view.findViewById<TextView>(R.id.textTitle)
            textOverview = view.findViewById<TextView>(R.id.textOverview)
            textReleaseDate = view.findViewById<TextView>(R.id.textReleaseDate)
            image = view.findViewById<ImageView>(R.id.image)
        }

    }
}