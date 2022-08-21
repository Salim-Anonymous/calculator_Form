package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var input : TextView
    private lateinit var output : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        input = findViewById(R.id.input)
        output = findViewById(R.id.output)

        val buttonClear = findViewById<Button>(R.id.button_clear)
        val buttonEquals = findViewById<Button>(R.id.button_equals)
        val buttonDivide = findViewById<Button>(R.id.button_division)
        val buttonMultiply = findViewById<Button>(R.id.button_multiply)
        val buttonMinus = findViewById<Button>(R.id.button_subtraction)
        val buttonPlus = findViewById<Button>(R.id.button_addition)
        val buttonDot = findViewById<Button>(R.id.button_dot)
        val button0 = findViewById<Button>(R.id.button_0)
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)
        val button3 = findViewById<Button>(R.id.button_3)
        val button4 = findViewById<Button>(R.id.button_4)
        val button5 = findViewById<Button>(R.id.button_5)
        val button6 = findViewById<Button>(R.id.button_6)
        val button7 = findViewById<Button>(R.id.button_7)
        val button8 = findViewById<Button>(R.id.button_8)
        val button9 = findViewById<Button>(R.id.button_9)
        val buttonOpenBracket = findViewById<Button>(R.id.button_bracket)
        val buttonCloseBracket = findViewById<Button>(R.id.button_bracket_r)
        val buttonCroxx = findViewById<Button>(R.id.button_croxx)

        buttonClear.setOnClickListener {

            input.text = ""

            output.text = ""
        }

        buttonOpenBracket.setOnClickListener {

            input.text = addToInputText("(")

        }
        buttonCloseBracket.setOnClickListener {

            input.text = addToInputText(")")

        }

        buttonCroxx.setOnClickListener {
            val removedLast = input.text.toString().dropLast(1)
            input.text = removedLast
        }

        button0.setOnClickListener {
            input.text = addToInputText("0")
        }
        button1.setOnClickListener {
            input.text = addToInputText("1")
        }
        button2.setOnClickListener {
            input.text = addToInputText("2")
        }
        button3.setOnClickListener {
            input.text = addToInputText("3")
        }
        button4.setOnClickListener {
            input.text = addToInputText("4")
        }
        button5.setOnClickListener {
            input.text = addToInputText("5")
        }
        button6.setOnClickListener {
            input.text = addToInputText("6")
        }
        button7.setOnClickListener {
            input.text = addToInputText("7")
        }
        button8.setOnClickListener {
            input.text = addToInputText("8")
        }
        button9.setOnClickListener {
            input.text = addToInputText("9")
        }
        buttonDot.setOnClickListener {
            input.text = addToInputText(".")
        }
        buttonDivide.setOnClickListener {
            input.text = addToInputText("÷") // ALT + 0247
        }
        buttonMultiply.setOnClickListener {
            input.text = addToInputText("×") // ALT + 0215
        }

        buttonMinus.setOnClickListener {
            input.text = addToInputText("-")
        }
        buttonPlus.setOnClickListener {
            input.text = addToInputText("+")
        }

        buttonEquals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {

        return input.text.toString() + "" + buttonValue
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = ""
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = ""
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}