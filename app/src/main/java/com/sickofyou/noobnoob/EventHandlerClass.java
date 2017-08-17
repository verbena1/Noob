package com.sickofyou.noobnoob;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;

class EventHandlerClass {

    private static final String LOG_TAG = "Event Handler";
    private static MediaPlayer mediaPlayer;

    static void startMediaPlayer(View view, Integer soundId) {
        try {
            if (soundId != null) {
                if (mediaPlayer != null)
                    mediaPlayer.reset();
                mediaPlayer = MediaPlayer.create(view.getContext(), soundId);
                mediaPlayer.start();
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "Failed to init MediaPlayer: " + e.getMessage());
        }
    }

    static void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
