package com.udemycourse.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Array de números en el que almacenaremos los id de cada uno de los recursos
    private int[] imagenes = new int[3];
    //Imagen que tenemos en la activity
    private ImageView imageView;
    //Imagen que se mostrará
    private int imagenActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos el ImageView de la activity
        imageView = (ImageView)findViewById(R.id.imageView);
        //Declaramos cada posición del array para que sea un recurso distinto de drawable
        imagenes[0] = R.drawable.db;
        imagenes[1] = R.drawable.dbs;
        imagenes[2] = R.drawable.dbs2;
    }

    public void clickFunction(View view){

        Log.i("Info","Button Pressed!");

        //Si la imagen actual (que actúa de indice) llega a dos, vuelve a cero
        if (imagenActual >= 2){
            imagenActual = 0;
        }
        //De lo contrario, aumenta
        else{
            imagenActual++;
        }

        //Establecemos la imagen al ImageView usando el id de recurso correspondiente
        imageView.setImageResource(imagenes[imagenActual]);

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