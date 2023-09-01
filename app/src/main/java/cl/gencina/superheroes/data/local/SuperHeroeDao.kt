package cl.gencina.superheroes.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperHeroeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : SuperHeroeEntity)

    @Query("UPDATE tabla_super_heroes SET color =:color , traduccion = :traduccion WHERE id = :id" )
    suspend fun update(id: Int, color: String?, traduccion: Boolean? )

    @Query("SELECT * FROM tabla_super_heroes")
    fun getAll(): LiveData<List<SuperHeroeEntity>>

    @Query("SELECT * FROM tabla_super_heroes WHERE id = :id")
    fun getDetail(id:Int): LiveData<SuperHeroeEntity>
}