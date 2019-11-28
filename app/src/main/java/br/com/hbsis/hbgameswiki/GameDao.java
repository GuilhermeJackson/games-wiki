package br.com.hbsis.hbgameswiki;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GameDao {
    @Query("SELECT * FROM game")
    List<Game> getAll();

    @Query("SELECT * FROM game WHERE gid IN (:gameIds)")
    List<Game> loadAllByIds(int[] gameIds);

    @Query("SELECT * FROM game WHERE game_name LIKE '%' || :name || '%'")
    List<Game> searchByName(String name);

    @Query("SELECT * FROM game WHERE game_tags LIKE '%' || :tag || '%'")
    List<Game> searchByTag(String tag);

    @Insert
    void insertAll(Game... games);

    @Delete
    void delete(Game game);
}