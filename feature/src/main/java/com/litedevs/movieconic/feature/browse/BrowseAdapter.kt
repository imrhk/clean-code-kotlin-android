package com.litedevs.movieconic.feature.browse

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.litedevs.movieconic.feature.R
import com.litedevs.movieconic.feature.model.Movie
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

import javax.inject.Inject

class BrowseAdapter @Inject constructor(context : Context) : RecyclerView.Adapter<BrowseAdapter.ViewHolder>() {

    val roundCornerRadius : Int = context.resources.getDimension(R.dimen.poster_corner_radius).toInt()

    var movies : List<Movie> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]

        holder.titleTextView.text = movie.title

        Glide.with(holder.itemView.context)
                .load("http://image.tmdb.org/t/p/w500/${movie.poster_path}")
                .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(roundCornerRadius, 0)))
                .into(holder.posterImage)
    }

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var posterImage : ImageView
        var titleTextView : TextView

        init {
            posterImage = view.findViewById(R.id.poster)
            titleTextView = view.findViewById(R.id.title)
        }
    }
}