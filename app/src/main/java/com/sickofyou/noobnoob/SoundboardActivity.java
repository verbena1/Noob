package com.sickofyou.noobnoob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoundboardActivity extends AppCompatActivity {

    ArrayList<SoundObject> soundlist = new ArrayList<>();
    RecyclerView SoundView;
    SoundboardRecyclerAdapter SoundAdapter = new SoundboardRecyclerAdapter(soundlist);
    RecyclerView.LayoutManager SoundLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundboard);

        List<String> nameList = Arrays.asList(getResources().getStringArray(R.array.sound_names));
        SoundObject[] soundItems = {new SoundObject(nameList.get(0),R.raw.gd2)};
        soundlist.addAll(Arrays.asList(soundItems));
        SoundView = findViewById(R.id.soundboardRecyclerView);
        SoundLayoutManager = new GridLayoutManager(this, 1);
        SoundView.setLayoutManager(SoundLayoutManager);
        SoundView.setAdapter(SoundAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventHandlerClass.releaseMediaPlayer();
    }
}
