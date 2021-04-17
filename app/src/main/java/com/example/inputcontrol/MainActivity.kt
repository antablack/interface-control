package com.example.inputcontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.phone_spinner)
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.phone_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

    }

    fun onRadioButtonClicked(view: View) {
        val isChecked = (view as RadioButton).isChecked()

        when (view.id) {
            R.id.sameday -> {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Same day messenger service", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.nextday -> {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Next day ground delivery", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.pickup -> {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Pick up", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {

            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        Toast.makeText(getApplicationContext(), parent.getItemAtPosition(pos) as String, Toast.LENGTH_SHORT).show()
        // parent.getItemAtPosition(pos)
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }

}