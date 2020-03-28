package com.example.android.quizapp;


import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import static android.support.v4.content.ContextCompat.getSystemService;

public class MyFocusChangeListener implements View.OnFocusChangeListener {

    public void onFocusChange(View v, boolean hasFocus){

        if(!hasFocus) {

            //InputMethodManager imm =  (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            //imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

        }
    }
}
