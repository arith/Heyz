package codetech.my.heyz;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import codetech.my.heyz.Views.DefaultActivity;

/**
 * Created by kamarulzaman on 6/14/15.
 */
public class GCMBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager mPowerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock mWakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "GCMBroadcastReceiver");
        mWakeLock.acquire();
        try {
            GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
            String messageType = gcm.getMessageType(intent);
            Bundle extras = intent.getExtras();

            if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
                Log.d("status", "Message type send error");
            }

            if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(messageType)) {
                Log.d("status", "Message type send deleted");
            }

            if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                if (extras.getString("myuser") != null) {
                    if (extras.getString("myuser").equals("yes")) {
                        sendNotification(context, "Interest nearby", "You found a same interest nearby, check it out!");
                    }
                }

            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void sendNotification(Context context, String title, String text){
        Intent intent = new Intent(context, DefaultActivity.class);
        intent.putExtra("message", text);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                context)
                .setSmallIcon(R.drawable.ic_launcher)
                .setTicker(text)
                .setContentTitle(title)
                .setContentText(text)
                .setContentIntent(pIntent)
                .setAutoCancel(true);
        NotificationManager notificationmanager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationmanager.notify(0, builder.build());
    }


}
