package br.com.hbsis.hbgameswiki;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class cadastroJogo extends AppCompatActivity {
    EditText etNomeJogo, etDescricaoJogo;
    Button btnCadastrarJogo;
    CheckBox checkBoxRPG, checkBoxAcao, checkBoxAventura, checkBoxEstrategia, checkBoxHorror, checkBoxFPS, checkBoxTPS, checkBox2D, checkBox3D, checkBoxVirtual, checkBoxPlataforma, checkBoxMMORPG;
    List<Generos> generos;
    List<CheckBox> checkBoxes = new ArrayList<>();
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
        checkBoxes.add(checkBoxRPG = findViewById(R.id.checkBoxRPG));
        checkBoxes.add(checkBoxAcao = findViewById(R.id.checkBoxAcao));
        checkBoxes.add(checkBoxAventura = findViewById(R.id.checkBoxAventura));
        checkBoxes.add(checkBoxEstrategia = findViewById(R.id.checkBoxEstrategia));
        checkBoxes.add(checkBoxHorror = findViewById(R.id.checkBoxHorror));
        checkBoxes.add(checkBoxFPS = findViewById(R.id.checkBoxFPS));
        checkBoxes.add(checkBoxTPS = findViewById(R.id.checkBoxTPS));
        checkBoxes.add(checkBox2D = findViewById(R.id.checkBox2D));
        checkBoxes.add(checkBox3D = findViewById(R.id.checkBox3D));
        checkBoxes.add(checkBoxVirtual = findViewById(R.id.checkBoxVirtual));
        checkBoxes.add(checkBoxPlataforma = findViewById(R.id.checkBoxPlataforma));
        checkBoxes.add(checkBoxMMORPG = findViewById(R.id.checkBoxMMORP));


        btnCadastrarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verificarJogo()) {
                    cadastrarJogo();
                }
            }
        });
    }
    public boolean verificaNome(){
        boolean verificaNome = false;
        if (getGameName().length() >= 1 && (!getGameName().trim().equals(""))){
            verificaNome = true;
        }else {
            Toast.makeText(this, "O nome do jogo está vazio!!!", Toast.LENGTH_SHORT).show();
        }
        return verificaNome;
    }

    public boolean verificarGenero() {
        boolean selectGenero = false;
        for (CheckBox checkBoxs:checkBoxes) {
            if (checkBoxs.isChecked()){
                selectGenero = true;
            }
        } if (selectGenero == false){
            Toast.makeText(this, "Selecione pelo menos um genero!!!", Toast.LENGTH_SHORT).show();
        }
        return selectGenero ;
    }

    public boolean verificarDescJogo(){
            boolean Gamedec = false;
            if (getGameDesc().length() >= 10){
                Gamedec = true;
            } else {
                Toast.makeText(this, "Descrição deverá conter pelo menos 10 caracteres!!!", Toast.LENGTH_SHORT).show();
            }
            return Gamedec;
    }

    public boolean verificarJogo(){
        boolean permitir = false;
        if (verificaNome() && verificarDescJogo() && verificarGenero()){
            permitir = true;
        } else { permitir = false; }
        return permitir;
    }

    //metodo q retorna o nome do jogo
    public String getGameName(){
        String gameName = etNomeJogo.getText().toString();
        return gameName;
    }
    //metodo q retorna a descrição do jogo
    public String getGameDesc(){
        String gameDesc = etDescricaoJogo.getText().toString();
        return gameDesc;
    }

    public List listarGenero(){
        generos = new ArrayList<>();
        String generoStr = "";
        if (checkBoxRPG.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBoxRPG.getText());
            generos.add(new Generos(geneross.getGenero()));
        }
        if (checkBoxAcao.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBoxAcao.getText());
            generos.add(new Generos(geneross.getGenero()));
        }
        if (checkBoxAventura.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBoxAventura.getText());
            generos.add(new Generos(geneross.getGenero()));
        }
        if (checkBoxEstrategia.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBoxEstrategia.getText());
            generos.add(new Generos(geneross.getGenero()));
        }
        if (checkBoxHorror.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBoxHorror.getText());
            generos.add(new Generos(geneross.getGenero()));
        }
        if (checkBoxFPS.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBoxFPS.getText());
            generos.add(new Generos(geneross.getGenero()));
        }
        if (checkBoxTPS.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBoxTPS.getText());
            generos.add(new Generos(geneross.getGenero()));
        }
        if (checkBox2D.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBox2D.getText());;
            generos.add(new Generos(geneross.getGenero()));
        }
        if (checkBox3D.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBox3D.getText());
            generos.add(new Generos(geneross.getGenero()));
        }
        if (checkBoxVirtual.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBoxVirtual.getText());
            generos.add(new Generos(geneross.getGenero()));
        }
        if (checkBoxPlataforma.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBoxPlataforma.getText());
            generos.add(new Generos(geneross.getGenero()));
        }
        if (checkBoxMMORPG.isChecked()) {
            Generos geneross = new Generos(generoStr += checkBoxMMORPG.getText());
            generos.add(new Generos(geneross.getGenero()));
        }
        return generos;
    }

    public void cadastrarJogo() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "game").build();

        //Se o checkBox tiver selecionado, adiciona


        //Criando GenerosAdapter para exibir na lista de jogos da mainPrincipal
        GenerosAdapter generosAdapter = new GenerosAdapter(listarGenero(),this);


        String gameDescription = etDescricaoJogo.getText().toString();
        String gameTag = generos.toString();

        Game game = new Game(getGameName(), getGameDesc(), gameTag);


        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> {
            db.gameDao().insertAll(game);
            //Game JogoCadastrado = db.gameDao().loadAllByIds(getGameName());
            //System.out.println("Jogo inserido: ID = " + JogoCadastrado.getGId());
        });




        textView8.setText(checkBoxes.toString());

        Toast.makeText(this, "Jogo criado com sucesso!!!", Toast.LENGTH_SHORT).show();
        Intent telaPrincipal = new Intent(cadastroJogo.this, PrincipalActivity.class);
        startActivity(telaPrincipal);
    }
}
