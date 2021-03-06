package com.example.chris.strokere;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

/**
 * NotificationReceiver
 *
 * <P>Creates a notification with a set of specified features
 *
 * @author Sam Ward
 */

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context);

        Calendar calendar = Calendar.getInstance();
        calendar.get(Calendar.MINUTE);

        calendar.getTime();

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = date.format(calendar.getTime());
        Toast.makeText(context, formattedDate, Toast.LENGTH_SHORT).show();

        notificationBuilder.setContentInfo("Time to exercise")
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.logo_old)
                .setContentTitle("This is a workout Reminder")
                .setContentText("Time to workout...");


                notificationBuilder.setLights(0xFFb71c1c, 1000, 2000);

                Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                notificationBuilder.setSound(uri);


        int id = 001;
        NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notifyManager.notify(id, notificationBuilder.build());

    }
}
