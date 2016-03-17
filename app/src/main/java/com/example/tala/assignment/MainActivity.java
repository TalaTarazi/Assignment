package com.example.tala.assignment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import static com.example.tala.assignment.R.id.textNumber;


public class MainActivity extends AppCompatActivity {

     int guessNum;// the guessed number
     int secretNum;// the random number


    /*
        A function that checks if the number is greater, smaller, very close, or if the user won
     */
    public  void guess() {

            EditText text = (EditText)findViewById(textNumber);
            guessNum = Integer.parseInt(text.getText().toString());
            text.setText("");
            //when the number guessed is the same as the random number the app will restart the game
            if (guessNum == secretNum){
                Toast toast = Toast.makeText(getBaseContext(), "you won  ", Toast.LENGTH_SHORT);
                toast.show();
                restart();
            }
            //when the guessed number in range of 5
            else if(guessNum< secretNum + 5 && guessNum >secretNum - 5){
                Toast toast = Toast.makeText(getBaseContext(), "too close", Toast.LENGTH_SHORT);
                toast.show();
            } else if (guessNum < secretNum) {
                Toast toast = Toast.makeText(getBaseContext(), "guess higher", Toast.LENGTH_SHORT);
                toast.show();
            } else if (guessNum > secretNum) {
                Toast toast = Toast.makeText(getBaseContext(), "guess lower", Toast.LENGTH_SHORT);
                toast.show();
            }


        }


    //when the btn restart was clicked
    public void restartGame(View view){
        restart();
    }
    //generates a new random number
    public void restart(){
        EditText text = (EditText)findViewById(textNumber);
        text.setHint("Enter number between 1-1000");
        generateNum();
    }


    //when the guess btn was clicked
     public void guessGame(View view){
         guess();

     }
    //generate a new random number
    public void generateNum(){
        Random random= new Random();
        secretNum = random.nextInt(1001);//a number from 0-1000
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateNum();
    }
}

