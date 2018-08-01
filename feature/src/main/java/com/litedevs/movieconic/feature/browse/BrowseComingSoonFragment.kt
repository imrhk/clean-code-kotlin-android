package com.litedevs.movieconic.feature.browse

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.litedevs.movieconic.feature.R
import com.litedevs.presentation.browse.BrowseComingSoonViewModel
import com.litedevs.presentation.browse.BrowseLatestTrailersViewModel
import com.litedevs.presentation.browse.BrowseMovieViewModel
import javax.inject.Inject

class BrowseComingSoonFragment : BrowseFragment() {
    override var browseViewModel: BrowseMovieViewModel
        get() = browseComingSoonViewModel
        set(value) {}

    @Inject
    lateinit var browseComingSoonViewModel: BrowseComingSoonViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textView).text = resources.getString(R.string.coming_soon)
    }
    
}