package cl.gencina.superheroes.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroesApi {
    @GET("superheroes/")
    suspend fun getAllData(): Response<List<SuperHeroe>>

    @GET("superheroes/{id}/")
    suspend fun getDetail(@Path("id") id: Int): Response<SuperHeroe>
}

