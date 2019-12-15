package br.com.hbsis.hbgameswiki;

public class Generos {

    private String genero;

    /**
     * Classe genêros utilizado na tela principal
     * <p>
     * Utiliza-se essa classe para criar novos genêros de jogos para poder classificá-los e filtrá-los
     *
     * @param genero Define os genêros a ser utilizado na classe
     * @Author Sandro Diego Adão
     */

    public Generos(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}