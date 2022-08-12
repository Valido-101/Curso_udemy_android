package com.udemycourse.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Connect3 extends AppCompatActivity {

    private GridLayout gridLayout;
    private int turno = 1;
    private TextView txtView;
    private Button btn;
    private final int[][] combinacionesGanadoras = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);

        //Obtenemos el gridLayout donde están las imágenes
        gridLayout = (GridLayout)findViewById(R.id.gridLayout);
        txtView = (TextView)findViewById(R.id.tvWinText);
        btn = (Button)findViewById(R.id.button5);

        //Recorremos las imágenes y las hacemos invisibles
        for (int x=0;x<gridLayout.getChildCount();x++){
            ImageView ficha = (ImageView)gridLayout.getChildAt(x);
            ficha.setAlpha(0f);
        }

        txtView.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);
    }

    /**
     * Método que se ejecutará al pulsar una imagen
     * @param view La imagen que se moverá
     */
    public void moverFicha(View view){
        ImageView ficha = (ImageView)view;

        if (turno%2!=0){
            ficha.setImageResource(R.drawable.red);
            ficha.setTag(0);
        }
        else{
            ficha.setImageResource(R.drawable.yellow);
            ficha.setTag(1);
        }

        ficha.setAlpha(1f);
        ficha.setTranslationY(-1000);
        ficha.animate().translationYBy(1000f).setDuration(500);

        int estadoPartida = checkGameOver();

        switch (estadoPartida){
            case 0:
                break;
            case 1:
                String mensaje;

                if (turno%2!=0){
                    mensaje = "¡Fin de la partida! Ha ganado el jugador Rojo.";
                }
                else{
                    mensaje = "¡Fin de la partida! Ha ganado el jugador Amarillo.";
                }

                gameOver(mensaje);
                break;
            case 2:
                gameOver("¡Fin de la partida! No se pueden colocar más fichas.");
                break;
        }

        turno++;
    }

    /**
     * Método que reinicia la activity
     * @param view
     */
    public void restartActivity(View view){
        this.recreate();
    }

    /**
     * Método que se encargará de parar el juego y mostrar el mensaje de fin de partida junto con el botón
     * @param mensaje que se mostrará en pantalla
     */
    private void gameOver(String mensaje){

        for (int posicionImagen = 0;posicionImagen < gridLayout.getChildCount();posicionImagen++){

            ImageView ficha = (ImageView)gridLayout.getChildAt(posicionImagen);

            ficha.setOnClickListener(null);

        }

        txtView.setText(mensaje);
        txtView.setVisibility(View.VISIBLE);
        btn.setVisibility(View.VISIBLE);
    }

    /**
     * Método que se encarga de comprobar si ya ha terminado la partida, ya sea porque se han colocado todas las fichas o porque se ha conseguido un tres en raya
     * @return 0 si aún no ha acabado, 1 si ha ganado alguien o 2 si ya no se pueden poner más fichas
     */
    private int checkGameOver(){
        int finPartida = 0;
        ArrayList<ImageView> fichas = new ArrayList<>();
        boolean todasFichasColocadas = true;

        //Volvemos a recuperar el gridLayout para que los valores de las imágenes estén actualizados
        gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        //Comprueba si se ha hecho algún tres en raya
        for (int x = 0;x < combinacionesGanadoras.length;x++){

            fichas.clear();

            for (int y = 0;y < combinacionesGanadoras[x].length;y++){

                fichas.add((ImageView)gridLayout.getChildAt(combinacionesGanadoras[x][y]));

            }

            if ((fichas.get(0).getTag()!=null && fichas.get(1).getTag()!=null && fichas.get(2).getTag()!=null)){

                int tag1, tag2, tag3;
                tag1 = (int) fichas.get(0).getTag();
                tag2 = (int) fichas.get(1).getTag();
                tag3 = (int) fichas.get(2).getTag();

                if (tag1 == tag2 && tag2 == tag3){

                    finPartida = 1;

                }

            }

        }

        //Comprueba si todas las fichas se han colocado ya, aunque no haya ganador
        for (int posicionImagen = 0;posicionImagen < gridLayout.getChildCount();posicionImagen++){

            ImageView ficha = (ImageView)gridLayout.getChildAt(posicionImagen);

            if (ficha.getTag() == null){
                todasFichasColocadas = false;
            }

        }

        //Si todas las fichas han sido colocadas y no ha ganado nadie, devuelve el valor de empate
        if (todasFichasColocadas && finPartida != 1){
            finPartida = 2;
        }

        return finPartida;
    }
}