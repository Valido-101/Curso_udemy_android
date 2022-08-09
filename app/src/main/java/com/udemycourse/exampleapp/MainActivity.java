package com.udemycourse.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickFunction(View view){

        Log.i("Info","Button Pressed!");

    }

    public void showName(View view){

        EditText nameEditText = (EditText)findViewById(R.id.NameEditText);

        String name = nameEditText.getText().toString();

        Log.i("Info","Button Pressed!");

        Log.i("Values","Your name: " + name);

    }
}