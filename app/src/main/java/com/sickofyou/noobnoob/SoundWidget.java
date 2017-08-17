package com.sickofyou.noobnoob;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class SoundWidget extends AppWidgetProvider {

    private static String ACTION_SOUNDWIDGET = "ACTION_SOUNDWIDGET";
    private static MediaPlayer mediaPlayer;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.sound_widget);
        Intent intent = new Intent(context, SoundWidget.class);
        intent.setAction(ACTION_SOUNDWIDGET);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.soundwidget, pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (mediaPlayer == null)
            mediaPlayer = MediaPlayer.create(context, R.raw.gd2);

        if (intent.getAction().equals(ACTION_SOUNDWIDGET)) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(context, R.raw.gd2);
            } else {
                mediaPlayer.start();
            }
        }

        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
}

