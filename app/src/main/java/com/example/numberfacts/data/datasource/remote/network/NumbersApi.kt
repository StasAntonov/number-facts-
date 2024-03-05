package com.example.numberfacts.data.datasource.remote.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NumbersApi {

    @GET("{number}")
    suspend fun getNumberFact(
        @Path("number") number: Long
    ): Response<String>

    @GET("random")
    suspend fun getRandomNumberFact(): Response<String>

}