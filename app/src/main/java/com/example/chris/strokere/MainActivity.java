package com.example.chris.strokere;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Listner for Log in button to go to log inscreen
        Button logInBtn = (Button) findViewById(R.id.logInBtn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, LoginScreen.class));
            }
        });

        //Set typeface for button
        Typeface latoRegular = Typeface.createFromAsset(getAssets(), "Lato-Regular.ttf");
        logInBtn.setTypeface(latoRegular);

        //Listner for Log in button to go to Register screen
        Button registerBtn = (Button) findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
        //Set typeface for button
        registerBtn.setTypeface(latoRegular);
    }

}
