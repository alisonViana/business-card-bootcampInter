package br.com.dio.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import br.com.dio.businesscard.App
import br.com.dio.businesscard.R
import br.com.dio.businesscard.data.BusinessCard
import br.com.dio.businesscard.databinding.ActivityAddBusinessCardBinding
import br.com.dio.businesscard.databinding.ColorPickerAlertdialogBinding

/**
 * Activity responsável pela adição de um novo cartão
 */
class AddBusinessCardActivity : AppCompatActivity(){

    private val binding by lazy{ActivityAddBusinessCardBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnColorPicker.setOnClickListener {
            val intent = Intent(this, ColorPickerActivity::class.java)
            startActivity(intent)

        /*
            val colorPicker = ColorPicker(this)
            val builder = AlertDialog.Builder(this)

            builder.apply {
                setPositiveButton("Selecionar"){_, _ ->

                }
                setNegativeButton("Cancelar", null)
                    .setView(R.layout.color_picker_alertdialog)
                    .show()
            }*/
        }

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                phone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                company = binding.tilCompany.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.show_success, Toast.LENGTH_LONG).show()
            finish()
        }
    }
}