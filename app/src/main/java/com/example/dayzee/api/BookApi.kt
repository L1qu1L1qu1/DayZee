package com.example.dayzee.api

import retrofit2.Response
import retrofit2.http.GET

interface BookApi {
    @GET("api/books")
    suspend fun getBooks():List<Books>
}