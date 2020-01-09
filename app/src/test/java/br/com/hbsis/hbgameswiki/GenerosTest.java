package br.com.hbsis.hbgameswiki;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerosTest {

    /*
     * Teste do parâmetro string genero do construtor da classe Generos;
     */

    @Test
    public void testGenero(){
        String generoJogo = "RPG";
        Generos generos = new Generos(generoJogo);
        Assert.assertEquals(generoJogo,generos.getGenero());
    }

}