package com.devio.BrawlStarstutorials.logic;

import android.content.Context;
import android.media.MediaPlayer;

import com.devio.BrawlStarstutorials.R;


public class PlayAudio {

    private final Context mContext;
    private MediaPlayer mediaPlayer;

    public PlayAudio(Context context) {
        this.mContext = context;
    }

    public void setAudioforEvent(int FLAG) {  //  1 2 3

        switch (FLAG) {

            case 1:
                int correctAudio = R.raw.correct;
                playMusic(correctAudio);
                break;

            case 2:
                int wrongAudio = R.raw.wrong;
                playMusic(wrongAudio);
                break;

            case 3:
                int timerAudio = R.raw.times_up_sound;
                playMusic(timerAudio);
                break;


        }

    }

    private void playMusic(int audioFile) {

        mediaPlayer = MediaPlayer.create(mContext, audioFile);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                mediaPlayer.start();

            }
        });


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });


    }


}
