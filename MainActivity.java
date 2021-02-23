package com.example.casinogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView YourDie = findViewById(R.id.you);
        final ImageView ComputerDie = findViewById(R.id.computer);
        Button rollButton1 = findViewById(R.id.higher);
        Button rollButton2 = findViewById(R.id.lower);
        //-------------------------------------------------------------------

        final int[] diceArray = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};

        rollButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                int higher1 = rand.nextInt(6);
                int higher2 = rand.nextInt(6);
                Log.d("your die", String.valueOf(higher1));
                Log.d("computer die", String.valueOf(higher2));

                YourDie.setImageResource(diceArray[higher1]);
                ComputerDie.setImageResource(diceArray[higher2]);
                TextView r = (TextView) findViewById(R.id.result);
                // we need to create a random integer for picking the dices randomly!
                if(higher1>higher2){
                    r.setText("you are winner");
                }
                else if(higher2>higher1) {
                    r.setText("Computer is winner!");
                }
                else{
                    r.setText("It's a Tie");
                }

            }
        });
        rollButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                int lower1 = rand.nextInt(6);
                int lower2 = rand.nextInt(6);
                Log.d("your die", String.valueOf(lower1));
                Log.d("computer die", String.valueOf(lower2));

                YourDie.setImageResource(diceArray[lower1]);
                ComputerDie.setImageResource(diceArray[lower2]);
                // we need to create a random integer for picking the dices randomly!
                TextView r = (TextView) findViewById(R.id.result);
                // we need to create a random integer for picking the dices randomly!
                if(lower1>lower2){
                    r.setText("Computer is a Winner!");
                }
                else if(lower2>lower1) {
                    r.setText("You are a Winner!");
                }
                else{
                    r.setText("It's a Tie");
                }


            }
        });
    }
}