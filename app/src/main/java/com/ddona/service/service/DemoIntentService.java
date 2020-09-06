package com.ddona.service.service;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class DemoIntentService extends IntentService {
    public DemoIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent.getAction().equals("incomming_message")) {
            //save message
        } else if(intent.getAction().equals("outcomming_message")) {
            //send message
        } else {
            //do something
        }

    }
}
