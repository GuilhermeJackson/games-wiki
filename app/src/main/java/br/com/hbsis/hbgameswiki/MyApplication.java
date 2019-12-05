package br.com.hbsis.hbgameswiki;

import android.app.Application;

import androidx.room.Room;

public class MyApplication extends Application {
    public static AppDatabase db;

    public void startRoomDatabase(){
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "user").build();
    }
}
