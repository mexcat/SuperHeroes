package cl.gencina.superheroes.data

import cl.gencina.superheroes.data.local.SuperHeroeEntity
import cl.gencina.superheroes.data.remote.SuperHeroe

fun SuperHeroe.toEntity(): SuperHeroeEntity = SuperHeroeEntity(this.id,this.nombre,this.origen,this.imagenLink,this.poder, this.Año_creacion,  this.color,this.traduccion)
