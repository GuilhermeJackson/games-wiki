package br.com.hbsis.hbgameswiki;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Jogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        //Removendo ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
