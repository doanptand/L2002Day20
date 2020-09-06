package com.ddona.service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.ddona.service.service.MusicService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int STORAGE_PERMISSION = 1000;
    private SeekBar sbTime;
    private Button btnPrevious, btnPlay, btnNext, btnPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    STORAGE_PERMISSION);
        } else {
            startMusicService();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startMusicService();
            } else {
                Toast.makeText(this, "I'm hate you", Toast.LENGTH_LONG).show();
                btnPause.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.this.finish();
                    }
                }, 5000);
            }
        }
    }

    private void startMusicService() {
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
    }

    private void initViews() {
        sbTime = findViewById(R.id.sb_time);
        btnNext = findViewById(R.id.btn_next);
        btnPlay = findViewById(R.id.btn_play);
        btnPrevious = findViewById(R.id.btn_previous);
        btnPause = findViewById(R.id.btn_pause);
        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);


        sbTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                break;
            case R.id.btn_previous:
                break;
            case R.id.btn_play:
                break;
            case R.id.btn_pause:
                break;
        }
    }
}