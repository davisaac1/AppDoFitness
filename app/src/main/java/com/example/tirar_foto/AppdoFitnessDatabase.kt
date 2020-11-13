package com.example.tirar_foto

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Atividade::class], version = 1)
abstract class AppdoFitnessDatabase : RoomDatabase() {

    abstract fun atividadeDao() : AtividadeDAO

    companion object {

        private var database: AppdoFitnessDatabase? = null

        private val DATABASE = "AppdoFitnnesDB"

        fun getInstance(context: Context): AppdoFitnessDatabase? {

            if(database == null)
                return criaBanco(context)
            else
                return database

        }

        private fun criaBanco(context: Context): AppdoFitnessDatabase {
            return Room.databaseBuilder(context, AppdoFitnessDatabase::class.java, DATABASE)
                .allowMainThreadQueries()
                .build()
        }
    }
}