package cl.gencina.superheroes.data

import cl.gencina.superheroes.data.remote.SuperHeroe
import org.junit.Assert.*

import org.junit.Test

class MapperKtTest {

    @Test
    fun toEntity() {

        val heroe = SuperHeroe(1,"nombre", "origen", "imagen", "poder",2000, "azul",false)

        val result = heroe.toEntity()

        assertEquals(heroe.id, result.id)
        assertEquals(heroe.nombre, result.nombre)
        assertEquals(heroe.origen, result.origen)
        assertEquals(heroe.imagenLink, result.imagenLink)
        assertEquals(heroe.poder, result.poder)
        assertEquals(heroe.anio_creacion, result.anioCreacion)
        assertEquals(heroe.color, result.color)
        assertEquals(heroe.traduccion, result.traduccion)
    }
}