package com.example.student_registration

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.forEachIndexed

class MainActivity : AppCompatActivity() {

    private lateinit var coursesBox: LinearLayout
    private lateinit var resetButton: Button
    private lateinit var submitButton: Button
    private lateinit var studentIdEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var programmeSpinner: Spinner
    private lateinit var semNameSpinner: Spinner
    private lateinit var academicYearEditText: EditText
    private lateinit var yearSpinner: Spinner
    private lateinit var semRadioGroup: RadioGroup
    private lateinit var checkBoxTemplate: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        init()
    }

    private fun init(){
        coursesBox = findViewById(R.id.courses_box)
        resetButton = findViewById(R.id.reset)
        submitButton = findViewById(R.id.submit)
        studentIdEditText = findViewById(R.id.student_id)
        nameEditText = findViewById(R.id.name)
        semNameSpinner = findViewById(R.id.sem_name)
        academicYearEditText = findViewById(R.id.academic_year)
        yearSpinner = findViewById(R.id.year)
        semRadioGroup = findViewById(R.id.radio_group)
        programmeSpinner = findViewById(R.id.programme)
        checkBoxTemplate = CheckBox(this)
        //createCheckBoxes()

        semRadioGroup.setOnCheckedChangeListener { _, i ->
            val radioButtonText = findViewById<RadioButton>(i).text.toString()
            val year = yearSpinner.selectedItem.toString()
            val programme = programmeSpinner.selectedItem.toString()
            removeCheckBoxes()
            createCheckBoxes(radioButtonText,year,programme)
        }

        resetButton.setOnClickListener{
            studentIdEditText.text.clear()
            nameEditText.text.clear()
            programmeSpinner.setSelection(0)
            semNameSpinner.setSelection(0)
            academicYearEditText.text.clear()
            yearSpinner.setSelection(0)
            semRadioGroup.clearCheck()
            removeCheckBoxes()
        }
        submitButton.setOnClickListener{

            val intent = Intent(this@MainActivity,Results::class.java)
            intent.putExtra("Student_ID", studentIdEditText.text.toString())
            intent.putExtra("Name",nameEditText.text.toString() )
            intent.putExtra("programme",programmeSpinner.selectedItem.toString())
            intent.putExtra("sem_name",semNameSpinner.selectedItem.toString())
            intent.putExtra("academic_year",academicYearEditText.text.toString())
            intent.putExtra("year",yearSpinner.selectedItem.toString())
            intent.putExtra("length",coursesBox.childCount)
            intent.putExtra("semester",findViewById<RadioButton>(semRadioGroup.checkedRadioButtonId).text.toString())
            val length = coursesBox.childCount
            var i=0

            while(i<length){
                val box:CheckBox = coursesBox.getChildAt(i) as CheckBox
                intent.putExtra("$i",box.text)
                i++
            }
            startActivity(intent)
        }
    }

    private fun createCheckBoxes(radioButtonText: String, year: String, programme: String) {
        val res: Resources = resources
        var courseArray: Array<String>?
        if(radioButtonText == "Semester I"){
            when (year) {
                "1st Year" -> {
                    when (programme) {
                        "B.E IT" -> {
                            courseArray = res.getStringArray(R.array.it_1_1)
                            for(value in courseArray){
                                val checkBox = CheckBox(this)
                                checkBox.text = value
                                coursesBox.addView(checkBox)
                            }

                        }
                        "B.E CE" -> {

                        }
                        "B.E EE" -> {

                        }
                        "B.E ECE" -> {

                        }
                        "B.E A" -> {

                        }
                        "B.E ICE" -> {

                        }
                        "B.E EG" -> {

                        }
                    }
                }
                "2nd Year" -> {

                    when (programme) {
                        "B.E IT" -> {
                            courseArray = res.getStringArray(R.array.it_2_1)
                            for(value in courseArray){
                                val checkBox = CheckBox(this)
                                checkBox.text = value
                                coursesBox.addView(checkBox)
                            }
                        }
                        "B.E CE" -> {

                        }
                        "B.E EE" -> {

                        }
                        "B.E ECE" -> {

                        }
                        "B.E A" -> {

                        }
                        "B.E ICE" -> {

                        }
                        "B.E EG" -> {

                        }
                    }

                }
                "3rd Year" -> {
                    when (programme) {
                        "B.E IT" -> {
                            courseArray = res.getStringArray(R.array.it_3_1)
                            for(value in courseArray){
                                val checkBox = CheckBox(this)
                                checkBox.text = value
                                coursesBox.addView(checkBox)
                            }
                        }
                        "B.E CE" -> {

                        }
                        "B.E EE" -> {

                        }
                        "B.E ECE" -> {

                        }
                        "B.E A" -> {

                        }
                        "B.E ICE" -> {

                        }
                        "B.E EG" -> {

                        }
                    }

                }
                else -> {
                    when (programme) {
                        "B.E IT" -> {
                            courseArray = res.getStringArray(R.array.it_4_1)
                            for(value in courseArray){
                                val checkBox = CheckBox(this)
                                checkBox.text = value
                                coursesBox.addView(checkBox)
                            }
                        }
                        "B.E CE" -> {

                        }
                        "B.E EE" -> {

                        }
                        "B.E ECE" -> {

                        }
                        "B.E A" -> {

                        }
                        "B.E ICE" -> {

                        }
                        "B.E EG" -> {

                        }
                    }

                }
            }
        }else{
            when (year) {
                "1st Year" -> {
                    when (programme) {
                        "B.E IT" -> {
                            courseArray = res.getStringArray(R.array.it_1_2)
                            for(value in courseArray){
                                val checkBox = CheckBox(this)
                                checkBox.text = value
                                coursesBox.addView(checkBox)
                            }

                        }
                        "B.E CE" -> {

                        }
                        "B.E EE" -> {

                        }
                        "B.E ECE" -> {

                        }
                        "B.E A" -> {

                        }
                        "B.E ICE" -> {

                        }
                        "B.E EG" -> {

                        }
                    }
                }
                "2nd Year" -> {

                    when (programme) {
                        "B.E IT" -> {
                            courseArray = res.getStringArray(R.array.it_2_2)
                            for(value in courseArray){
                                val checkBox = CheckBox(this)
                                checkBox.text = value
                                coursesBox.addView(checkBox)
                            }
                        }
                        "B.E CE" -> {

                        }
                        "B.E EE" -> {

                        }
                        "B.E ECE" -> {

                        }
                        "B.E A" -> {

                        }
                        "B.E ICE" -> {

                        }
                        "B.E EG" -> {

                        }
                    }

                }
                "3rd Year" -> {
                    when (programme) {
                        "B.E IT" -> {
                            courseArray = res.getStringArray(R.array.it_3_2)
                            for(value in courseArray){
                                val checkBox = CheckBox(this)
                                checkBox.text = value
                                coursesBox.addView(checkBox)
                            }
                        }
                        "B.E CE" -> {

                        }
                        "B.E EE" -> {

                        }
                        "B.E ECE" -> {

                        }
                        "B.E A" -> {

                        }
                        "B.E ICE" -> {

                        }
                        "B.E EG" -> {

                        }
                    }

                }
                else -> {
                    when (programme) {
                        "B.E IT" -> {
                            courseArray = res.getStringArray(R.array.it_4_2)
                            for(value in courseArray){
                                val checkBox = CheckBox(this)
                                checkBox.text = value
                                coursesBox.addView(checkBox)
                            }
                        }
                        "B.E CE" -> {

                        }
                        "B.E EE" -> {

                        }
                        "B.E ECE" -> {

                        }
                        "B.E A" -> {

                        }
                        "B.E ICE" -> {

                        }
                        "B.E EG" -> {

                        }
                    }

                }
            }

        }

    }

    private fun removeCheckBoxes() {
        coursesBox.removeAllViews()
    }
}