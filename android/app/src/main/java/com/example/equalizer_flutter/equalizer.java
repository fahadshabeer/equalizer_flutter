package com.example.equalizer_flutter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.bullhead.equalizer.EqualizerFragment;

public class equalizer extends AppCompatActivity {
     MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_AppCompat);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equalizer);
        mediaPlayer=MediaPlayer.create(this,R.raw.lenka);
        int sessionId = mediaPlayer.getAudioSessionId();
        mediaPlayer.setLooping(true);
        EqualizerFragment equalizerFragment = EqualizerFragment.newBuilder()
                .setAccentColor(Color.parseColor("#4caf50"))
                .setAudioSessionId(sessionId)
                .build();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.eqFrame, equalizerFragment)
                .commit();
    }
}