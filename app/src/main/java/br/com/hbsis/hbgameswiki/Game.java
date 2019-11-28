package br.com.hbsis.hbgameswiki;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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


}
