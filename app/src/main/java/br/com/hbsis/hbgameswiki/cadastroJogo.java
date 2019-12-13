package br.com.hbsis.hbgameswiki;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class cadastroJogo extends AppCompatActivity {
    EditText etNomeJogo, etDescricaoJogo;
    Button btnCadastrarJogo;
    CheckBox checkBoxRPG, checkBoxAcao, checkBoxAventura, checkBoxEstrategia, checkBoxHorror, checkBoxFPS, checkBoxTPS, checkBox2D, checkBox3D, checkBoxVirtual, checkBoxPlataforma, checkBoxMMORPG;
    List<Generos> generosss;
    TextView textView8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_jogo);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();

        textView8 = findViewById(R.id.textView8);

        //EditText
        etNomeJogo = findViewById(R.id.etNomeJogo);
        etDescricaoJogo = findViewById(R.id.etDescricaoJogo);

        //Button
        btnCadastrarJogo = findViewById(R.id.btnCadastrarJogo);

        //CheckBox
        checkBoxRPG = findViewById(R.id.checkBoxRPG);
        checkBoxAcao = findViewById(R.id.checkBoxAcao);
        checkBoxAventura = findViewById(R.id.checkBoxAventura);
        checkBoxEstrategia = findViewById(R.id.checkBoxEstrategia);
        checkBoxHorror = findViewById(R.id.checkBoxHorror);
        checkBoxFPS= findViewById(R.id.checkBoxFPS);
        checkBoxTPS = findViewById(R.id.checkBoxTPS);
        checkBox2D = findViewById(R.id.checkBox2D);
        checkBox3D = findViewById(R.id.checkBox3D);
        checkBoxVirtual = findViewById(R.id.checkBoxVirtual);
        checkBoxPlataforma = findViewById(R.id.checkBoxPlataforma);
        checkBoxMMORPG = findViewById(R.id.checkBoxMMORP);


        btnCadastrarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarJogo();
            }
        });
    }

    public void cadastrarJogo() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "game").build();

        //Se o checkBox tiver selecionado, adiciona
        for (int x = 0; x < generosss.size(); x++) {
            if (checkBoxRPG.isChecked()) {
                Generos generoObj = new Generos();
                generoObj.setGenero(" " + checkBoxRPG.getText().toString());
                generosss.add(generoObj);
            }
            if (checkBoxAcao.isChecked()) {
                Generos generoObj = new Generos();
                generoObj.setGenero(" " + checkBoxAcao.getText().toString());
                generosss.add(generoObj);
            }
            if (checkBoxAventura.isChecked()) {
                Generos generoObj = new Generos();
                generoObj.setGenero(" " + checkBoxAventura.getText().toString());
                generosss.add(generoObj);
            }
            if (checkBoxEstrategia.isChecked()) {
                String nome = "";
                Generos generoObj = new Generos(" " + checkBoxEstrategia.getText().toString());
                generosss.add(generoObj);
            }
            if (checkBoxHorror.isChecked()) {
                Generos generoObj = new Generos();
                generoObj.setGenero(checkBoxHorror.getText().toString());
                generosss.add(generoObj);
            }
            if (checkBoxFPS.isChecked()) {
                Generos generoObj = new Generos();
                generoObj.setGenero(" " + checkBoxFPS.getText().toString());
                generosss.add(generoObj);
            }
            if (checkBoxTPS.isChecked()) {
                Generos generoObj = new Generos();
                generoObj.setGenero(checkBoxTPS.getText().toString());
                generosss.add(generoObj);
            }
            if (checkBox2D.isChecked()) {
                Generos generoObj = new Generos();
                generoObj.setGenero(" " + checkBox2D.getText().toString());
                generosss.add(generoObj);
            }
            if (checkBox3D.isChecked()) {
                Generos generoObj = new Generos();
                generoObj.setGenero(" " + checkBox3D.getText().toString());
                generosss.add(generoObj);
            }
            if (checkBoxVirtual.isChecked()) {
                Generos generoObj = new Generos();
                generoObj.setGenero(" " + checkBoxVirtual.getText().toString());
                generosss.add(generoObj);
            }
            if (checkBoxPlataforma.isChecked()) {
                Generos generoObj = new Generos();
                generoObj.setGenero(" " + checkBoxPlataforma.getText().toString());
                generosss.add(generoObj);
            }
            if (checkBoxMMORPG.isChecked()) {
                Generos generoObj = new Generos();
                generoObj.setGenero(" " + checkBoxMMORPG.getText().toString());
                generosss.add(generoObj);
            }
        }
        String gameName = etNomeJogo.getText().toString();
        String gameDescription = etDescricaoJogo.getText().toString();
        String gameTag = " ";

        textView8.setText(gameTag);

        //String gameTags =
        //Game game= new Game();
    }
}
