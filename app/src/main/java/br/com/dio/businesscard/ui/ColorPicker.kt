package br.com.dio.businesscard.ui

import android.content.Context
import android.view.LayoutInflater
import android.widget.SeekBar
import br.com.dio.businesscard.databinding.ColorPickerAlertdialogBinding



/**
 * Activity responsável pelo alertDialog de cores
 */
class ColorPicker(
    context: Context
) {

    private val inflater = LayoutInflater.from(context)
    private val binding = ColorPickerAlertdialogBinding.inflate(inflater)
/*
    private fun setListeners() {
        binding.sbRed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                TODO("Not yet implemented")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }
        })

    }
*/

}