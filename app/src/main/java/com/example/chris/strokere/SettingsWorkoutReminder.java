package com.example.chris.strokere;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsWorkoutReminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_workout_reminder);

        TextView whichDays = (TextView) findViewById(R.id.whichDaysTextWR);
        whichDays.setTypeface(FontHelper.getLatoRegular(getApplicationContext()));

        Button notifierBtn = (Button) findViewById(R.id.notifierBtn);
        notifierBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                notifier();
            }
        });



    }

    public void notifier() {
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Workout Reminder")
                .setContentText("Time to workout...");

// Sets an ID for the notification
        int mNotificationId = 001;
// Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

}