package com.example.thirdtaskwithcat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int points = 0;
    EditText editText;
    RadioGroup radioGroup1, radioGroup2;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    TextView textViewOfDisplayResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextAnswer);
        radioGroup1 = findViewById(R.id.radioGroupFirst);
        radioGroup2 = findViewById(R.id.radioGrouSecond);
        checkBox1 = findViewById(R.id.checkBoxOne);
        checkBox2 = findViewById(R.id.checkBoxTwo);
        checkBox3 = findViewById(R.id.checkBoxThree);
        checkBox4 = findViewById(R.id.checkBoxFour);
        textViewOfDisplayResult = findViewById(R.id.textViewResult);


    }//end of onCreat()

    public void onRadioButtonClicked(View view) {
    }

    //==============================================================================================
    //method of submit button
    @SuppressLint("SetTextI18n")
    public void submitBtn(View view) {
        //code of edit text
        String getTextString = editText.getText().toString();
        if (getTextString.equals("20")) {
            points = 1;
        } else {
            points = 0;
        }
//        //------------------------------------------------------------------------------------------
        // code of radioGroup1
        int radioId1 = radioGroup1.getCheckedRadioButtonId();
        View radioButton1 = radioGroup1.findViewById(radioId1);
        int idx1 = radioGroup1.indexOfChild(radioButton1);
        if (idx1 == 0) {
            points = points + 1;
        } else {
            points = points;
        }
//        //------------------------------------------------------------------------------------------
//        // code of checkBoxes
        if (checkBox1.isChecked() && checkBox4.isChecked()) {
            points = points + 1;
            if (checkBox1.isChecked() && checkBox4.isChecked() && checkBox2.isChecked() && checkBox4.isChecked() ||
                    checkBox4.isChecked() && checkBox2.isChecked() && checkBox1.isChecked() ||
                    checkBox1.isChecked() && checkBox4.isChecked() && checkBox3.isChecked()
            ) {
                points = points - 1;
            }
        } else {
            points = points;
        }
        //------------------------------------------------------------------------------------------
        // code of radioGroup2
        int radioId2 = radioGroup2.getCheckedRadioButtonId();
        View radioButton2 = radioGroup2.findViewById(radioId2);
        int idx2 = radioGroup2.indexOfChild(radioButton2);
        if (idx2 == 1) {
            points = points + 1;
        } else {
            points = points;
        }
        //------------------------------------------------------------------------------------------
        // code of textview
        textViewOfDisplayResult.setText("Your result is " + points + " From 4");

    }//end of submitBtn()

}//end of MainActivity