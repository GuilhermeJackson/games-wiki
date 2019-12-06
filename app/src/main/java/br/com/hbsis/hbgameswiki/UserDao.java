package br.com.hbsis.hbgameswiki;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Interface que permite interagir com a tabela User
 *
 * @author André Guilherme Theilacker <andretheilacker@gmail.com>
 * @since 1.0.0
 */
@Dao
public interface UserDao {
    /**
     * Seleciona todos os usuarios salvos no banco de dados
     *
     * @return List<User>
     * @since 1.0.0
     */
    @Query("SELECT * FROM user")
    List<User> getAll();

    /**
     * Seleciona todos os usuarios que contém id igual a algum id da lista userIds
     *
     * @param userIds Array contendo id's de usuário
     * @return List<Game>
     *     @since 1.0.0
     */
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    /**
     * Seleciona o usuário cujo login for passado como parâmetro
     *
     * @param login Login cadastrado do usuário
     * @return User
     * @since 1.0.0
     */
    @Query("SELECT * FROM user WHERE user_login = :login ORDER BY uid ASC LIMIT 1")
    User selectByName(String login);

    /**
     * Insere todos os usuários passados como parâmetro no banco
     *
     * @param users Usuários a serem cadastrados
     * @since 1.0.0
     */
    @Insert
    void insertAll(User... users);

    /**
     * Deleta o usuário passado como parâmetro do banco
     *
     * @param user Usuário a ser deletado
     * @since 1.0.0
     */
    @Delete
    void delete(User user);
}
