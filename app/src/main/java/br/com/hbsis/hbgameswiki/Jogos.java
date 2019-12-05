package br.com.hbsis.hbgameswiki;

import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.ArrayList;

public class Jogos {
    private String nome;
    private String descricao;
    private String generos = "";
    private ImageView imagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public ImageView getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
    }
}
