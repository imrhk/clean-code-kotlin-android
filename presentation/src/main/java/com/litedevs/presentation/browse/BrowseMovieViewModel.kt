package com.litedevs.presentation.browse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.litedevs.domain.interactor.ObservableUseCase
import com.litedevs.presentation.mapper.MovieViewMapper
import com.litedevs.presentation.model.MovieView
import com.litedevs.presentation.resource.Resource
import com.litedevs.presentation.resource.ResourceState
import io.reactivex.observers.DisposableObserver
import model.TMovie

abstract class BrowseMovieViewModel constructor(
        private val getMovies: ObservableUseCase<List<TMovie>, Nothing>,
        private val movieViewMapper: MovieViewMapper) : ViewModel() {
    private val liveData : MutableLiveData<Resource<List<MovieView>>> = MutableLiveData()

    override fun onCleared() {
        getMovies.dispose()
        super.onCleared()
    }

    fun getMovie() : LiveData<Resource<List<MovieView>>> {
        return liveData
    }

    fun fetchMovie() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getMovies.execute(MovieSubscriber())
    }

    inner class MovieSubscriber : DisposableObserver<List<TMovie>>() {
        override fun onComplete() {
            println("Complete!")
        }

        override fun onNext(t: List<TMovie>) {
            liveData.postValue(Resource(ResourceState.SUCCESS, t.map { movieViewMapper.mapToView(it) }, null))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }

    }

}