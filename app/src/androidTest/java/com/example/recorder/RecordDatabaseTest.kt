package com.example.recorder

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.recorder.database.RecordDatabase
import com.example.recorder.database.RecordDatabaseDao
import com.example.recorder.database.RecordingItem
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class RecordDatabaseTest {

    private lateinit var recordDatabaseDao: RecordDatabaseDao
    private lateinit var database: RecordDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context,RecordDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        recordDatabaseDao = database.recordDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }

    @After
    @Throws(Exception::class)
    fun testDatabase() {
        recordDatabaseDao.insert(RecordingItem())
        val getCount = recordDatabaseDao.getCount()
        assertEquals(getCount, 1)
    }
}