package br.com.hbsis.hbgameswiki;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class cadastroJogo extends AppCompatActivity {
    EditText etNomeJogo, etDescricaoJogo;
    Button btnCadastrarJogo;

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
    public String getNome() {
        String nome = String.valueOf(etNomeJogo.getText());
        return nome;
    }

    public String getDesc() {
        String desc = String.valueOf(etDescricaoJogo.getText());
        return desc;
    }

    public void cadastrarJogo() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "game").build();
        String nome = etNomeJogo.getText().toString();
        String descricao = etDescricaoJogo.getText().toString();

        Game game = new Game(nome, descricao);



    }
}
