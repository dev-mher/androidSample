package com.example.androidsample.corepersistenceapi.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoryDao {

    @Query("SELECT * FROM HistoryEntity")
    fun getTranslateHistory()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTranslateHistory()
}