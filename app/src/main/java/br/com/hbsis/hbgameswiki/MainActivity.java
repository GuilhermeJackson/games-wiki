package br.com.hbsis.hbgameswiki;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Removendo ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        Game jogo = new Game();
        jogo.setGameName("The Witcher 3");
        jogo.setGameDeveloper("CD Projekt RED");
        jogo.setGameDescription("Jogue como um bruxo na idade medieval neste terceiro jogo da franquia.");
        jogo.setGameTags("RPG 3D Magia");
        jogo.setGamePrice(80);
        jogo.setGameRating(5);
        jogo.setGameRequirements("PC daorinha");
        jogo.setFavorite(true);

        db.gameDao().insertAll(jogo);

        Button btSair = findViewById(R.id.btSair);

        List<Game> jogos = db.gameDao().getAll();

        Game jogo1 = jogos.get(0);

        btSair.setText(String.valueOf(jogo1));






    }
}
