package com.example.testcheckboxsnackbar

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var inputLine:EditText
    private lateinit var outText:TextView
    private lateinit var saveBTN:Button
    private lateinit var deleteBTN:Button
    private lateinit var informationBox: CheckBox
    private lateinit var information:TextView
    private lateinit var textRules:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputLine = findViewById(R.id.inputLine)
        outText = findViewById(R.id.outLine)
        saveBTN = findViewById(R.id.saveBTN)
        deleteBTN = findViewById(R.id.deleteBTN)
        informationBox = findViewById(R.id.informationBox)
        information = findViewById(R.id.information)
        textRules = findViewById(R.id.textRules)

        informationBox.setOnCheckedChangeListener{
                _, isChecked ->
            if (isChecked){
                information.setText(R.string.informationTrue)
                textRules.visibility = View.VISIBLE
            }else {
                information.setText(R.string.information)
                textRules.visibility = View.INVISIBLE
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun saveBTNOnClick(view: View) {
        outText.text = inputLine.text.toString()
        inputLine.setText("")
    }
    @SuppressLint("SetTextI18n", "ShowToast")
    fun deleteBTNOnClick(view: View) {
        Snackbar.make(
            view,
            "Подтвердите удаление!",
            Snackbar.LENGTH_LONG
        ).setAction("Подтверждаю"){
            inputLine.setText("")
            outText.setText(R.string.outLine)
        }.show()
    }
}