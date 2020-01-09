package br.com.hbsis.hbgameswiki;

import org.junit.Assert;
import org.junit.Test;


public class DestaqueJogosTest {

    /*
     * Teste do parâmetro int imagem do construtor da classe DestaqueJogos;
     */

    @Test
    public void testImagemConstrutor(){
        String tituloJogo = "GTA";
        String descricaoJogo = "Jogo em terceira pessoa";
        int imagemJogo = 111111;
        DestaqueJogos destaqueJogos = new DestaqueJogos(imagemJogo, tituloJogo, descricaoJogo);
        Assert.assertEquals(imagemJogo,destaqueJogos.getImagem());
    }

    /*
     * Teste do parâmetro string Titulo do construtor da classe DestaqueJogos;
     */
    @Test
    public void testTituloConstrutor(){
        String tituloJogo = "GTA";
        String descricaoJogo = "Jogo em terceira pessoa";
        int imagemJogo = 111111;
        DestaqueJogos destaqueJogos = new DestaqueJogos(imagemJogo, tituloJogo, descricaoJogo);
        Assert.assertEquals(tituloJogo,destaqueJogos.getTitulo());
    }

    /*
     * Teste do parâmetro string Descrição do construtor da classe DestaqueJogos;
     */
    @Test
    public void testDescricaoConstrutor(){
        String tituloJogo = "GTA";
        String descricaoJogo = "Jogo em terceira pessoa";
        int imagemJogo = 111111;
        DestaqueJogos destaqueJogos = new DestaqueJogos(imagemJogo, tituloJogo, descricaoJogo);
        Assert.assertEquals(descricaoJogo,destaqueJogos.getDescricao());
    }

}