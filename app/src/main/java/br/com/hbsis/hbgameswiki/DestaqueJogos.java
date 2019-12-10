package br.com.hbsis.hbgameswiki;

public class DestaqueJogos {

    private int imagem;
    private String titulo;
    private String descricao;

    /**
     * Classe que exibe jogos na tela de destaque na Tela Principal
     *
     * @param imagem    Define a imagem do jogo a ser exibido na tela de destaque
     * @param titulo    Define o titulo do jogo a ser exibido na tela de destaque
     * @param descricao Define a descrição do jogo a ser exibido na tela de destaque
     * @author Sandro Diego Adão
     */

    public DestaqueJogos(int imagem, String titulo, String descricao) {
        this.imagem = imagem;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}