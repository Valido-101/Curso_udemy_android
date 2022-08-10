package com.udemycourse.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dokkan_fader extends AppCompatActivity {

    private ImageView blueBoys;
    private ImageView gogetaBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokan_fader);

        blueBoys = (ImageView)findViewById(R.id.imageViewBlueBoys);
        gogetaBlue = (ImageView)findViewById(R.id.imageViewBlueGogeta);
    }

    public void fadeAnimation(View view){

        if (blueBoys.getAlpha() == 0){
            fadeOut(gogetaBlue);
            fadeIn(blueBoys);
        }
        else if(gogetaBlue.getAlpha() == 0){
            fadeOut(blueBoys);
            fadeIn(gogetaBlue);
        }

    }

    private void fadeIn(ImageView imagen){

        imagen.animate().alpha(1).setDuration(2000);

    }

    private void fadeOut(ImageView imagen){

        imagen.animate().alpha(0).setDuration(2000);

    }

    //Este método sirve para moverse entre las activities, para ello debe estar declarada en el manifest
    public void goBackHome(View view){
        Intent menuIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(menuIntent);
    }
}