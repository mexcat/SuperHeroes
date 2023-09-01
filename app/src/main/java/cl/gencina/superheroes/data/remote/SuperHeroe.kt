package cl.gencina.superheroes.data.remote

data class SuperHeroe(
    val id: Int,
    val nombre:String,
    val origen:String,
    val imagenLink:String,
    val poder:String,
    val Año_creacion:Int,
    val color:String?,
    val traduccion:Boolean?

)
