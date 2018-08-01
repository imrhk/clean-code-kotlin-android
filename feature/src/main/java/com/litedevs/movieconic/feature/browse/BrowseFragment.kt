package com.litedevs.movieconic.feature.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.litedevs.movieconic.feature.R
import com.litedevs.movieconic.feature.injection.ViewModelFactory
import com.litedevs.movieconic.feature.mapper.MovieViewMapper
import com.litedevs.movieconic.feature.model.Movie
import com.litedevs.presentation.browse.BrowseMovieViewModel
import com.litedevs.presentation.model.MovieView
import com.litedevs.presentation.resource.Resource
import com.litedevs.presentation.resource.ResourceState
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_browse.*
import javax.inject.Inject

abstract class BrowseFragment : DaggerFragment() {
    @Inject
    lateinit var browseAdapter: BrowseAdapter
    @Inject
    lateinit var mapper: MovieViewMapper
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    abstract var browseViewModel: BrowseMovieViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_browse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        browseViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(BrowseMovieViewModel::class.java)

        setupBrowserRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        browseViewModel.getMovie().observe(this, Observer<Resource<List<MovieView>>> {
            it?.let {
                handleDataState(it)
            }
        })

        browseViewModel.fetchMovie()
    }

    private fun setupBrowserRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = browseAdapter
    }

    private fun handleDataState(resource: Resource<List<MovieView>>) {
        when (resource.status) {
            ResourceState.SUCCESS -> {
                setupScreenForSuccess(resource.data?.map {
                    mapper.mapToView(it)
                })
            }
            ResourceState.LOADING -> {
                progressBar.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }
            ResourceState.ERROR -> {
                progressBar.visibility = View.GONE
                recyclerView.visibility = View.GONE
            }
        }
    }

    private fun setupScreenForSuccess(projects: List<Movie>?) {
        progressBar.visibility = View.GONE
        projects?.let {
            browseAdapter.movies = it
            browseAdapter.notifyDataSetChanged()
            recyclerView.visibility = View.VISIBLE
        } ?: run {

        }

    }
}