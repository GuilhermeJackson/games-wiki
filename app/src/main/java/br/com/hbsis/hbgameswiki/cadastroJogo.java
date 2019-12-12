package br.com.hbsis.hbgameswiki;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class cadastroJogo extends AppCompatActivity {
    EditText etNomeJogo, etDescricaoJogo;
    Button btnCadastrarJogo;
    //CheckBox cbGenero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_jogo);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();

        etNomeJogo = findViewById(R.id.etNomeJogo);
        etDescricaoJogo = findViewById(R.id.etDescricaoJogo);
        btnCadastrarJogo = findViewById(R.id.btnCadastrarJogo);
        //cbGenero = findViewById(R.id.cbGenero);

        btnCadastrarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarJogo();
            }
        });
    }

    public void cadastrarJogo() {
        Jogos jogos = new Jogos();
        jogos.getTitulo();
        jogos.getDescricao();
    }
}
