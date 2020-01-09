package br.com.hbsis.hbgameswiki;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;

public class cadastroJogo extends AppCompatActivity {

    private final int TIRAR_FOTO = 123123;
    private final int REQUEST_CAMERA_PERMISSION = 2332;
    private final int REQUEST_GALERY_PERMISSION =4444;
    private final int GALERIA_IMAGENS = 22222;
    private final int CAPTURAR_IMAGEM = 222;

    private Activity thisActivity = this;
    private Uri uri;
    private String nomeImagem;
    private ImageButton imgIcon;
    private ImageButton imgGalery;


    private EditText etNomeJogo, etDescricaoJogo;
    private Button btnCadastrarJogo;


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

         imgIcon = findViewById(R.id.imgIcon);
         imgGalery = findViewById(R.id.imgSelect);

         imgGalery.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                 startActivityForResult(intent, GALERIA_IMAGENS);
             }
         });


        imgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    Log.d("DEBUG","onclick antes");
                    ActivityCompat.requestPermissions(thisActivity, new String[]{Manifest.permission.READ_CONTACTS},
                            REQUEST_CAMERA_PERMISSION
                    );
                    Log.d("DEBUG","onclick dps");
                }else{
                    boolean temCamera = getPackageManager()
                            .hasSystemFeature(PackageManager.FEATURE_CAMERA);
                    if (temCamera) {
                        tirarFoto();
                    }
                }
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALERIA_IMAGENS) {
            if (resultCode == RESULT_OK) {
                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));

                thumbnail = rotationBitMap(thumbnail);
                imgIcon.setImageBitmap(thumbnail);

                redimencionamentoImagem(picturePath);
            }
        }

        if (requestCode == CAPTURAR_IMAGEM) {
            if (resultCode == RESULT_OK) {

                Bitmap thumbnail = (BitmapFactory.decodeFile(nomeImagem));
                thumbnail = rotationBitMap(thumbnail);
                imgIcon.setImageBitmap(thumbnail);

                redimencionamentoImagem(nomeImagem);

                mostrarMensagem("Imagem capturada!");
                adicionarNaGaleria();
            } else {
                mostrarMensagem("Imagem não capturada!");
            }
        }

    }

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

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {


        if (requestCode == REQUEST_CAMERA_PERMISSION){
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                tirarFoto();
            }else{
                Log.d("DEBUG","PERMISSÃO NEGADA");
            }
        }
    }

    private void adicionarNaGaleria() {
        Intent intent = new Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }

    private void mostrarMensagem(String msg) {
        Toast.makeText(this, msg,
                Toast.LENGTH_LONG)
                .show();
    }

    public static Bitmap rotationBitMap(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setRotate(90);
        Bitmap bmRotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return bmRotated;
    }

    private void redimencionamentoImagem(String nomeImagem){

        int targetW = imgIcon.getWidth();
        int targetH = imgIcon.getHeight();
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();

        BitmapFactory.decodeFile(new File(nomeImagem).getAbsolutePath(), bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;
        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;

        Bitmap bitmap =
                BitmapFactory.decodeFile(new File(nomeImagem).getAbsolutePath(), bmOptions);
        bitmap = rotationBitMap(bitmap);
        imgIcon.setImageBitmap(bitmap);


    }
}
