package br.com.hbsis.hbgameswiki;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Classe do banco de dados usada na aplicação
 *
 *  A tag Database define, no parametro entities, as tabelas que serão criadas no campo (no caso, Game e User),
 * a version define a versão atual do banco e o exportSchema define se é possível exportar o banco.
 *
 *  A classe extende de RoomDatabase, classe base para se acessar um banco de dados pelo Room.
 *
 *  Os métodos abstratos gameDao() e userDao() são usados para interagir com as tabelas respectivas.
 *
 * @author André Guilherme Theilacker <andretheilacker@gmail.com>
 * @since 1.0.0
 */
@Database(entities = {Game.class, User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GameDao gameDao();

    public abstract UserDao userDao();
}
