package com.litedevs.cache.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.litedevs.cache.model.CachedMovie
import java.util.*

class Converters {
    private val gson : Gson

    init {
        gson = Gson()
    }

    @TypeConverter
    fun fromJson(data: String?): List<CachedMovie> {
        return if (data == null) Collections.emptyList()
        else gson.fromJson(data, object : TypeToken<List<CachedMovie>>() {}.type)
    }

    @TypeConverter
    fun toJson(someObjects: List<CachedMovie>?): String? {
        return gson.toJson(someObjects)
    }
}