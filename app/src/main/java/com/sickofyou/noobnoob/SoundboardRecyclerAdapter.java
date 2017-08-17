package com.sickofyou.noobnoob;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SoundboardRecyclerAdapter extends RecyclerView.Adapter<SoundboardRecyclerAdapter.SoundboardViewHolder> {

    private ArrayList<SoundObject> soundObjects;
    SoundboardRecyclerAdapter(ArrayList<SoundObject> soundObjects) {
        this.soundObjects = soundObjects;
    }
    @Override
    public SoundboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item, null);
        return new SoundboardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SoundboardViewHolder holder, int position) {
        final SoundObject object = soundObjects.get(position);
        final Integer soundId = object.getItemId();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventHandlerClass.startMediaPlayer(view, soundId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return soundObjects.size();
    }

    class SoundboardViewHolder extends RecyclerView.ViewHolder {

        SoundboardViewHolder(View itemView) {
            super(itemView);
        }
    }
}
