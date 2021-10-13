package br.com.dio.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.dio.businesscard.App
import br.com.dio.businesscard.databinding.ActivityMainBinding
import br.com.dio.businesscard.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { BusinessCardAdapter() }

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
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }
    }
}