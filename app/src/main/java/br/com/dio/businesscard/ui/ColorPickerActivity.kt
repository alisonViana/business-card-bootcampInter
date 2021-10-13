package br.com.dio.businesscard.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.com.dio.businesscard.R

class ColorPickerActivity : AppCompatActivity() {

    private lateinit var tvTitleColorPicker: TextView
    private lateinit var ivBackground: ImageView
    private lateinit var sbRed: SeekBar
    private lateinit var sbGreen: SeekBar
    private lateinit var sbBlue: SeekBar
    private lateinit var btnCancel: Button
    private lateinit var btnConfirm: Button
    private lateinit var tvColor: TextView
    private lateinit var ivLine: ImageView
    private var initColor: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_picker)

        setView()
        getExtras()
        setSeekBarsListeners()
        setButtonsListeners()
    }

    private fun getExtras() {
        initColor = intent.getIntExtra(EXTRA_COLOR, DEFAULT_COLOR)
        setBackgroundExample(true)
    }

    private fun setView() {
        tvTitleColorPicker = findViewById(R.id.tv_title_color_picker)
        ivBackground = findViewById(R.id.iv_background)
        sbRed = findViewById(R.id.sb_red)
        sbGreen = findViewById(R.id.sb_green)
        sbBlue = findViewById(R.id.sb_blue)
        btnCancel = findViewById(R.id.btn_cancel)
        btnConfirm = findViewById(R.id.btn_confirm_color)
        tvColor = findViewById(R.id.tv_color)
        ivLine = findViewById(R.id.iv_line)
    }

    private fun setBackgroundExample(init: Boolean = false) {
        val color = if (init) initColor else getBackgroundColor()

        ivBackground.setBackgroundColor(color)
        ivLine.setBackgroundColor(color)
        tvColor.text = "#%H".format(color)
    }

    private fun getBackgroundColor(): Int{
        val redValue = sbRed.progress
        val greenValue = sbGreen.progress
        val blueValue = sbBlue.progress

        return Color.rgb(redValue, greenValue, blueValue)
    }


    private fun setSeekBarsListeners() {
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

    private fun setButtonsListeners() {
        btnConfirm.setOnClickListener {
            val intent = Intent()
            intent.putExtra(EXTRA_COLOR, getBackgroundColor())
            setResult(RESULT_OK, intent)
            finish()
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val EXTRA_COLOR: String = "color"
        const val DEFAULT_COLOR: Int = Color.GRAY
    }
}