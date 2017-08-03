package com.example.chris.strokere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Sam on 31/07/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        setupToolbar();
    }

    /**
     * Gets which activity is currently active
     */
    protected abstract int getLayout();

    public void setupToolbar() {

        ImageButton homeNavBtn = (ImageButton) findViewById(R.id.homeNavBtn);
        homeNavBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (getLayout() != R.layout.activity_home) {
                    startActivity(new Intent(BaseActivity.this, Home.class));
                }
            }
        });

        ImageButton myExerciseNavBtn = (ImageButton) findViewById(R.id.myExerciseNavBtn);
        myExerciseNavBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (getLayout() != R.layout.activity_exercise_view) {
                    startActivity(new Intent(BaseActivity.this, ExerciseView.class));
                }
            }
        });

        ImageButton exerciseListNavBtn = (ImageButton) findViewById(R.id.exerciseListNavBtn);
        exerciseListNavBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (getLayout() != R.layout.activity_exercise_list) {
                    startActivity(new Intent(BaseActivity.this, ExerciseList.class));
                }
            }
        });

        ImageButton progressNavBtn = (ImageButton) findViewById(R.id.progressNavBtn);
        progressNavBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (getLayout() != R.layout.activity_progress) {
                    startActivity(new Intent(BaseActivity.this, Progress.class));
                }
            }
        });

        ImageButton preferencesNavBtn = (ImageButton) findViewById(R.id.preferencesNavBtn);
        preferencesNavBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (getLayout() != R.layout.activity_settings) {
                    startActivity(new Intent(BaseActivity.this, Settings.class));
                }
            }
        });
    }
}
