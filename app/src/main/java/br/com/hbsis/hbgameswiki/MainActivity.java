package br.com.hbsis.hbgameswiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    RelativeLayout maincontent, embacar;
    LinearLayout mainmenu;
    Button btnMenu;
    Animation fromtop, frombottom;
    ImageView avatar;
    TextView nomeUser, email, tituloSobre, version;
    Button btEdit, btFavoritos, btConfig, btSobre, btSair;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        instanciarViews();
        chamarBarra();
        swipeMenu();
    }

    private void instanciarViews() {
        //Button
        btEdit = findViewById(R.id.btEdit);
        btFavoritos = findViewById(R.id.btFavoritos);
        btConfig = findViewById(R.id.btConfig);
        btSobre = findViewById(R.id.btSobre);
        btSair = findViewById(R.id.btSair);

        //TextView
        nomeUser = findViewById(R.id.nomeUser);
        email = findViewById(R.id.email);
        tituloSobre = findViewById(R.id.tituloSobre);
        version = findViewById(R.id.version);

        //ImageView
        avatar = findViewById(R.id.avatar);

        //Animações
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        //Botão menuAsset pra testes
        btnMenu = findViewById(R.id.btnmenu);

        maincontent = findViewById(R.id.maincontent);
        mainmenu = findViewById(R.id.mainmenu);
        embacar = findViewById(R.id.embacar);

    }

    public void chamarBarra() {

        //Evento de click para abrir a barra
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenu();
            }
        });

        //Ao clicar fora da barra ela some

        maincontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void abrirMenu() {
        //maincontent.animate().translationX(0);
        mainmenu.animate().translationX(0);
        embacar.setX(0);
        embacar.bringToFront();
        mainmenu.bringToFront();

        //Iniciando as animações

        // de baixo
        btEdit.startAnimation(frombottom);
        btFavoritos.startAnimation(frombottom);
        btConfig.startAnimation(frombottom);
        btSobre.startAnimation(frombottom);
        btSair.startAnimation(frombottom);
        tituloSobre.startAnimation(frombottom);
        version.startAnimation(frombottom);

        //de cima
        avatar.startAnimation(fromtop);
        nomeUser.startAnimation(fromtop);
        email.startAnimation(fromtop);
    }

    private void fecharMenu() {
        //maincontent.animate().translationX(-800);
        mainmenu.animate().translationX(-800);
        embacar.setX(1600);
    }

    public void telaSobre(View view) {
        Intent intent = new Intent(
                MainActivity.this, SobreActivity.class
        );
        startActivity(intent);

    }


    private void swipeMenu() {

        maincontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

            }
        });
        maincontent.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            public void onSwipeTop() {

                return;
            }

            public void onSwipeRight() {
                abrirMenu();
                return;

            }

            public void onSwipeLeft() {
                fecharMenu();
                return;
            }

            public void onSwipeBottom() {
                return;
            }
        });
    }

}