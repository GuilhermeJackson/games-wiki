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

    public int getGId() {
        return gId;
    }

    public void setGId(int gId) {
        this.gId = gId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDeveloper() {
        return gameDeveloper;
    }

    public void setGameDeveloper(String gameDeveloper) {
        this.gameDeveloper = gameDeveloper;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public String getGameTags() {
        return gameTags;
    }

    public void setGameTags(String gameTags) {
        this.gameTags = gameTags;
    }

    public String getGameRequirements() {
        return gameRequirements;
    }

    public void setGameRequirements(String gameRequirements) {
        this.gameRequirements = gameRequirements;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    public double getGameRating() {
        return gameRating;
    }

    public void setGameRating(double gameRating) {
        this.gameRating = gameRating;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getGameThumbnail(){
        return gameThumbnail;
    }

    public void setGameThumbnail(String gameThumbnail){
        this.gameThumbnail = gameThumbnail;
    }

    public void setGameThumbnail(Bitmap bitmapImage, Context context){
        ContextWrapper cw = new ContextWrapper(context.getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir

        File directory = cw.getDir("gameThumbnails", Context.MODE_PRIVATE);
        // Create imageDir
        String fileName = gameName.replaceAll("[^a-zA-Z0-9]", "") + "_" + getGId() + ".jpg";
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
