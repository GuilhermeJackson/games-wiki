package br.com.hbsis.hbgameswiki;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    static final int GOOGLE_SIGN = 123;
    private FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;

    Button btnLogin;
    EditText edUsuario, edSenha;
    boolean isClicked;
    SignInButton signInButton;
    TextView statusTextView;
    GoogleApiClient mGoogleApiClient;


    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        signInButton = findViewById(R.id.imageGoogle);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });

        statusTextView = findViewById(R.id.textView2);

        btnLogin = findViewById(R.id.btnLogin);
        edUsuario = findViewById(R.id.edUsuario);
        edSenha = findViewById(R.id.edSenha);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    /**
     * Verifica se os campos de login e senha estão preenchidos corretamente, ao verificar se estão
     * vazios e também pesquisando o login no banco de dados. Caso a busca pelo login retorne
     * um usuário, a função validarLogin() é chamada.
     * version 1.0  |   guilherme.lamim@hbsis.com.br
     */
    private void login() {
        String usuarioInserido = edUsuario.getText().toString();
        String senhaInserida = edSenha.getText().toString();

        if (usuarioInserido.equals("")) {
            Toast.makeText(this, "O campo Usuário está vazio", Toast.LENGTH_SHORT).show();
        } else if (senhaInserida.equals("")) {
            Toast.makeText(this, "O campo Senha está vazio", Toast.LENGTH_SHORT).show();
        } else {
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "user").build();


            Executor myExecutor = Executors.newSingleThreadExecutor();
            myExecutor.execute(() -> {
                User usuarioLogando = db.userDao().selectByName(usuarioInserido);
                LoginActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        validarLogin(usuarioLogando != null, usuarioLogando, senhaInserida);
                    }
                });
            });
        }
    }



    /**
     * Recebe o boolean isLoginValid para verificar se o usuário está cadastrado no banco de dados;
     * o usuário cadastrado é passado pelo parâmetro u; e a senha inserida no campo de texto é passada
     * pelo parâmetro senhaInserida. Caso o login e a senha estejam condizentes, o login ocorre com sucesso
     * e a MainActivity é iniciada.
     * @param isLoginValid
     * @param u
     * @param senhaInserida
     */
    private void validarLogin(boolean isLoginValid, User u, String senhaInserida) {
        if (isLoginValid) {
            if (senhaInserida.equals(u.getSenha())) {
                Toast.makeText(this, "Seja bem-vindo " + u.getLogin() + "!", Toast.LENGTH_LONG).show();
                mostrarMain();
            } else {
                Toast.makeText(this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Usuário não cadastrado!", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarMain() {
        Intent intent = new Intent(
                this, PrincipalActivity.class
        );
        startActivity(intent);
        finish();
    }

    public void mostrarRegistro(View view) {

        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(
                    LoginActivity.this, RegistroActivity.class
            );
            startActivity(intent);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        isClicked = false;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {

            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                updateUI(user);

                mostrarMain();
                finish();

                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();

            Log.e("USUARIO",name+" "+email);
            System.out.println();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailde" + connectionResult);
    }

}