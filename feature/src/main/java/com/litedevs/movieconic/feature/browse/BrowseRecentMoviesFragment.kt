package com.litedevs.movieconic.feature.browse

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.litedevs.movieconic.feature.R
import com.litedevs.presentation.browse.BrowseMovieViewModel
import com.litedevs.presentation.browse.BrowseRecentMovieViewModel
import javax.inject.Inject

class BrowseRecentMoviesFragment : BrowseFragment() {
    override var browseViewModel: BrowseMovieViewModel
        get() = browseRecentMovieViewModel
        set(value) {}

    @Inject
    lateinit var browseRecentMovieViewModel: BrowseRecentMovieViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textView).text = resources.getString(R.string.recent)
    }
}