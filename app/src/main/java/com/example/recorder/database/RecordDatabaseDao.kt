package com.example.recorder.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RecordDatabaseDao {

    //Добавляет записи в БД
    @Insert
    fun insert(record: RecordingItem)

    //Обновляет записи в БД
    @Update
    fun update(record: RecordingItem)

    //Выполяет выборки данных из БД и операции над ними
    @Query("SELECT * from recording_table WHERE id = :key")
    //определяет поиск записей по ключу id
    fun getRecord(key: Long?): RecordingItem?

    @Query("DELETE FROM recording_table")
    //Удаляет все записи из БД
    fun clearAll()

    @Query("DELETE FROM recording_table WHERE id = :key")
    //Удаляет одну запись по id
    fun removeRecord(key: Long?)

    @Query("SELECT * from recording_table ORDER BY id DESC")
    //Выбирает все записи и сохраняет ввиде экземпляра класса Lifedata содержащего список записей
    fun getAllRecords(): LiveData<MutableList<RecordingItem>>

    @Query("SELECT COUNT(*) FROM recording_table")
    //Возвращает количество
    fun getCount(): Int
}