package br.com.dio.businesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Classe modelo de um Business Card
 */
@Entity
data class BusinessCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val phone: String,
    val email: String,
    val company: String,
    val backgroundColor: String
)