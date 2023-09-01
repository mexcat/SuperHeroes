package cl.gencina.superheroes.data.remote

import com.google.gson.annotations.SerializedName

data class SuperHeroe(
    val id: Int,
    val nombre:String,
    val origen:String,
    val imagenLink:String,
    val poder:String,
    @SerializedName("Año_creacion") val anio_creacion:Int,
    val color:String?,
    val traduccion:Boolean?

)
