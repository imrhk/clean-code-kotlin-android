package com.litedevs.domain.interactor.browse

import com.litedevs.domain.executor.PostExecutionThread
import com.litedevs.domain.interactor.ObservableUseCase
import com.litedevs.domain.repository.MovieRepository
import io.reactivex.Observable
import model.TMovie
import javax.inject.Inject

class GetTopMovies @Inject constructor(
        private val moviesRepository: MovieRepository,
        postExecutionThread: PostExecutionThread) : ObservableUseCase<List<TMovie>, Nothing>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Nothing?): Observable<List<TMovie>> {
        return moviesRepository.getTopMovies()
    }

}
