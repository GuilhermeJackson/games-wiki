package br.com.hbsis.hbgameswiki;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Game.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GameDao gameDao();
}
