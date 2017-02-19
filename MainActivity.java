package de.clarisweb.ugu5ma.highlow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import static de.clarisweb.ugu5ma.highlow.R.id.guessEditText;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    int versuche;

    public void makeToast(String string) {

        Toast.makeText(MainActivity.this, string, Toast.LENGTH_LONG).show();

    }



    public void guess(View view) {

        EditText guessEditText = (EditText) findViewById(R.id.guessEditText);

        int guessInt = Integer.parseInt(guessEditText.getText().toString());



        if (guessInt > randomNumber) {

            makeToast("Lower");

            versuche = versuche + 1;
            Log.i("Versuche", Integer.toString(versuche));

        }   else if (guessInt < randomNumber) {

            makeToast("Higher");
            versuche = versuche + 1;
            Log.i("Versuche", Integer.toString(versuche));


        } else {


            versuche = versuche + 1;
            Log.i("Versuche", Integer.toString(versuche));


            makeToast("!!! Got it in " + versuche +" guesses !!!, try again");

            Random rand = new Random();

            randomNumber = rand.nextInt(20) + 1;

            Log.i("RandomNumber", Integer.toString(randomNumber));

            versuche = 0;

        }
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();

        randomNumber = rand.nextInt(20) + 1;

        Log.i("RandomNumber", Integer.toString(randomNumber));

        versuche = 0;

        Log.i("Versuche", Integer.toString(versuche));

    }
}
