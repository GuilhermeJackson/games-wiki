package br.com.hbsis.hbgameswiki;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.util.Log;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PrincipalActivity extends AppCompatActivity {
    public static final int LOGIN_REQUEST_CODE = 111;

    /**
     * Classe tela principal aonde será exibida todas as informações dos jogos
     * <p>
     * Classe aonde serão definidos as listas, ViewsPagers e Adapters.
     * para listar um jogo na lista de jogos utilize os método abaixo:
     * Adicionar um jogo na lista jogos <code>listaJogos.add(new Jogos(String titulo, String categoria, String descricao, String genero, String desenvolvedora, int img_pequena_TP, int img_grande_TP, int avaliacao, int minValor, int maxValor, int jogoFavorito, int img_pequena_1_TDJ, int img_pequena_2_TDJ, int img_pequena_3_TDJ, int img_pequena_4_TDJ, int img_pequena_5_TDJ, int img_grande_TDJ));</code>
     * <p>
     * Para listar um jogo na lista destaque utilize os método abaixo:
     * Adicionar um jogo na lista destaque <code>destaqueJogos.add(new DestaqueJogos(int imagem, String titulo, String descricao));</code>
     * <p>
     * Para listar um genero novo na lista utilize o método abaixo:
     * Adicionar um genêro na lista generos <code>generos.add(new Generos(String genero));</code>
     *
     * @Author Sandro Diego Adão
     */

    ArrayList<Game> listaJogos = new ArrayList<Game>();
    List<DestaqueJogos> destaqueJogos;
    List<Generos> generos;
    ViewPager vp_destaque_jogos;
    ViewPager vp_generos;
    DestaqueJogosAdapter destaqueJogosAdapter;
    GenerosAdapter generosAdapter;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    ImageView imagemIcon, img_adicionar;

    RecyclerView mrcv_lista_jogos;
    ListaJogos myAdapter;
    ImageView imagemIcon;
    EditText edt_barra_pesquisa;

    RelativeLayout embacar;
    LinearLayout mainmenu, maincontent;
    Button btnMenu;
    Animation fromtop, frombottom;
    ImageView avatar;
    TextView nomeUser, emailUser, tituloSobre, version;
    Button btEdit, btFavoritos, btConfig, btSobre, btSair;
    Toolbar toolbar;

    /**
     *   Variável constante para verificação do SignIn
     */
    static final int GOOGLE_SIGN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("user_preferences",MODE_PRIVATE);
        String usuario = preferences.getString("usuario","");

        if(usuario.equals("")) {
            SignInEmail();
        }else{
            tudo();
        }

    }


    public void telaSobre(View view) {
        Intent intent = new Intent(PrincipalActivity.this, SobreActivity.class);
        startActivity(intent);
    }

    private void fecharMenu() {
        mainmenu.animate().translationX(-800);
        embacar.setX(1600);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GOOGLE_SIGN) {

            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                tudo();
                updateUI(user);



                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }

    /**
     *
     *  Método que contém toda a parte visual da activity principal
     *
     *
     *
     */
    private void tudo(){
        setContentView(R.layout.activity_mains);
        //getSupportActionBar().hide();

        // Edit Text
        edt_barra_pesquisa = findViewById(R.id.edt_barra_pesquisa);

        //Button
        btEdit = findViewById(R.id.btEdit);
        btFavoritos = findViewById(R.id.btFavoritos);
        btConfig = findViewById(R.id.btConfig);
        btSobre = findViewById(R.id.btSobre);
        btSair = findViewById(R.id.btSair);

        //TextView
        nomeUser = findViewById(R.id.nomeUser);
        emailUser = findViewById(R.id.email);
        tituloSobre = findViewById(R.id.tituloSobre);
        version = findViewById(R.id.version);

        //SharedPreferences
        SharedPreferences preferences = getSharedPreferences("user_preferences",MODE_PRIVATE);
        nomeUser.setText(preferences.getString("nome","User Name"));
        emailUser.setText(preferences.getString("usuario",""));

        //ImageView
        avatar = findViewById(R.id.avatar);
        img_adicionar = findViewById(R.id.img_adicionar);

        //Animações
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        //Botão menuAsset pra testes
        btnMenu = findViewById(R.id.btnmenu);

        maincontent = findViewById(R.id.linearLayout22);
        mainmenu = findViewById(R.id.mainmenu);
        embacar = findViewById(R.id.embacar);
      
        //Entrando na tela de cadastro
        img_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaDeCadastro = new Intent(PrincipalActivity.this, cadastroJogo.class);
                startActivityForResult(telaDeCadastro, LOGIN_REQUEST_CODE);
            }
        });

        // Cria uma ArrayList do tipo Generos
        generos = new ArrayList<>();
        generos.add(new Generos("RPG"));
        generos.add(new Generos("Ação"));
        generos.add(new Generos("Aventura"));
        generos.add(new Generos("Estratégia"));
        generos.add(new Generos("Horror"));
        generos.add(new Generos("FPS"));
        generos.add(new Generos("TPS"));
        generos.add(new Generos("2D"));
        generos.add(new Generos("3D"));
        generos.add(new Generos("Virtual"));
        generos.add(new Generos("Plataforma"));
        generos.add(new Generos("MMORPG"));

        generosAdapter = new GenerosAdapter(generos, this);
        vp_generos = findViewById(R.id.vp_generos);
        vp_generos.setAdapter(generosAdapter);

        destaqueJogos = new ArrayList<>();
        destaqueJogos.add(new DestaqueJogos(R.mipmap.modern_warfare_logo_foreground, "Call of Duty - Modern Warfare", "Call of Duty: Modern Warfare é um jogo eletrônico de tiro em primeira pessoa prod..."));
        destaqueJogos.add(new DestaqueJogos(R.mipmap.farcry5_logo_foreground, "Far Cry 5", "Far Cry 5 é um jogo eletrônico de tiro em primeira pessoa de ação-aventura ambien..."));
        destaqueJogos.add(new DestaqueJogos(R.mipmap.battlefield5_logo_foreground, "Battlefield V", "Battlefield V é um jogo eletrônico de tiro em primeira pessoa, desenvolvido pela Crite..."));
        destaqueJogos.add(new DestaqueJogos(R.mipmap.reddead_logo_foreground, "Red Dead Redemption II", "Red Dead Redemption 2 é um jogo eletrônico de ação-aventura desenvolvido e publicado pela..."));


        destaqueJogosAdapter = new DestaqueJogosAdapter(destaqueJogos, this);

        vp_destaque_jogos = findViewById(R.id.vp_destaque_jogos);
        vp_destaque_jogos.setAdapter(destaqueJogosAdapter);
        vp_destaque_jogos.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                /*
                * Define as cores do background em values -> colors.xml
                * */
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        vp_destaque_jogos.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (destaqueJogosAdapter.getCount() - 1) && position < (colors.length - 1)) {
                    vp_destaque_jogos.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                } else {
                    vp_destaque_jogos.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        //listaJogos.add(new Jogos("Fallout IV - Standart Edition", "Jogos", "", "• RPG", "Bethesda Game Studios", R.mipmap.fallout4_logo, R.mipmap.fallout4_logo, 2, 50, 150, R.mipmap.nao_favorito_icon_foreground, R.mipmap.fallout4_logo, R.mipmap.fallout4_1_wallpaper, R.mipmap.fallout4_2_wallpaper, R.mipmap.fallout4_3_wallpaper, R.mipmap.fallout4_4_wallpaper, R.mipmap.fallout4_logo));
        //listaJogos.add(new Game("GTA", "Jogo de matar as pessoas atropeladas e metralhadas.", generos.toString()));

        listaJogos = new ArrayList<>();
        /*
         * new Jogos() - criar um novo card
         * */
        listaJogos.add(new Jogos(R.drawable.fllout_4, "Fallout IV - Standart Edition", "Jogos", "", "• RPG", "Bethesda Game Studios", R.mipmap.fallout4_logo, R.mipmap.fallout4_logo, 2, 50, 150, R.mipmap.nao_favorito_icon_foreground, R.mipmap.fallout4_logo, R.mipmap.fallout4_1_wallpaper, R.mipmap.fallout4_2_wallpaper, R.mipmap.fallout4_3_wallpaper, R.mipmap.fallout4_4_wallpaper, R.mipmap.fallout4_logo));
        listaJogos.add(new Jogos(R.drawable.supermario, "Super Mario World", "Jogos", "", "• Plataforma  • Ação", "Nintendo Co., Ltd.", R.mipmap.supermario_logo, R.mipmap.supermario_logo, 5, 10, 20, R.mipmap.favorito_icon_foreground, R.mipmap.supermario_logo, R.mipmap.spm_1_wallpaper, R.mipmap.spm_2_wallpaper, R.mipmap.spm_3_wallpaper, R.mipmap.spm_4_wallpaper, R.mipmap.supermario_logo));
        listaJogos.add(new Jogos(R.drawable.gta, "Grand Theft Auto V", "Jogos", "", "• Ação  • Aventura", "Rockstar North.", R.mipmap.gta5_logo, R.mipmap.gta5_logo, 5, 80, 120, R.mipmap.favorito_icon_foreground, R.mipmap.gta5_logo, R.mipmap.gta5_1_wallpaper, R.mipmap.gta5_2_wallpaper, R.mipmap.gta5_3_wallpaper, R.mipmap.gta5_4_wallpaper, R.mipmap.gta5_logo));
        listaJogos.add(new Jogos(R.drawable.lastofus, "The last of us", "Jogos", "", "• Ação  • Aventura  • Sobrevivência", "Konami", R.mipmap.tlou_logo, R.mipmap.tlou_logo, 3, 120, 140, R.mipmap.nao_favorito_icon_foreground, R.mipmap.tlou_logo, R.mipmap.tlou_1_wallpaper, R.mipmap.tlou_2_wallpaper, R.mipmap.tlou_3_wallpaper, R.mipmap.tlou_4_wallpaper, R.mipmap.tlou_logo));
        listaJogos.add(new Jogos(R.drawable.farcry, "Far Cry 5", "Jogos", "", "• FPS  • Ação", "Ubisoft", R.mipmap.farcry5_logo, R.mipmap.farcry5_logo, 5, 150, 300, R.mipmap.favorito_icon_foreground, R.mipmap.farcry5_logo, R.mipmap.farcry5_1_wallpaper, R.mipmap.farcry5_2_wallpaper, R.mipmap.farcry5_3_wallpaper, R.mipmap.farcry5_4_wallpaper, R.mipmap.farcry5_logo));

        mrcv_lista_jogos = findViewById(R.id.rcv_principal);
        myAdapter = new ListaJogos(this, listaJogos);

        mrcv_lista_jogos.setLayoutManager(new GridLayoutManager(this, 1));
        mrcv_lista_jogos.setAdapter(myAdapter);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "game").build();

        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> {
            listaJogos.addAll(db.gameDao().getAll());
            myAdapter.notifyDataSetChanged();
        });

        edt_barra_pesquisa.addTextChangedListener(new TextWatcher() {
            final Handler handler = new Handler();
            Runnable runnable;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                handler.removeCallbacks(runnable);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //show some progress, because you can access UI here
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        myAdapter.getFilter().filter(edt_barra_pesquisa.getText());
                    }
                };
                handler.postDelayed(runnable, 500);
            }
        });


        /*
         * spanCount Define a quantidade de cards que irá aparecer na horizontal
         * */
        mrcv_lista_jogos.setLayoutManager(new GridLayoutManager(this, 1));
        mrcv_lista_jogos.setAdapter(myAdapter);

        imagemIcon = findViewById(R.id.img_filtro);
        imagemIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirMenu();
            }
        });

        //Ao clicar fora da barra ela some
        embacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fecharMenu();
            }
        });

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSair();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "game").build();

        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> {

            listaJogos.add(db.gameDao().pegaUltimoJogo());

            PrincipalActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    myAdapter.notifyDataSetChanged();
                }
            });


        });
        // Do something with the contact here (bigger example below)

    }

    private void abrirMenu() {
        maincontent.animate().translationX(0);
        mainmenu.animate().translationX(0);
        embacar.setX(0);
        embacar.bringToFront();
        mainmenu.bringToFront();
    }

    /**
     *  Método que contém o login com o email e senha via Firebase
     *
     *  Neste método, temos a lista dos providers para que possamos
     *  realizar o login e/ou registro. Inicia uma activity esperando
     *  um resultado para poder realizar a autenticação do firebase
     *
     * @author Matheus Geiser <matheusgeiser@gmail.com>
     *
     */
    private void SignInEmail(){
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build());

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setIsSmartLockEnabled(false)
                        .build(),
                GOOGLE_SIGN);
    }


    private void fecharMenu() {
        //maincontent.animate().translationX(-800);
        mainmenu.animate().translationX(-800);
        embacar.setX(1600);

    /**
     *  Método que contém a ação do botão de logout
     *
     *  Com o sharedPreferences é setado a key do usuario como vazia
     *  para que na verificação do onCreate aconteça o pedido para fazer
     *  o login, pois o usuário não está logado.
     *
     * @author Matheus Geiser <matheusgeiser@gmail.com>
     *
     */
    private void btnSair(){

        SharedPreferences preferences = getSharedPreferences("user_preferences",MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("usuario","");
        edit.apply();

        fecharMenu();
        SignInEmail();
    }

    /**
     *
     *  Método que salva as informações do usuário logado
     *
     * O parametro user contem todas as informações do usuario que
     * foi logado. A partir disso as informações são salvas no
     * SharedPreferences do usuario.
     *
     * @author Matheus Geiser <matheusgeiser@gmail.com>
     *
     * @param user
     */
    public void updateUI(FirebaseUser user) {
        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();

            SharedPreferences preferences = getSharedPreferences("user_preferences",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("usuario",email);
            editor.putString("nome",name);
            editor.apply();

            //Adicionando o nome e o email à sideBar
            nomeUser.setText(name);
            emailUser.setText(email);

        }
    }
}

