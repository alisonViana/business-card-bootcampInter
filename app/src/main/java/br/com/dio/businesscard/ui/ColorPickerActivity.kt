package br.com.dio.businesscard.ui

import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import br.com.dio.businesscard.R
import br.com.dio.businesscard.databinding.ActivityColorPickerBinding

class ColorPickerActivity : AppCompatActivity() {

    private val binding by lazy { ActivityColorPickerBinding.inflate(layoutInflater) }

    private lateinit var tvTitleColorPicker: TextView
    private lateinit var ivBackground: ImageView
    private lateinit var sbRed: SeekBar
    private lateinit var sbGreen: SeekBar
    private lateinit var sbBlue: SeekBar
    private lateinit var btnColorPicker: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_picker)



        setView()
        setListeners()
        setBackgroundExample()
    }

    private fun setView() {
        tvTitleColorPicker = findViewById(R.id.tv_title_color_picker)
        ivBackground = findViewById(R.id.iv_background)
        sbRed = findViewById(R.id.sb_red)
        sbGreen = findViewById(R.id.sb_green)
        sbBlue = findViewById(R.id.sb_blue)
    }

    private fun setBackgroundExample() {
        val redValue = sbRed.progress
        val greenValue = sbGreen.progress
        val blueValue = sbBlue.progress
        ivBackground.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue))
    }

    private fun setListeners() {
        sbRed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                setBackgroundExample()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        } )

        sbGreen.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                setBackgroundExample()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })

        sbBlue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                setBackgroundExample()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }
}