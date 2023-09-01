package cl.gencina.superheroes.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.gencina.superheroes.data.Repositorio
import cl.gencina.superheroes.data.local.SuperHeroeDatabase
import cl.gencina.superheroes.data.remote.Retrofit
import kotlinx.coroutines.launch

class SuperHeroeViewModel (application: Application): AndroidViewModel(application) {
    private var repositorio : Repositorio
    init {
        val api = Retrofit.getRetrofit()
        val database = SuperHeroeDatabase.getDatabase(application).superHeroeDao()
        repositorio = Repositorio(api, database)
    }

    fun getData() = viewModelScope.launch {
        repositorio.cargarListaSuperHeroes()
    }
    fun getDetalle(id:Int) = viewModelScope.launch {
        repositorio.cargarDetalleSuperHeroe(id)
    }

    fun listaSuperHeroesLiveData() = repositorio.getLista()

    fun superHeroeLiveData(id:Int) = repositorio.getDetalle(id)
}
