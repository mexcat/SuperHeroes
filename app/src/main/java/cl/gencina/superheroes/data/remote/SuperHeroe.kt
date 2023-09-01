package cl.gencina.superheroes.data.remote

data class SuperHeroe(
    val id: Int,
    val nombre:String,
    val origen:String,
    val imagenLink:String,
    val poder:String,
    val anioCreacion:Int,
    val color:String?,
    val traduccion:Boolean?

)
