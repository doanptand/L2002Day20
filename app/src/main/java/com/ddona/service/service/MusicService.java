package com.ddona.service.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.ddona.service.media.MediaManager;

public class MusicService extends Service {
    private MediaManager mediaManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaManager = new MediaManager(this);
        mediaManager.play();
        Log.d("doanpt","oncreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("doanpt","onStartCommand");
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
