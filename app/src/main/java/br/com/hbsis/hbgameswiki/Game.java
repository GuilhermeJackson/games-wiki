package br.com.hbsis.hbgameswiki;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Entity
public class Game {
    @PrimaryKey(autoGenerate = true)
    private int gId;

    @ColumnInfo(name = "game_name")
    private String gameName;

    @ColumnInfo(name = "game_developer")
    private String gameDeveloper;

    @ColumnInfo(name = "game_description")
    private String gameDescription;

    @ColumnInfo(name = "game_tags")
    private String gameTags;

    @ColumnInfo(name = "game_requirements")
    private String gameRequirements;

    @ColumnInfo(name = "game_price")
    private double gamePrice;

    @ColumnInfo(name = "game_rating")
    private double gameRating;

    @ColumnInfo(name = "game_is_favorite")
    private boolean isFavorite;

    @ColumnInfo(name = "game_thumbnail")
    private String gameThumbnail;

    /**
     * Retorna o Id do jogo
     *
     * @return int
     * @since 1.0.0
     */
    public int getGId() {
        return gId;
    }

    /**
     * Define o Id do jogo
     *
     * Este método não deve ser usado fora da classe, e é declarado aqui apenas pois o Room requer
     * um método get e set em cada parâmetro para funcionar.
     *
     * @param gId Id do jogo
     * @since 1.0.0
     */
    public void setGId(int gId) {
        this.gId = gId;
    }

    public String getGameName() {
        return gameName;
    }

    /**
     * Define o nome do jogo
     *
     * @param gameName Nome do jogo
     * @since 1.0.0
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDeveloper() {
        return gameDeveloper;
    }

    /**
     * Define o nome da desenvolvedora do jogo
     *
     * @param gameDeveloper Nome da desenvolvedora do jogo
     * @since 1.0.0
     */
    public void setGameDeveloper(String gameDeveloper) {
        this.gameDeveloper = gameDeveloper;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    /**
     * Define a descrição do jogo
     *
     * @param gameDescription Descrição do jogo
     * @since 1.0.0
     */
    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public String getGameTags() {
        return gameTags;
    }

    /**
     * Define as tags do jogo
     *
     * @param gameTags Tags do jogo
     * @since 1.0.0
     */
    public void setGameTags(String gameTags) {
        this.gameTags = gameTags;
    }

    public String getGameRequirements() {
        return gameRequirements;
    }

    /**
     * Define os requerimentos do jogo
     *
     * @param gameRequirements Requerimentos do jogo
     * @since 1.0.0
     */
    public void setGameRequirements(String gameRequirements) {
        this.gameRequirements = gameRequirements;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    /**
     * Define o preço do jogo
     *
     * @param gamePrice Preço do jogo
     * @since 1.0.0
     */
    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    public double getGameRating() {
        return gameRating;
    }

    /**
     * Define a nota dada ao jogo
     *
     * @param gameRating Nota do jogo
     * @since 1.0.0
     */
    public void setGameRating(double gameRating) {
        this.gameRating = gameRating;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    /**
     * Define o jogo como favorito
     *
     * @param favorite Indica se o jogo foi favoritado
     * @since 1.0.0
     */
    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getGameThumbnail(){
        return gameThumbnail;
    }

    /**
     * Define o nome do arquivo da thumbnail do jogo
     *
     * @param gameThumbnail Nome do arquivo da thumbnail do jogo
     * @since 1.0.0
     */
    public void setGameThumbnail(String gameThumbnail){
        this.gameThumbnail = gameThumbnail;
    }

    /**
     * Define a thumbnail do jogo ao passar uma imagem e o contexto da aplicação
     *
     *  Ao passar a imagem e o contexto, a imagem é salva no armazenamento interno, na pasta 'gameThumbnails',
     *  sendo que o nome do arquivo é definido através do nome do jogo acrescido do id, para evitar conflitos.
     *  Após salvar a imagem, o nome do arquivo é salvo no parâmetro gameThumbnail através do método
     *  setGameThumbnail(String gameThumbnail).
     *
     *
     *
     * @param bitmapImage Thumbnail do jogo
     * @param context Contexto da aplicação
     * @since 1.0.0
     */
    public void setGameThumbnail(Bitmap bitmapImage, Context context){
        ContextWrapper cw = new ContextWrapper(context.getApplicationContext());
        // path to /data/data/yourapp/app_data/gameThumbnails

        File directory = cw.getDir("gameThumbnails", Context.MODE_PRIVATE);
        // Create gameThumbnails
        String fileName = gameName.replaceAll("[^a-zA-Z0-9]", "") + "_" + getGId() + ".jpg";
        // Create new file in 'gameThumbnails' with the name 'fileName'
        File mypath = new File(directory,fileName);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            setGameThumbnail(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método toString() para que o objeto possa ser escrito no formato de texto.
     *
     * @return String
     * @since 1.0.0
     */
    @Override
    public String toString() {
        return "Game" + getGId() + ": " + getGameName() +
                ", desenvolvido por " + getGameDeveloper() +
                "\n Descrição:" + getGameDescription() +
                "\n Tags:" + getGameTags() +
                "\n Requerimentos:" + getGameRequirements() +
                "\n Preço médio: " + getGamePrice() +
                " / Score:" + getGameRating() +
                "\n isFavorite: " + isFavorite() +
                "\n\n";
    }
}
