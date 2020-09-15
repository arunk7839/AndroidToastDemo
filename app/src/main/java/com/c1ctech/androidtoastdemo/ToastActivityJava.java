
package com.c1ctech.androidtoastdemo;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ToastActivityJava extends AppCompatActivity implements View.OnClickListener {

    private Button btnSimpleToast, btnPositionedToast, btnCustomToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        //get buttons by its id
        btnSimpleToast = findViewById(R.id.btn_simple_toast);
        btnPositionedToast = findViewById(R.id.btn_positioned_toast);
        btnCustomToast = findViewById(R.id.btn_custom_toast);

        //set click listener on buttons
        btnSimpleToast.setOnClickListener(this);
        btnPositionedToast.setOnClickListener(this);
        btnCustomToast.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {

            case R.id.btn_simple_toast:
                //show simple toast
                Toast.makeText(getApplicationContext(), "Simple Toast", Toast.LENGTH_LONG).show();
                break;

            case R.id.btn_positioned_toast:
                //get Toast object
                Toast toast = Toast.makeText(getApplicationContext(), "Positioned Toast ", Toast.LENGTH_SHORT);
                //set toast gravity
                toast.setGravity(Gravity.CENTER | Gravity.TOP, 0, 400);
                //show toast
                toast.show();
                break;

            case R.id.btn_custom_toast:

                //get View object (using custom layout, created for Toast)
                View layout = getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));

                //get TextView from View object
                TextView text = layout.findViewById(R.id.toast_text);

                //set text in textview
                text.setText("Your phone call is on hold");

                toast = new Toast(getApplicationContext()); //get Toast object

                toast.setDuration(Toast.LENGTH_LONG); //set Toast duration
                toast.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 300);  //set Toast gravity
                toast.setView(layout);   //set View object
                toast.show();   //show toast

                break;

        }
    }
}
