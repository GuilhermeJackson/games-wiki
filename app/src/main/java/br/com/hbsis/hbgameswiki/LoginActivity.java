package br.com.hbsis.hbgameswiki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edUsuario, edSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


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

    public void login() {
        String usuario = edUsuario.getText().toString();
        String senha =  edSenha.getText().toString();

        if (usuario.equals("") || senha.equals("")){
            Toast.makeText(this,"O campo Usuário ou Senha está vazio", Toast.LENGTH_LONG).show();
        } else if (usuario.equals("hbsis") & senha.equals("123")) {
            Toast.makeText(this, "Seja bem-vindo " + usuario, Toast.LENGTH_LONG).show();
            mostrarMain();
        } else {
            Toast.makeText(this, "Usuário ou Senha incorreta. Tente novamente!!!", Toast.LENGTH_LONG).show();
        }
    }

    public void mostrarMain() {
            Intent intent = new Intent(
                    LoginActivity.this, MainActivity.class
            );
            startActivity(intent);
            finish();
        }

        public void mostrarRegistro(View view) {
            Intent intent = new Intent(
                    LoginActivity.this, RegistroActivity.class
            );
            startActivity(intent);

        }
    }
