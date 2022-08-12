package com.udemycourse.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;

public class Connect3 extends AppCompatActivity {

    private GridLayout gridLayout;
    private int turno = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);

        //Obtenemos el gridLayout donde están las imágenes
        gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        //Recorremos las imágenes y las hacemos invisibles
        for (int x=0;x<gridLayout.getChildCount();x++){
            ImageView ficha = (ImageView)gridLayout.getChildAt(x);
            ficha.setAlpha(0f);
        }
    }

    //Método que se ejecutará al pulsar una imagen
    public void moverFicha(View view){
        ImageView ficha = (ImageView)view;

        if (turno%2!=0){
            ficha.setImageResource(R.drawable.red);
        }
        else{
            ficha.setImageResource(R.drawable.yellow);
        }

        ficha.setAlpha(1f);
        ficha.setTranslationY(-1000);
        ficha.animate().translationYBy(1000f).setDuration(500);

        turno++;
    }

    //Reinicia la activity
    public void restartActivity(View view){
        this.recreate();
    }
}