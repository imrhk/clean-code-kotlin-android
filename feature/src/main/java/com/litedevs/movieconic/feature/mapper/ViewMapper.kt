package com.litedevs.movieconic.feature.mapper

interface ViewMapper <P, V> {
    fun mapToView(presentation : P ) : V
}