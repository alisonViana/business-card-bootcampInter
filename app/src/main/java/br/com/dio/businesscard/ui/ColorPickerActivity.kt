package br.com.dio.businesscard.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.com.dio.businesscard.databinding.ActivityColorPickerBinding
import com.google.android.material.textfield.TextInputLayout

class ColorPickerActivity : AppCompatActivity() {

    var TextInputLayout.text: String
        get() = editText?.text?.toString() ?: ""
        set(value) {
            editText?.setText(value)
        }

    private var initColor: Int = 0

    private val binding by lazy { ActivityColorPickerBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getExtras()
        setSeekBarsListeners()
        setButtonsListeners()
    }

    private fun getExtras() {
        initColor = intent.getIntExtra(EXTRA_COLOR, DEFAULT_COLOR)
        setBackgroundExample(true)
    }

    private fun setBackgroundExample(init: Boolean = false) {
        val color = if (init) setInitColor() else getBackgroundColor()

        binding.ivBackground.setBackgroundColor(color)
        binding.ivLine.setBackgroundColor(color)
        binding.tvColor.text = "#%H".format(color)
    }

    private fun setInitColor(): Int {
        val stringColor: String = "%H".format(initColor)
        val valueRed: Int = stringColor.slice(2..3).toInt(16)
        val valueGreen: Int = stringColor.slice(4..5).toInt(16)
        val valueBlue: Int = stringColor.slice(6..7).toInt(16)

        binding.sbRed.progress = valueRed
        binding.sbGreen.progress = valueGreen
        binding.sbBlue.progress = valueBlue

        return initColor
    }

    private fun getBackgroundColor(): Int{

        val redValue = binding.sbRed.progress
        val greenValue = binding.sbGreen.progress
        val blueValue = binding.sbBlue.progress

        return Color.rgb(redValue, greenValue, blueValue)
    }


    private fun setSeekBarsListeners() {

        binding.sbRed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                setBackgroundExample()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        } )

        binding.sbGreen.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                setBackgroundExample()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })

        binding.sbBlue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                setBackgroundExample()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })

    }

    private fun setButtonsListeners() {
        binding.btnConfirmColor.setOnClickListener {
            Intent().apply {
                putExtra(EXTRA_COLOR, getBackgroundColor())
                setResult(RESULT_OK, this)
            }
            finish()
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }

    }

    companion object {
        const val EXTRA_COLOR: String = "color"
        const val DEFAULT_COLOR: Int = Color.GRAY
    }
}