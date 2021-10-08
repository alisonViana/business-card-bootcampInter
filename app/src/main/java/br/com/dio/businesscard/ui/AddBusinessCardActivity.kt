package br.com.dio.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import br.com.dio.businesscard.R
import br.com.dio.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy{ActivityAddBusinessCardBinding.inflate(layoutInflater)}

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
            val builder = AlertDialog.Builder(this)

            builder.apply {
                setPositiveButton("Selecionar") { _, _ ->
                    // faz alguma coisa
                }
                setNegativeButton("Cancelar", null)
                    .setView(R.layout.color_picker_alertdialog)
                    .show()
            }
        }

        binding.btnConfirm.setOnClickListener {

        }
    }
}