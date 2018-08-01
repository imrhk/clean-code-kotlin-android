package com.litedevs.movieconic.feature.browse

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.litedevs.movieconic.feature.R
import com.litedevs.presentation.browse.BrowseLatestTrailersViewModel
import com.litedevs.presentation.browse.BrowseMovieViewModel
import com.litedevs.presentation.browse.BrowseTopMovieViewModel
import javax.inject.Inject

class BrowseTopMoviesFragment : BrowseFragment() {
    override var browseViewModel: BrowseMovieViewModel
        get() = browseTopMovieViewModel
        set(value) {}

    @Inject
    lateinit var browseTopMovieViewModel: BrowseTopMovieViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textView).text = resources.getString(R.string.top)
    }
}