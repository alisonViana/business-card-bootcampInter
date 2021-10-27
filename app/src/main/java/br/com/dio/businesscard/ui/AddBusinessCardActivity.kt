package br.com.dio.businesscard.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import br.com.dio.businesscard.App
import br.com.dio.businesscard.R
import br.com.dio.businesscard.data.BusinessCard
import br.com.dio.businesscard.databinding.ActivityAddBusinessCardBinding
import br.com.dio.businesscard.ui.ColorPickerActivity.Companion.DEFAULT_COLOR
import br.com.dio.businesscard.ui.ColorPickerActivity.Companion.EXTRA_COLOR

/**
 * Activity responsável pela adição de um novo cartão
 */
class AddBusinessCardActivity : AppCompatActivity(){

    private val binding by lazy{ActivityAddBusinessCardBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }
    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            backgroundColor = intent?.getIntExtra(EXTRA_COLOR, DEFAULT_COLOR)
            updateView()
        }

    }

    private var backgroundColor: Int? = DEFAULT_COLOR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setListeners()
    }

    private fun updateView() {
        binding.btnColorPicker.setBackgroundColor(backgroundColor ?: DEFAULT_COLOR)
    }

    private fun setListeners() {
        binding.tilPhone.editText?.addTextChangedListener(PhoneNumberFormattingTextWatcher("BR"))

        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnColorPicker.setOnClickListener {
            Intent(this, ColorPickerActivity::class.java).apply {
                putExtra(EXTRA_COLOR, backgroundColor)
                startForResult.launch(this)
            }
        }

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                phone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                company = binding.tilCompany.editText?.text.toString(),
                backgroundColor = "#%H".format(backgroundColor)
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.show_success, Toast.LENGTH_LONG).show()
            finish()
        }
    }
}