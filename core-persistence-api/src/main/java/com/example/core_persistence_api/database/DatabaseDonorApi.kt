package com.example.core_persistence_api.database

import com.example.core_persistence_api.database.dao.HistoryDao

interface DatabaseDonorApi {

    val historyDao: HistoryDao

}