package cl.gencina.superheroes.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SuperHeroeEntity::class], version = 1)
abstract class SuperHeroeDatabase : RoomDatabase() {
    abstract fun superHeroeDao(): SuperHeroeDao

    companion object{
        @Volatile
        private var INSTANCE: SuperHeroeDatabase? = null

        fun getDatabase(context: Context):SuperHeroeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SuperHeroeDatabase::class.java,
                    "super_heroes_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}