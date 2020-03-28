package com.example.android.quizapp;

import android.content.res.Resources;
import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText answer1 = (EditText) findViewById(R.id.answer1);
        EditText answer2 = (EditText) findViewById(R.id.answer2);
        View.OnFocusChangeListener listener = new MyFocusChangeListener();
        answer1.setOnFocusChangeListener(listener);
        answer2.setOnFocusChangeListener(listener);
    }

    /**
     * Submitting the quiz app
     */
    public void submit(View view) {
        String right1 = getResources().getString(R.string.right1);
        String right2 = getResources().getString(R.string.right2);

        //answer for  number 1 question
        EditText answer1View = findViewById(R.id.answer1);
        String answer1 = String.valueOf(answer1View.getText());
        //answer for number 2 question
        EditText answer2View = findViewById(R.id.answer2);
        String answer2 = String.valueOf(answer2View.getText());
        //selected radiobutton
        RadioButton answer3View = findViewById(R.id.answer32);
        Boolean answer3 = answer3View.isChecked();
        //checkboxy
        CheckBox answer41View = findViewById(R.id.answer41);
        Boolean answer41 = answer41View.isChecked();
        CheckBox answer42View = findViewById(R.id.answer42);
        Boolean answer42 = answer42View.isChecked();
        CheckBox answer43View = findViewById(R.id.answer43);
        Boolean answer43 = answer43View.isChecked();
        CheckBox answer44View = findViewById(R.id.answer44);
        Boolean answer44 = answer44View.isChecked();

        int correctAnswers = 0;
        //first three questions
        if(right1.toLowerCase().equals(answer1.toLowerCase()))
            correctAnswers++;
        if(right2.toLowerCase().equals(answer2.toLowerCase()))
            correctAnswers++;
        if(answer3)
            correctAnswers++;
        if(answer41 && !answer42 && answer43 && !answer44)
            correctAnswers++;

        //message of the result
        String resultMessage = null;
        if(correctAnswers == 4) {
            resultMessage = getResources().getString(R.string.rightResult);
        } else {
            resultMessage = getResources().getString(R.string.wrongResult) + String.valueOf(correctAnswers);
        }

        Toast.makeText(MainActivity.this, resultMessage, Toast.LENGTH_LONG).show();

        return;
    }
}
