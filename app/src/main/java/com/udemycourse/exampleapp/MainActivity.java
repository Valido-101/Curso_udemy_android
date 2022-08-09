package com.udemycourse.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickFunction(View view){

        Log.i("Info","Button Pressed!");

    }

    public void showNameAndPassword(View view){

        //Obtenemos las vistas por su id
        EditText nameEditText = (EditText)findViewById(R.id.NameEditText);
        EditText passwordEditText = (EditText)findViewById(R.id.editTextPassword);

        //Obtenemos el valor de los editText en formato string
        String name = nameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        Log.i("Info","Button Pressed!");

        //Mostramos dichos valores por el log
        Log.i("Values","Your name: " + name);
        Log.i("Values","Your password: " + password);

        Toast.makeText(this,"Hello, " + name, Toast.LENGTH_SHORT).show();

    }
}