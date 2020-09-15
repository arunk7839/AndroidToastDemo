package com.c1ctech.androidtoastdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ToastActivityKotlin : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        //get buttons by its id
        val btnSimpleToast = findViewById<Button>(R.id.btn_simple_toast)
        val btnPositionedToast = findViewById<Button>(R.id.btn_positioned_toast)
        val btnCustomToast = findViewById<Button>(R.id.btn_custom_toast)

        //set click listener on buttons
        btnSimpleToast.setOnClickListener(this)
        btnPositionedToast.setOnClickListener(this)
        btnCustomToast.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        val id = view.id

        when (id) {

            //show simple toast
            R.id.btn_simple_toast -> Toast.makeText(applicationContext, "Simple Toast", Toast.LENGTH_LONG).show()

            R.id.btn_positioned_toast -> {

                //get Toast object
                val toast = Toast.makeText(applicationContext, "Positioned Toast ", Toast.LENGTH_SHORT)

                //set Toast gravity
                toast.setGravity(Gravity.CENTER or Gravity.TOP, 0, 400)

                //show Toast
                toast.show()
            }
            R.id.btn_custom_toast -> {

                //get View object (using custom layout, created for Toast)
                val layout = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container) as? ViewGroup)

                //get TextView from View object
                val text = layout.findViewById<TextView>(R.id.toast_text)

                //set text in textview
                text.text = getText(R.string.custom_toast_text)   //text.setText("Your phone call is on hold")

                val toast = Toast(applicationContext)  //get Toast object

                toast.duration = Toast.LENGTH_LONG    //set Toast duration

                toast.setGravity(Gravity.CENTER or Gravity.BOTTOM, 0, 300)    //set Toast gravity

                //set View object
                toast.view = layout  //toast.setView(layout)

                toast.show()   //show Toast
            }
        }
    }
}