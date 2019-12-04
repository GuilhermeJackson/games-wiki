package br.com.hbsis.hbgameswiki;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    /**
     * Seleciona todos os usuarios salvos no banco de dados
     *
     * @return List<User>
     */
    @Query("SELECT * FROM user")
    List<User> getAll();

    /**
     * Seleciona todos os usuarios que contém id igual a algum id da lista userIds
     *
     * @param userIds
     * @return List<Game>
     */
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    /**
     * Seleciona o usuário cujo login for passado como parâmetro
     *
     * @param login
     * @return
     */
    @Query("SELECT * FROM user WHERE user_login = :login ORDER BY uid ASC LIMIT 1")
    User selectByName(String login);

    /**
     * Insere todos os usuários passados como parâmetro no banco
     *
     * @param users
     */
    @Insert
    void insertAll(User... users);

    /**
     * Deleta o usuário passado como parâmetro do banco
     *
     * @param user
     */
    @Delete
    void delete(User user);
}
