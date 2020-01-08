package br.com.hbsis.hbgameswiki;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GameDao {
    /**Seleciona todos os jogos guardados no banco de dados
     *
     * @return List<Game>
     */
    @Query("SELECT * FROM game")
    List<Game> getAll();

    /** Seleciona todos os jogos que contém id igual a algum id da lista gameIds
     *
     * @param gameIds
     * @return List<Game>
     */
    @Query("SELECT * FROM game WHERE gid IN (:gameIds)")
    List<Game> loadAllByIds(int[] gameIds);

    @Query("SELECT * FROM game WHERE game_name LIKE '%' || :name || '%'")
    List<Game> searchByName(String name);

    @Query("SELECT * FROM game WHERE game_tags LIKE '%' || :tag || '%'")
    List<Game> searchByTag(String tag);

    @Query("SELECT * FROM game WHERE game_name = :name")
    Game inserirGame(String name);

    @Query("SELECT * FROM game WHERE gId = (SELECT MAX(gId)  FROM game);")
    Game pegaUltimoJogo();

    @Insert
    void insertAll(Game... games);

    @Delete
    void delete(Game game);
}