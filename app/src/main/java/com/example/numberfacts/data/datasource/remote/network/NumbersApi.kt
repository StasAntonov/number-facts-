package com.example.numberfacts.data.datasource.remote.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NumbersApi {

    @GET("{$NUMBER}")
    suspend fun getNumberFact(
        @Path(NUMBER) number: Long
    ): Response<String>

    @GET(RANDOM)
    suspend fun getRandomNumberFact(): Response<String>

    companion object {
        const val  NUMBER = "number"
        const val  RANDOM = "random"
    }

}