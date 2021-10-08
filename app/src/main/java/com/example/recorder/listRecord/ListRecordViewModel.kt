package com.example.recorder.listRecord

import androidx.lifecycle.ViewModel
import com.example.recorder.database.RecordDatabase
import com.example.recorder.database.RecordDatabaseDao

class ListRecordViewModel (
    dataSource: RecordDatabaseDao
 ): ViewModel() {

    val database = dataSource
    val records = database.getAllRecords()
}