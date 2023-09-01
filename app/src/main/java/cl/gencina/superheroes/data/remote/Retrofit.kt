package cl.gencina.superheroes.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    companion object {
        private const val URL_BASE = "https://y-mariocanedo.vercel.app/"

        fun getRetrofit() : SuperHeroesApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(SuperHeroesApi::class.java)
        }
    }
}