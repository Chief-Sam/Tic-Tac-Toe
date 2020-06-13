package com.project.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0: Zero    &    1: Cross    &     2: Empty
        int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        int[] gameState = {2,2,2,2,2,2,2,2,2};
        int activePlayer = 0;
        boolean gameActive = true;
    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2 && gameActive){
        gameState[tappedCounter] = activePlayer ;
            counter.setTranslationY(-1500);
            if (activePlayer == 0){
            counter.setImageResource(R.drawable.zero);
            activePlayer = 1 ;    }
            else {
                counter.setImageResource(R.drawable.x);
                activePlayer = 0 ;
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            for (int[] winningPositions : winningPositions){
                if(gameState[winningPositions[0]] == gameState[winningPositions[1]] && gameState[winningPositions[1]] == gameState[winningPositions[2]] && gameState[winningPositions[0]] != 2) {
                    String winner = "";
                    gameActive = false;
                    if (activePlayer == 1) {
                        winner = "Zero";
                    } else {
                        winner = "Cross";
                    }
                    Button playAgainButton = (Button) findViewById(R.id.btn_PlayAgain);
                    TextView txtWinner = (TextView) findViewById(R.id.textView_result);
                    Button reset = (Button) findViewById(R.id.btnReset);
                    txtWinner.setText(winner + " has won !");
                    playAgainButton.setVisibility(View.VISIBLE);
                    txtWinner.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.INVISIBLE);



                }
            }
    }
    }
             public void playAgain(View view) {
                 Button playAgainButton = (Button) findViewById(R.id.btn_PlayAgain);
                 TextView txtWinner = (TextView) findViewById(R.id.textView_result);
                 Button reset = (Button) findViewById(R.id.btnReset);
                 playAgainButton.setVisibility(View.INVISIBLE);
                 txtWinner.setVisibility(View.INVISIBLE);
                 reset.setVisibility(View.VISIBLE);

                 GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
                 for (int i = 0; i < gridLayout.getChildCount(); i++) {

                     ImageView imgCounter = (ImageView) gridLayout.getChildAt(i);
                     imgCounter.setImageDrawable(null);

                 }
                 for(int i =0; i<gameState.length;i++) {
                     gameState[i] = 2;
                 }
                 activePlayer = 0;
                 gameActive = true;
             }
             public void reset(View view){
                 Button reset = (Button) findViewById(R.id.btnReset);
                 reset.setVisibility(View.VISIBLE);


                 GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
                 for (int i = 0; i < gridLayout.getChildCount(); i++) {

                     ImageView imgCounter = (ImageView) gridLayout.getChildAt(i);
                     imgCounter.setImageDrawable(null);

                 }
                 for(int i =0; i<gameState.length;i++) {
                     gameState[i] = 2;
                 }
                 activePlayer = 0;
                 gameActive = true;

             }
             public void exit(View view){
                Button exit = (Button) findViewById(R.id.btnExit);
                Toast.makeText(this,"Thanks for Playing!",Toast.LENGTH_SHORT).show();
                finish();
             }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
