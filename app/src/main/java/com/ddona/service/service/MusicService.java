package com.ddona.service.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.ddona.service.R;
import com.ddona.service.media.MediaManager;

public class MusicService extends Service {
    private MediaManager mediaManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaManager = new MediaManager(this);
        mediaManager.play();
        Log.d("doanpt", "oncreate");
        runForeground();
    }

    private void runForeground() {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Music");
        builder.setContentText("This is song name");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel =
                    new NotificationChannel("1",
                            "music",
                            NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
            builder.setChannelId(channel.getId());
        }

        Notification notification = builder.build();
        startForeground(1, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("doanpt", "onStartCommand");
        return START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MusicBinder();
    }

    public class MusicBinder extends Binder {
        public MusicService getMusicService() {
            return MusicService.this;
        }
    }

    public MediaManager getMediaManager() {
        return mediaManager;
    }
}
