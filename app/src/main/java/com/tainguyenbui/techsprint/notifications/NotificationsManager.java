package com.tainguyenbui.techsprint.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.tainguyenbui.techsprint.HomeActivity;
import com.tainguyenbui.techsprint.R;

/**
 * Created by tainguyenbui on 15/03/2017.
 */

public class NotificationsManager {

    private Context context;
    private NotificationManager notificationManager;

    public NotificationsManager(Context context, NotificationManager notificationManager) {

        this.context = context;
        this.notificationManager = notificationManager;
    }

    public void sendNotification(int notificationId, String title, String message, Class<?> sourceActivityClass) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle(title)
                        .setContentText(message);

        Intent resultIntent = new Intent(context, sourceActivityClass);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(sourceActivityClass);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);

        notificationManager.notify(notificationId, mBuilder.build());
    }
}
