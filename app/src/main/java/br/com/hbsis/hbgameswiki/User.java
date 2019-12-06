package br.com.hbsis.hbgameswiki;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Classe do objeto User
 *
 *  Definida com a tag Entity para que possa ser usada para gerar uma tabela através do Room. As
 * propriedades da classe tornarão-se as colunas da tabela.
 *
 * @author André Guilherme Theilacker <andretheilacker@gmail.com>
 * @author João Eduardo Mendes Chaicoski <jemchaicoski@hotmail.com>
 * @since 1.0.0
 */
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int uId;

    @ColumnInfo(name = "user_login")
    private String login;

    @ColumnInfo(name = "user_password")
    private String senha;

    @ColumnInfo(name = "user_email")
    private String email;

    /**
     * Construtor da classe User
     *
     * Verifica se os campos de login e senha estão preenchidos corretamente, ao verificar se estão
     * vazios e também pesquisando o login no banco de dados. Caso a busca pelo login retorne
     * um usuário, a função validarLogin() é chamada.
     *
     * @param login Nome cadastrado que será utilizado para login do usuário
     * @param senha Senha cadastrada que será utilizada para login do usuário
     * @param email Email cadastrado que será utilizado para comunicação com o usuário
     * @return void
     * @since 1.0.0
     */
    public User(String login, String senha, String email) {
        setLogin(login);
        setSenha(senha);
        setEmail(email);
    }

    /**
     * Retorna o Id do usuário
     *
     * @return int
     * @since 1.0.0
     */
    public int getUId() {
        return uId;
    }

    /**
     * Define o Id do usuário
     *
     * Este método não deve ser usado fora da classe, e é declarado aqui apenas pois o Room requer
     * um método get e set em cada parâmetro para funcionar.
     *
     * @param uId Id do usuário
     * @since 1.0.0
     */
    public void setUId(int uId) {
        this.uId = uId;
    }

    /**
     * Retorna o login do usuário
     *
     * @return int
     * @since 1.0.0
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define o login do usuário
     *
     * @param login Login do usuário
     * @since 1.0.0
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Retorna a senha do usuário
     *
     * @return String
     * @since 1.0.0
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário
     *
     * @param senha Senha do usuário
     * @since 1.0.0
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna o email do usuário
     *
     * @return String
     * @since 1.0.0
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário
     *
     * @param email Email do usuário
     * @since 1.0.0
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
