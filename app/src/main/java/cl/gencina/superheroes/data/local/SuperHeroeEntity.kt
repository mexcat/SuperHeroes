package cl.gencina.superheroes.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_super_heroes")
data class SuperHeroeEntity (
    @PrimaryKey val id: Int,
    val nombre:String,
    val origen:String,
    val imagenLink:String,
    val poder:String,
    val anioCreacion:Int,
    val color:String?,
    val traduccion:Boolean?
)