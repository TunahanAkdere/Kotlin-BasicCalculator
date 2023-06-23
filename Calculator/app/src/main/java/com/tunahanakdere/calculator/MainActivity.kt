package com.tunahanakdere.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var numberArea:EditText

    var firstNumber: Double = 0.0
    var operator:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberArea = findViewById(R.id.numberArea)
        val number0btn: Button = findViewById(R.id.number0btn)
        val number1btn: Button = findViewById(R.id.number1btn)
        val number2btn: Button = findViewById(R.id.number2btn)
        val number3btn: Button = findViewById(R.id.number3btn)
        val number4btn: Button = findViewById(R.id.number4btn)
        val number5btn: Button = findViewById(R.id.number5btn)
        val number6btn: Button = findViewById(R.id.number6btn)
        val number7btn: Button = findViewById(R.id.number7btn)
        val number8btn: Button = findViewById(R.id.number8btn)
        val number9btn: Button = findViewById(R.id.number9btn)
        val sonucText : TextView = findViewById(R.id.sonucText)

        val dotBtn: Button = findViewById(R.id.dotBtn)

        val clearBtn: Button = findViewById(R.id.clearBtn)
        val deleteBtn: Button = findViewById(R.id.deleteBtn)
        val addBtn: Button = findViewById(R.id.addBtn)
        val subtractBtn: Button = findViewById(R.id.subtractBtn)
        val multiplyBtn: Button = findViewById(R.id.multiplyBtn)
        val divideBtn: Button = findViewById(R.id.divideBtn)
        val equalBtn : Button = findViewById(R.id.equalBtn)


        number0btn.setOnClickListener {
            numberArea.append("0")
        }

        number1btn.setOnClickListener {
            numberArea.append("1")
        }

        number2btn.setOnClickListener {
            numberArea.append("2")
        }

        number3btn.setOnClickListener {
            numberArea.append("3")
        }

        number4btn.setOnClickListener {
            numberArea.append("4")
        }

        number5btn.setOnClickListener {
            numberArea.append("5")
        }

        number6btn.setOnClickListener {
            numberArea.append("6")
        }

        number7btn.setOnClickListener {
            numberArea.append("7")
        }

        number8btn.setOnClickListener {
            numberArea.append("8")
        }

        number9btn.setOnClickListener {
            numberArea.append("9")
        }


        dotBtn.setOnClickListener {
            numberArea.append(".")
        }

        addBtn.setOnClickListener {
            val currentText = numberArea.text.toString()
            if (currentText.isNotEmpty()){
                firstNumber = currentText.toDouble()
                operator = "+"
                numberArea.text.clear()
                sonucText.setText(firstNumber.toString())
            }
        }

        subtractBtn.setOnClickListener {
            val currentText = numberArea.text.toString()
            if (currentText.isNotEmpty()){
                firstNumber = currentText.toDouble()
                operator = "-"
                numberArea.text.clear()
                sonucText.setText(firstNumber.toString())
            }
        }

        multiplyBtn.setOnClickListener {
            val currentText = numberArea.text.toString()
            if (currentText.isNotEmpty()) {
                firstNumber = currentText.toDouble()
                operator = "x"
                numberArea.text.clear()
                sonucText.setText(firstNumber.toString())
            }
        }

        divideBtn.setOnClickListener {
            val currentText = numberArea.text.toString()
            if (currentText.isNotEmpty()) {
                firstNumber = currentText.toDouble()
                operator = "/"
                numberArea.text.clear()
                sonucText.setText(firstNumber.toString())
            }
        }

        deleteBtn.setOnClickListener {
            val currentText = numberArea.text.toString()
            if (currentText.isNotEmpty()){
                val newText = currentText.substring(0,currentText.length -1)
                numberArea.setText(newText)
            }
        }

        clearBtn.setOnClickListener {
            numberArea.text.clear()
            firstNumber = 0.0
            operator = ""
            sonucText.text = ""

        }


        fun yapilacakIslem (number1:Double, number2: Double, operator:String) : Double{
            return when(operator){
                "+" -> number1 + number2
                "-" -> number1 - number2
                "x" -> number1 * number2
                "/" -> number1 / number2
                else -> number1
            }
        }


        equalBtn.setOnClickListener {
            if (numberArea.text.isNotEmpty()){
                val secondNumber = numberArea.text.toString().toDouble()
                val result = yapilacakIslem(firstNumber, secondNumber, operator)
                sonucText.setText(result.toString())
                firstNumber = result
                operator = ""
                numberArea.text.clear()
            }
        }



    }
}