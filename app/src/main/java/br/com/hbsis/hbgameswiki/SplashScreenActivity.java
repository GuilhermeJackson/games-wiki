package br.com.hbsis.hbgameswiki;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Classe responsavel por criar a splashscreen e iniciar a próxima tela
 *
 * Projeta a tela de splashscreen e guarda um valor boolean para dizer
 * se é o primeiro acesso do usuário
 *
 * Classe também responsavel  pelas animações da splashscreen
 */
public class SplashScreenActivity extends AppCompatActivity {
    Animation fromtop, frombottom, fromleft, fromright, alphanimation;
    ImageView hbgames, wiki, logomeio;
    User user;
    int id = 0;
    String email;

    /**
     * Chama o método que inicia a splashscreen e seu layout
     *
     * @param savedInstanceState
     *
     * @since 1.0.0
     *
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen1);
        delaySplash();

    }

    /**
     * Metodo que inicia a mainActivity
     *
     * startActivity(intent) inicia uma nova intent que no caso seria a MAainActivity
     * finish() finaliza a intent atual que no caso seria a Splash
     *
     * @since 1.0.0
     *
     * @return void
     */
    private void mostrarMainActivity() {
        Intent intent = new Intent(
                SplashScreenActivity.this, MainActivity.class
        );
        startActivity(intent);
        finish();
    }

    /**
     * Metodo que inicia a mainActivity
     *
     * startActivity(intent) inicia uma nova intent que no caso seria a LoginActivity
     * finish() finaliza a intent atual que no caso seria a Splash
     *
     * @since 1.0.0
     *
     * @return void
     */
    private void mostrarLogin() {
        Intent intent = new Intent(
                SplashScreenActivity.this, PrincipalActivity.class
        );
        startActivity(intent);
        finish();
    }

    /**
     * Metodo que inicia a splashscreen e detemina pelo sharedPreferences se o usuario já esta logado
     *
     * "user_preferences"  nome da shared preferences que queremos buscar.
     *
     * "MODE PRIVATE" modo de acesso (Por defautl utilizamos o MODE_PRIVATE
     * pois ele restringe o acesso apenas para a App que está chamando ou para todas as Apps que tiverem o mesmo user ID)
     *
     *A partir do objeto preferences podemos verificar se existe uma chave com o método contains().
     *Verificando se existe a chave "open".
     *
     * Caso exista a chave ele irá mostrar a Activity definida (No caso do código está a tela de login nos dois pois ela estava sendo testada)
     *
     * Caso não exista ele irá chamar o metodo adicionarPreferenceJaAbriu() passando o parametro (preferences)
     * que basicamente irá adicionar a chave ao paramento preference
     *
     * @param delay é o tempo que a splash irá aparecer na tela, ao chamar o metodo é preciso passar um valor int como pro exemplo '2000' que seria 2s
     *
     * @since 1.0.0
     *
     * @return void
     */
    private void mostrarSplash(int delay) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
                SharedPreferences sp = getSharedPreferences("prefLogin", MODE_PRIVATE);
                String usuario = sp.getString("usuario","");
                String senha = sp.getString("senha","");
                String user = preferences.getString("usuario","");

                if (preferences.contains("open") && !user.equals("")) {
                    mostrarLogin();
                } else {
                    adicionarPreferenceJaAbriu(preferences);
                    mostrarLogin();
                }
            }
        }, delay);

        animationSplash();

    }

    /**
     *
     *
     *
     *
     */
    private void mostrarPrincipal(String usuario, String senha){



        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "user").build();


        Executor myExecutor = Executors.newSingleThreadExecutor();

        myExecutor.execute(() -> {
            user = db.userDao().selectByName(usuario);
            SplashScreenActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    id = user.getUId();
                    email = user.getEmail();
                }
            });
        });

        Intent intent = new Intent(SplashScreenActivity.this, PrincipalActivity.class);
        intent.putExtra("usuario", usuario);
        intent.putExtra("id", id);
        intent.putExtra("email", email);



        startActivity(intent);
        finish();

    }

    /**
     * Metodo que guarda a informação de que o aplicativo ja foi aberto outras vezes
     *
     * A partir do preferences chamamos o método edit() que nos devolve um objeto do tipo SharedPreferences.Editor():
     *
     * Então, a partir do edit() podemos adicionar um valor,utilizando o método putBoolean() enviando o nome da chave e o valor
     *
     * commit() para salvar a operação
     *
     * @param preferences
     *
     * @since 1.0.0
     *
     * @return void
     */
    private void adicionarPreferenceJaAbriu(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("open", true);
        editor.commit();
    }

    /**
     * O metodo instancia as imagens e as animações pelo id do xml e inicia as animações
     * A função findViewById pega o id da ImageView
     * A função loadAnimaton é algo equivalente para animações
     * O startAnimation pega a ImageView e inicia a animação para ela
     *
     * @since 1.0.0
     *
     * @return void
     */
    private void animationSplash() {

        //Instanciando imagens pelo id
        logomeio = findViewById(R.id.logomeio);
        hbgames = findViewById(R.id.hbgames);
        wiki = findViewById(R.id.wiki);

        //Instanciando animações pelo id
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fromleft = AnimationUtils.loadAnimation(this, R.anim.fromleft);
        fromright = AnimationUtils.loadAnimation(this, R.anim.fromright);
        alphanimation = AnimationUtils.loadAnimation(this, R.anim.alphanimation);

        //Start das animações
        hbgames.startAnimation(fromright);
        logomeio.startAnimation(alphanimation);
        wiki.startAnimation(fromleft);

    }

    /**
     * Metodo que mostra a splash na tela setando delay
     *
     * se a chave open existe no preferences  o delay é 1,5s
     * se não, ele chama o metodo adicionarPreferenceJaAbriu() para salvar a chave open e o delay é maior 2s
     *
     * @since 1.0.0
     *
     * @return void
     */
    private void delaySplash() {

        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        if (preferences.contains("open")) {
            mostrarSplash(1500);
        } else {
            adicionarPreferenceJaAbriu(preferences);
            mostrarSplash(2000);
        }
    }
}
