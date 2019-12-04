package br.com.hbsis.hbgameswiki;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    public User(String login, String senha, String email) {
        setLogin(login);
        setSenha(senha);
        setEmail(email);
    }

    public int getUId() {
        return uId;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
