package com.litedevs.movieconic.feature.browse

import android.os.Bundle
import com.litedevs.movieconic.feature.R
import dagger.android.support.DaggerAppCompatActivity

class BrowseActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
