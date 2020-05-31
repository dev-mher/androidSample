package com.example.androidsample.corepresistenceimpl.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.androidsample.corepersistenceapi.database.DatabaseManagerApi
import com.example.androidsample.corepersistenceapi.dto.HistoryEntity
import com.example.androidsample.corepresistenceimpl.database.DatabaseManagerImpl.Companion.CURRENT_VERSION

@Database(entities = [HistoryEntity::class], version = CURRENT_VERSION)
abstract class DatabaseManagerImpl : RoomDatabase(), DatabaseManagerApi {

    companion object {

        const val CURRENT_VERSION = 1
        private const val DATABASE_NAME = "translate"

        fun build(context: Context): DatabaseManagerApi {
            return Room.databaseBuilder(
                context,
                DatabaseManagerImpl::class.java,
                DATABASE_NAME
            ).build()
        }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }
}