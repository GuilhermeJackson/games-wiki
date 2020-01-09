package br.com.hbsis.hbgameswiki;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JogosTest {

    /*
     * Teste do parâmetro int QrCode do construtor da classe Jogos;
     */

    @Test
    public void testQrCode(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(QRCODE,jogos.getQRCODE());
    }

    /*
     * Teste do parâmetro string Titulo do construtor da classe Jogos;
     */

    @Test
    public void testTitulo(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(Titulo,jogos.getTitulo());
    }

    /*
     * Teste do parâmetro string Categoria do construtor da classe Jogos;
     */

    @Test
    public void testCategoria(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(Categoria,jogos.getCategoria());
    }

    /*
     * Teste do parâmetro string Descrição do construtor da classe Jogos;
     */

    @Test
    public void testDescricao(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(Descricao,jogos.getDescricao());
    }

    /*
     * Teste do parâmetro string Genero do construtor da classe Jogos;
     */

    @Test
    public void testGenero(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(Genero,jogos.getGenero());
    }

    /*
     * Teste do parâmetro string Desenvolvedora do construtor da classe Jogos;
     */

    @Test
    public void testDesenvolvedora(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(Desenvolvedora,jogos.getDesenvolvedora());
    }

    /*
     * Teste do parâmetro int imagemPequenaTP do construtor da classe Jogos;
     */

    @Test
    public void testImagemPequenaTP(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(ImagemPequenaTP,jogos.getImagemPequenaTP());
    }

    /*
     * Teste do parâmetro int ImagemGrandeTP do construtor da classe Jogos;
     */

    @Test
    public void testImagemGrandeTP(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(ImagemGrandeTP,jogos.getImagemGrandeTP());
    }

    /*
     * Teste do parâmetro int JogoFavorito do construtor da classe Jogos;
     */

    @Test
    public void testJogoFavorito(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(JogoFavorito,jogos.getJogoFavorito());
    }

    /*
     * Teste do parâmetro int Avaliacao do construtor da classe Jogos;
     */

    @Test
    public void testAvaliacao(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(Avaliacao,jogos.getAvaliacao());
    }

    /*
     * Teste do parâmetro int MinValor do construtor da classe Jogos;
     */

    @Test
    public void testMinValor(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(MinValor,jogos.getMinValor());
    }

    /*
     * Teste do parâmetro int MaxValor do construtor da classe Jogos;
     */

    @Test
    public void testMaxValor(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(MaxValor,jogos.getMaxValor());
    }

    /*
     * Teste do parâmetro int ImagemPequena1TDJ do construtor da classe Jogos;
     */

    @Test
    public void testImagemPequena1TDJ(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(ImagemPequena1TDJ,jogos.getImagemPequena1TDJ());
    }

    /*
     * Teste do parâmetro int ImagemPequena2TDJ do construtor da classe Jogos;
     */

    @Test
    public void testImagemPequena2TDJ(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(ImagemPequena2TDJ,jogos.getImagemPequena2TDJ());
    }

    /*
     * Teste do parâmetro int ImagemPequena3TDJ do construtor da classe Jogos;
     */

    @Test
    public void testImagemPequena3TDJ(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(ImagemPequena3TDJ,jogos.getImagemPequena3TDJ());
    }

    /*
     * Teste do parâmetro int ImagemPequena4TDJ do construtor da classe Jogos;
     */

    @Test
    public void testImagemPequena4TDJ(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(ImagemPequena4TDJ,jogos.getImagemPequena4TDJ());
    }

    /*
     * Teste do parâmetro int ImagemPequena5TDJ do construtor da classe Jogos;
     */

    @Test
    public void testImagemPequena5TDJ(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(ImagemPequena5TDJ,jogos.getImagemPequena5TDJ());
    }

    /*
     * Teste do parâmetro int ImagemGrandeTDJ do construtor da classe Jogos;
     */

    @Test
    public void testImagemGrandeTDJ(){
        int QRCODE = 1;
        String Titulo = "GTA";
        String Categoria = "Ação";
        String Descricao = "descricao";
        int ImagemPequenaTP =11;
        int ImagemGrandeTP = 111;
        int JogoFavorito = 1111;
        String Genero = "genero";
        String Desenvolvedora = "desenvolvedora";
        int Avaliacao = 5;
        int MinValor = 100;
        int MaxValor = 150;
        int ImagemPequena1TDJ = 12;
        int ImagemPequena2TDJ = 123;
        int ImagemPequena3TDJ = 1234;
        int ImagemPequena4TDJ = 12345;
        int ImagemPequena5TDJ = 123456;
        int ImagemGrandeTDJ = 1234567;

        Jogos jogos = new Jogos(QRCODE, Titulo, Categoria, Descricao, Genero, Desenvolvedora, ImagemPequenaTP,
                ImagemGrandeTP, Avaliacao, MinValor, MaxValor, JogoFavorito, ImagemPequena1TDJ, ImagemPequena2TDJ,
                ImagemPequena3TDJ, ImagemPequena4TDJ, ImagemPequena5TDJ,ImagemGrandeTDJ);

        Assert.assertEquals(ImagemGrandeTDJ,jogos.getImagemGrandeTDJ());
    }


}