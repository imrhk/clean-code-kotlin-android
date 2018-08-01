package com.litedevs.presentation.resource

class Resource<out T> constructor(val status : ResourceState, val data : T?, val message : String?)