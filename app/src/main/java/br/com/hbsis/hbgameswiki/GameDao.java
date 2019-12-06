package br.com.hbsis.hbgameswiki;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Interface que permite interagir com a tabela Game
 *
 * @author André Guilherme Theilacker <andretheilacker@gmail.com>
 * @since 1.0.0
 */
@Dao
public interface GameDao {
    /**
     * Seleciona todos os jogos guardados no banco de dados
     *
     * @return List<Game>
     */
    @Query("SELECT * FROM game")
    List<Game> getAll();

    /**
     * Seleciona todos os jogos que contém id igual a algum id da lista gameIds
     *
     * @param gameIds Lista de id's de jogo
     * @return List<Game>
     */
    @Query("SELECT * FROM game WHERE gid IN (:gameIds)")
    List<Game> loadAllByIds(int[] gameIds);

    /**
     * Retorna todos os jogos que contém o parâmetro name no campo gameName
     *
     * @param name Nome ou parte do nome de um jogo
     * @return List<Game>
     */
    @Query("SELECT * FROM game WHERE game_name LIKE '%' || :name || '%'")
    List<Game> searchByName(String name);

    /**
     * Retorna todos os jogos que contém a tag passada no parâmetro tag
     *
     * @param tag Tag de um jogo
     * @return List<Game>
     */
    @Query("SELECT * FROM game WHERE game_tags LIKE '%' || :tag || '%'")
    List<Game> searchByTag(String tag);

    /**
     * Insere todos os games passados como parâmetro no banco
     *
     * @param games Jogos a serem cadastrados
     * @since 1.0.0
     */
    @Insert
    void insertAll(Game... games);

    /**
     * Deleta o jogo passado como parâmetro do banco
     *
     * @param game Game a ser deletado
     * @since 1.0.0
     */
    @Delete
    void delete(Game game);
}