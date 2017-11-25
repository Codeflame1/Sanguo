package com.example.asus.sanguo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MusicService extends Service {
    private  MediaPlayer Mediaplayer;

    @Override
    public void onCreate() {
        super.onCreate();
        Mediaplayer = MediaPlayer.create(this, R.raw.quanyutianxia);
        Mediaplayer.start();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Mediaplayer.start();
        //重复播放
        Mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        //播放错误的处理
        Mediaplayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                //释放资源
                mp.release();
                return false;
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //停止并释放资源
        Mediaplayer.release();
        Mediaplayer=null;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
