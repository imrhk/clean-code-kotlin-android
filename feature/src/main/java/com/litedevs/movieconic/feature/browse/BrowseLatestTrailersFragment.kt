package com.litedevs.movieconic.feature.browse

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.litedevs.movieconic.feature.R
import com.litedevs.presentation.browse.BrowseLatestTrailersViewModel
import com.litedevs.presentation.browse.BrowseMovieViewModel
import javax.inject.Inject

class BrowseLatestTrailersFragment : BrowseFragment() {
    override var browseViewModel: BrowseMovieViewModel
        get() = browseTrailersViewModel
        set(value) {}

    @Inject
    lateinit var browseTrailersViewModel: BrowseLatestTrailersViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textView).text = resources.getString(R.string.latest_trailers)
    }
}