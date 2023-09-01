package cl.gencina.superheroes.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.gencina.superheroes.data.local.SuperHeroeDao
import cl.gencina.superheroes.data.local.SuperHeroeEntity
import cl.gencina.superheroes.data.remote.SuperHeroesApi

class Repositorio(private val superHeroesApi : SuperHeroesApi, private val superHeroesDao: SuperHeroeDao) {

    suspend fun cargarListaSuperHeroes(){
        val response = superHeroesApi.getAllData()
        if(response.isSuccessful){
            val data = response.body()
            data?.let {superHeroList ->
                superHeroList.map{
                    superHeroesDao.insert(it.toEntity())
                }
            }
        }else{
            Log.e("repositorioError", response.body().toString())
        }
    }


    suspend fun cargarDetalleSuperHeroe(id:Int){
        val response = superHeroesApi.getDetail(id)
        if(response.isSuccessful){
            val data = response.body()
            data?.let { superHeroesDao.update(it.id, it.color, it.traduccion) }
        }else{
            Log.e("repositorioError", response.body().toString())
        }
    }

    fun getLista() : LiveData<List<SuperHeroeEntity>> = superHeroesDao.getAll()

    fun getDetalle(id: Int) : LiveData<SuperHeroeEntity> = superHeroesDao.getDetail(id)

}