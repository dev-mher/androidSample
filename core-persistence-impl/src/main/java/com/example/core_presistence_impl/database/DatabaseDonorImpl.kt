package com.example.core_presistence_impl.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.core_persistence_api.database.DatabaseDonorApi
import com.example.core_persistence_api.dto.HistoryEntity
import com.example.core_presistence_impl.database.DatabaseDonorImpl.Companion.CURRENT_VERSION

@Database(entities = [HistoryEntity::class], version = CURRENT_VERSION)
abstract class DatabaseDonorImpl : RoomDatabase(), DatabaseDonorApi {

    companion object {

        const val CURRENT_VERSION = 1
        private const val DATABASE_NAME = "translate"

        fun build(context: Context): DatabaseDonorApi {
            return Room.databaseBuilder(
                context,
                DatabaseDonorImpl::class.java,
                DATABASE_NAME
            ).build()
        }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }
}