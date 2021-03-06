package br.com.dio.businesscard.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import br.com.dio.businesscard.App
import br.com.dio.businesscard.R
import br.com.dio.businesscard.data.BusinessCard
import br.com.dio.businesscard.databinding.ActivityMainBinding
import br.com.dio.businesscard.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { BusinessCardAdapter() }


    private val selectedCardList = mutableListOf<Pair<CardView, BusinessCard>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvList.adapter = adapter
        getAllBusinessCard()
        setListeners()
    }

    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this, ){businessCardList ->
            adapter.submitList(businessCardList)
        }
    }

    private fun setListeners() {
        binding.btnAdd.setOnClickListener { addCard() }

        binding.selectMenu.btnCancelSelection.setOnClickListener { cancelSelection() }

        binding.selectMenu.btnShare.setOnClickListener{ shareCard() }

        binding.selectMenu.btnDelete.setOnClickListener { deleteCard() }

        adapter.listenerClick = { _ -> showToast("Segure para selecionar") }

        adapter.listenerLongClick = { card, businessCard ->
            handleSelectedCard(card, businessCard)
        }
    }

    private fun addCard() {
        val intent = Intent(this, AddBusinessCardActivity::class.java)
        startActivity(intent)
    }

    private fun cancelSelection() {
        selectedCardList.forEach {pair ->
            pair.first.setCardBackgroundColor(Color.parseColor(pair.second.backgroundColor))
        }
        hideToolbar()
    }

    private fun shareCard() {
        selectedCardList.forEach { pair ->
            pair.first.setCardBackgroundColor(Color.parseColor(pair.second.backgroundColor))
            Image.share(this@MainActivity, pair.first)
        }
        hideToolbar()
    }

    private fun deleteCard() {
        AlertDialog.Builder(this).apply {
            setPositiveButton("Sim!") { _, _ ->
                selectedCardList.forEach { pair ->
                    mainViewModel.delete(pair.second)
                }
                hideToolbar()
                showToast("Cart??o exclu??do!")
            }
            setNegativeButton("N??o", null)
            if (selectedCardList.size == 1) {
                setTitle(getString(R.string.delete_title_singular))
                setMessage(getString(R.string.delete_message_singular))
            } else {
                setTitle(getString(R.string.delete_title_plural))
                setMessage(getString(R.string.delete_message_plural))
            }
        }.show()
    }

    private fun handleSelectedCard(card: CardView, businessCard: BusinessCard) {
        binding.selectMenu.root.visibility = View.VISIBLE
        val selectedCard = Pair(card, businessCard)

        if (!selectedCardList.contains(selectedCard)) {
            selectedCardList.add(selectedCard)
            card.setCardBackgroundColor(Color.parseColor(selectedColor))
            updateToolbar()
        }
    }

    private fun hideToolbar() {
        binding.selectMenu.root.visibility = View.GONE
        selectedCardList.clear()
    }

    private fun updateToolbar() {
        binding.selectMenu.tvItemsSelected.text =
            String.format(resources.getQuantityString(R.plurals.selected_items_toolbar, selectedCardList.size), selectedCardList.size)
    }

    private fun showToast(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val selectedColor: String = "#BCB7F5F8"
    }
}