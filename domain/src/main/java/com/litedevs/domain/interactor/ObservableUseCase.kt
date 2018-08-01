package com.litedevs.domain.interactor

import com.litedevs.domain.executor.PostExecutionThread
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class ObservableUseCase<T, in Params> constructor(
        private val postExecutionThread: PostExecutionThread){

    private val disposables = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(params : Params? = null ) : Observable<T>

    open fun execute(observer: DisposableObserver<T>, params: Params?  = null) {

        val scheduler : Scheduler = when {
            false ->
                Schedulers.io()
            else ->
                postExecutionThread.scheduler
        }
        val observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
        addDisposable(observable.subscribeWith(observer))
    }

    fun dispose() {
        disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}