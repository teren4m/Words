package com.github.teren4m.base

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

private val defaultThreadScheduler: Scheduler = Schedulers.computation()

fun <T> Single<T>.observeOnMain(): Single<T> =
    this.observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.observeOnMain(): Flowable<T> =
    this.observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.observeOnMain(): Observable<T> =
    this.observeOn(AndroidSchedulers.mainThread())

fun Completable.observeOnMain(): Completable =
    this.observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.subscribeOnDefaultThread(): Flowable<T> =
    this.subscribeOn(defaultThreadScheduler)

fun <T> Single<T>.subscribeOnDefaultThread(): Single<T> =
    this.subscribeOn(defaultThreadScheduler)

fun Completable.subscribeOnDefaultThread(): Completable =
    this.subscribeOn(defaultThreadScheduler)