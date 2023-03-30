package com.example.newdatabase.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC, def ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert
    suspend fun insertWord(word: Word)

}