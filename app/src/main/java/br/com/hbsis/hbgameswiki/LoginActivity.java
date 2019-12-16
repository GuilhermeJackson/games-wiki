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
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    Button btnLogin;
    EditText edUsuario, edSenha;
    boolean isClicked;
    SignInButton signInButton;
    TextView statusTextView;
    GoogleApiClient mGoogleApiClient;
    GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;// ...


    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);

        signInButton = findViewById(R.id.imageGoogle);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
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

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            updateUI(null);
                        }

                        // ...
                    }
                });
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


    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }

    /**
     *
     *
     * pausa
     * @param completedTask
     */
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask){
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            Log.e("Conta: ",account.getDisplayName()+" - "+account.getEmail());

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());

        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailde" + connectionResult);
    }

    public void createSignInIntent() {
        // [START auth_fui_create_intent]
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.TwitterBuilder().build());

        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
        // [END auth_fui_create_intent]
    }


}