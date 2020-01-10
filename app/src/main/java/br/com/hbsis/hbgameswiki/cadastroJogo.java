package br.com.hbsis.hbgameswiki;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class cadastroJogo extends AppCompatActivity {
    EditText etNomeJogo, etDescricaoJogo;
    Button btnCadastrarJogo;
    ImageButton imgSelect;
    ImageView imgIcon;
    AlertDialog.Builder dialog;

    CheckBox checkBoxRPG, checkBoxAcao, checkBoxAventura, checkBoxEstrategia, checkBoxHorror, checkBoxFPS, checkBoxTPS, checkBox2D, checkBox3D, checkBoxVirtual, checkBoxPlataforma, checkBoxMMORPG;

    List<Generos> generos;
    List<CheckBox> checkBoxes = new ArrayList<>();
    private final int GALERIA_IMAGENS=1;
    private final int PERMISSAO_REQUEST =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_jogo);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();

        //imgSelect
        imgSelect = findViewById(R.id.imgSelect);
        imgIcon = findViewById(R.id.imgIcon);

        etNomeJogo = findViewById(R.id.etNomeJogo);
        etDescricaoJogo = findViewById(R.id.etDescricaoJogo);
        btnCadastrarJogo = findViewById(R.id.btnCadastrarJogo);

        //cbGenero = findViewById(R.id.cbGenero);
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

        //Solicitando permissao para camera
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        GALERIA_IMAGENS);
            }
        }


        btnCadastrarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verificarJogo()) {
                    cadastrarJogo();
                }
            }
        });

        imgSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cria alerta
                dialog = new AlertDialog.Builder(cadastroJogo.this);
                //configurar o titulo
                dialog.setTitle("Inserir imagem");
                //configura mensagem
                dialog.setMessage("Você deseja tirar uma foto nova ou buscar uma da sua galeria?");
                //configura se fecha o dialog quando clicado no fundo (false = nao fecha)
                dialog.setCancelable(true);
                //confira icone do lado do titulo
                dialog.setIcon(android.R.drawable.ic_media_ff);
                //botao negativo
                dialog.setNegativeButton("Bater foto",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                                    Log.d("DEBUG","onclick antes");
                                    ActivityCompat.requestPermissions(cadastroJogo.this, new String[]{Manifest.permission.READ_CONTACTS},
                                            PERMISSAO_REQUEST
                                    );
                                    Log.d("DEBUG","onclick dps");
                                }else{
                                    boolean temCamera = getPackageManager()
                                            .hasSystemFeature(PackageManager.FEATURE_CAMERA);
                                    if (temCamera) {
                                        //tirarFoto();
                                    }
                                }
                                Toast.makeText(cadastroJogo.this, "Bateu foto", Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.setPositiveButton("Galeria",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_PICK,
                                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                startActivityForResult(intent, 1);
                                Toast.makeText(cadastroJogo.this, "Selecione uma imagem da sua galeria.", Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.create();
                dialog.show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == GALERIA_IMAGENS) {
            Uri selectedImage = data.getData();
            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            imgIcon.setImageBitmap(thumbnail);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
// A permissão foi concedida. Pode continuar
            } else {
// A permissão foi negada. Precisa ver o que deve ser desabilitado
            }
            return;
        }
    }
    public static Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
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

    public List listarGenero() {
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
            Generos geneross = new Generos(generoStr += checkBox2D.getText());
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

        //Criando GenerosAdapter para exibir na lista de jogos da mainPrincipal
        GenerosAdapter generosAdapter = new GenerosAdapter(listarGenero(), this);

        String gameTag = "";
        for(int x=0;x < generos.size();x++) {
            gameTag += "  -" + generos.get(x).getGenero();
        }

        Game game = new Game(getGameName(), getGameDesc(), gameTag);

        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> {
            db.gameDao().insertAll(game);
            Game JogoCadastrado = db.gameDao().inserirGame(getGameName());
            System.out.println("Jogo inserido: ID = " + JogoCadastrado.getGId());
        });
        Toast.makeText(this, "Jogo criado com sucesso!!!", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }
/*
    private void tirarFoto() {
        File diretorio = Environment
                .getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES);
        nomeImagem = diretorio.getPath() + "/" +
                System.currentTimeMillis() +
                ".jpg";
        //uri = Uri.fromFile(new File(nomeImagem));
        uri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getApplicationContext().getPackageName() + ".provider", new File(nomeImagem));

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, CAPTURAR_IMAGEM);
    }
    */
}