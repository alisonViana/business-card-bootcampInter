package br.com.dio.businesscard

import android.app.Application
import br.com.dio.businesscard.data.AppDatabase
import br.com.dio.businesscard.data.BusinessCardRepository

/**
 * Classe responsável pelo gerenciamento do repositório
 * Executada antes da MainActivity
 */
class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}