package br.com.dio.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Classe responsável pelo acesso e tráfego dos dados
 */
@Dao
interface BusinessCardDao {

    @Query("SELECT * FROM BusinessCard")
    fun getAll(): LiveData<List<BusinessCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCard: BusinessCard)

    @Delete
    suspend fun delete(businessCard: BusinessCard)
}