package br.com.hbsis.hbgameswiki;

import android.widget.Button;

public class Jogos {

    private String Titulo, Categoria, Descricao, Genero, Desenvolvedora;
    private int ImagemPequenaTP, ImagemGrandeTP, JogoFavorito, Avaliacao, MinValor, MaxValor;
    private int ImagemPequena1TDJ, ImagemPequena2TDJ, ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ, ImagemGrandeTDJ, QRCODE;

    public Jogos() {
    }

    /**
     * Classe utilizada para exibir jogos
     * <p>
     * Esta classe passa como parâmetros as informações nescessária para exibir o jogo no card da tela principal
     * Indicadores: TP = Tela Principal, TDJ = Tela Detalhes Jogos.
     *
     * @param titulo
     * @param categoria
     * @param descricao
     * @param genero
     * @param desenvolvedora
     * @param img_pequena_TP
     * @param img_grande_TP
     * @param avaliacao
     * @param minValor
     * @param maxValor
     * @param jogoFavorito
     * @param img_pequena_1_TDJ
     * @param img_pequena_2_TDJ
     * @param img_pequena_3_TDJ
     * @param img_pequena_4_TDJ
     * @param img_pequena_5_TDJ
     * @param img_grande_TDJ
     * @Author Sandro Diego Adão
     */

    public Jogos(int QrCode, String titulo, String categoria, String descricao, String genero, String desenvolvedora, int img_pequena_TP, int img_grande_TP, int avaliacao, int minValor, int maxValor, int jogoFavorito, int img_pequena_1_TDJ, int img_pequena_2_TDJ, int img_pequena_3_TDJ, int img_pequena_4_TDJ, int img_pequena_5_TDJ, int img_grande_TDJ) {
        // Tela Principal
        QRCODE = QrCode;
        Titulo = titulo;
        Categoria = categoria;
        Descricao = descricao;
        ImagemPequenaTP = img_pequena_TP;
        ImagemGrandeTP = img_grande_TP;
        JogoFavorito = jogoFavorito;
        Genero = genero;
        Desenvolvedora = desenvolvedora;
        Avaliacao = avaliacao;
        MinValor = minValor;
        MaxValor = maxValor;
        // Tela Detalhes Jogos
        ImagemPequena1TDJ = img_pequena_1_TDJ;
        ImagemPequena2TDJ = img_pequena_2_TDJ;
        ImagemPequena3TDJ = img_pequena_3_TDJ;
        ImagemPequena4TDJ = img_pequena_4_TDJ;
        ImagemPequena5TDJ = img_pequena_5_TDJ;
        ImagemGrandeTDJ = img_grande_TDJ;
    }

    public int getQRCODE() {
        return QRCODE;
    }

    public void setQRCODE(int QRCODE) {
        this.QRCODE = QRCODE;
    }

    public int getImagemPequena1TDJ() {
        return ImagemPequena1TDJ;
    }

    public void setImagemPequena1TDJ(int imagemPequena1TDJ) {
        ImagemPequena1TDJ = imagemPequena1TDJ;
    }

    public int getImagemPequena2TDJ() {
        return ImagemPequena2TDJ;
    }

    public void setImagemPequena2TDJ(int imagemPequena2TDJ) {
        ImagemPequena2TDJ = imagemPequena2TDJ;
    }

    public int getImagemPequena3TDJ() {
        return ImagemPequena3TDJ;
    }

    public void setImagemPequena3TDJ(int imagemPequena3TDJ) {
        ImagemPequena3TDJ = imagemPequena3TDJ;
    }

    public int getMinValor() {
        return MinValor;
    }

    public void setMinValor(int minValor) {
        MinValor = minValor;
    }

    public int getMaxValor() {
        return MaxValor;
    }

    public void setMaxValor(int maxValor) {
        MaxValor = maxValor;
    }

    public int getImagemPequena4TDJ() {
        return ImagemPequena4TDJ;
    }

    public void setImagemPequena4TDJ(int imagemPequena4TDJ) {
        ImagemPequena4TDJ = imagemPequena4TDJ;
    }

    public int getImagemPequena5TDJ() {
        return ImagemPequena5TDJ;
    }

    public void setImagemPequena5TDJ(int imagemPequena5TDJ) {
        ImagemPequena5TDJ = imagemPequena5TDJ;
    }

    public int getImagemGrandeTDJ() {
        return ImagemGrandeTDJ;
    }

    public void setImagemGrandeTDJ(int imagemGrandeTDJ) {
        ImagemGrandeTDJ = imagemGrandeTDJ;
    }

    public int getImagemPequenaTP() {
        return ImagemPequenaTP;
    }

    public void setImagemPequenaTP(int imagemPequenaTP) {
        ImagemPequenaTP = imagemPequenaTP;
    }

    public int getImagemGrandeTP() {
        return ImagemGrandeTP;
    }

    public void setImagemGrandeTP(int imagemGrandeTP) {
        ImagemGrandeTP = imagemGrandeTP;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getDesenvolvedora() {
        return Desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        Desenvolvedora = desenvolvedora;
    }

    public int getAvaliacao() {
        return Avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        Avaliacao = avaliacao;
    }

    public int getJogoFavorito() {
        return JogoFavorito;
    }

    public void setJogoFavorito(int jogoFavorito) {
        JogoFavorito = jogoFavorito;
    }

    public void getJogoFavorito(int jogoFavorito) {
        JogoFavorito = jogoFavorito;
    }

}