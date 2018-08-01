package com.litedevs.remote.mapper

interface ModelMapper<M, E> {
    fun mapFromModel(model : M) :E

}