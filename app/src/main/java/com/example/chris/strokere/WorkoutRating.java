package com.example.chris.strokere;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author Christopher Womersley
 * Class for taking borg rating and inputting them to the db
 *
 */
public class WorkoutRating extends BaseActivity {

    private NumberPicker ratingScale;
    private DatabaseReference mDatabase;
    private int borgRating;
    private String userID;
    private FirebaseUser user;
    private VideoStats videoStats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_rating);
        videoStats = new VideoStats();
         mDatabase = FirebaseDatabase.getInstance().getReference();

        //for nav bar
        setupNavbar();


        ratingScale = (NumberPicker) findViewById(R.id.numberPicker6);
        Button finish = (Button) findViewById(R.id.finishBtn);

        ratingScale.setMaxValue(20);
        ratingScale.setMinValue(6);
        ratingScale.setWrapSelectorWheel(false);

        finish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                borgRating = ratingScale.getValue();
                if(user != null) {
                    videoStats.splitString();
                    mDatabase.child("BorgRatings").child(userID).child(getTime()).setValue(borgRating);
                }
                Intent intent = new Intent(WorkoutRating.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        FirebaseAuth.getInstance().addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                 user = firebaseAuth.getCurrentUser();
                if(user != null) {
                    userID = user.getUid();
                }
            }
        });

    }

    /**
     * Gets the current data from the android system
     * @return the date as a string
     */
    public String getTime() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat time = new SimpleDateFormat("dd_MM_YY");
        String timeString = time.format(calendar.getTime());
        return timeString;
    }

    @Override
    public int getLayout () {
        return R.layout.activity_home;
    }


}


