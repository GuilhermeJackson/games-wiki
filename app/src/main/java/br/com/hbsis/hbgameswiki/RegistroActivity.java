package br.com.hbsis.hbgameswiki;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {
    static final int PICK_CONTACT_REQUEST = 1;  // The request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                termos();
            }
        });

        Button button = findViewById(R.id.button);
        button.setEnabled(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textSenha = findViewById(R.id.textSenha);
                EditText textConfirma = findViewById(R.id.textConfirma);
                CheckBox checkBox = findViewById(R.id.checkBox);

                Button btn = findViewById(R.id.button);

                if(!verificaCadastro()){
                    checkBox.setChecked(false);
                    textSenha.setText("");
                    textConfirma.setText("");
                    termos();

                }else{
                    registroSucesso();
                }
            }
        });


    }

    public String getNome(){
        EditText textNome = findViewById(R.id.textNome);
        String nome = String.valueOf(textNome.getText());
        return nome;
    }

    public String getSenha(){
        EditText textSenha = findViewById(R.id.textSenha);
        String senha = String.valueOf(textSenha.getText());
        return senha;
    }

    public String getConfirma(){
        EditText textConfirma = findViewById(R.id.textConfirma);
        String confirma = String.valueOf(textConfirma.getText());
        return confirma;
    }

    public String getEmail(){
        EditText textEmail = findViewById(R.id.textEmail);
        String email = String.valueOf(textEmail.getText());
        return email;
    }



    /*private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }*/

    /**
     * verifica se a checkbox está cheked e deixa o botão habilitado/desabilitado
     *
     * caso a checkbox esteja checada o botão fica habilitado, e caso ela esteja
     * desabilitada o botão fica desabilitado
     *
     * @return void
     */
    public void termos(){
        CheckBox checkBox = findViewById(R.id.checkBox);
        Button button = findViewById(R.id.button);
        if(checkBox.isChecked()){
            button.setEnabled(true);
        }else{
            button.setEnabled(false);
        }
    }

    /**
     * verifica se os parâmetros passados estão conforme as restrições
     *
     * Com base nos métodos isValid ele nos retorna um boolean para verificarmos se os parâmetors estão conforme
     * as restrições
     *
     * @return boolean
     */
   public boolean verificaCadastro(){
        EditText textNome = findViewById(R.id.textNome);
        EditText textEmail = findViewById(R.id.textEmail);
        EditText textSenha = findViewById(R.id.textSenha);
        EditText textConfirma = findViewById(R.id.textConfirma);

        String txtNome = (textNome.getText()).toString();
        String txtEmail = (textEmail.getText()).toString();
        String txtSenha = (textSenha.getText()).toString();
        String txtConfirma = (textConfirma.getText()).toString();

        if(isValidNome(txtNome) && isValidEmail(txtEmail) && isValidSenha(txtSenha) && isValidConfirma(txtConfirma, txtSenha)){
            return true;
        }
        Toast.makeText(this,"Preencha os campos corretamente", Toast.LENGTH_SHORT).show();
        return false;
    }

    /**
     * Define as restrições do email e as verifica
     *
     * Utiliza uma String de email como parâmetro e verifica se está no formato correto
     *
     * @param email
     * @return boolean
     */
    public boolean isValidEmail(String email) {
        boolean isEmailIdValid = false;
        if (email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    /**
     * Define as restrições do nome e as verifica
     *
     * Utiliza uma String de nome como parâmetro e verifica se está no formato correto
     *
     * @param nome
     * @return
     */
    public boolean isValidNome(String nome){
        boolean isNomeIdValid = false;
        if (nome.length() >= 3){
                isNomeIdValid = true;
        }
        return isNomeIdValid;
    }

    /**
     * Define as restrições da senha e as verifica
     *
     * Utiliza uma String de senha como parâmetro e verifica se está no formato correto
     *
     * @param senha
     * @return
     */
    public boolean isValidSenha(String senha){
        boolean isSenhaIdValid = false;
        // criar 1 objeto de cada classe da verificação, ex no isValidEmail
        // 1 expression, 1 pattern, 1 matcher para cada restrição

        if (senha.length() >= 5){
            String expression1 = "^.*[0-9].*$";//0 a 9
            String expression2 = "^.*[^A-Za-z0-9].*$";//todos menos  os caracters numericos e letras
            String expression3 = "^.*[A-Z].*$";//

            Pattern pattern1 = Pattern.compile(expression1, Pattern.CASE_INSENSITIVE);
            Pattern pattern2 = Pattern.compile(expression2, Pattern.CASE_INSENSITIVE);
            Pattern pattern3 = Pattern.compile(expression3);

            Matcher matcher1 = pattern1.matcher(senha);
            Matcher matcher2 = pattern2.matcher(senha);
            Matcher matcher3 = pattern3.matcher(senha);


           if(matcher1.matches() && matcher2.matches() && matcher3.matches()){
                isSenhaIdValid = true;
            }
        }

        return isSenhaIdValid;
    }

    /**
     * Define as restrições da senha confirmada e os verifica
     *
     * Utiliza uma String de confirma como parâmetro e verifica se está no formato correto
     *
     * @param confirma
     * @param senha
     * @return
     */
    public boolean isValidConfirma(String confirma, String senha){
        boolean isConfirmaIdValid = false;
        if ((confirma.length() == senha.length()) && (confirma.contentEquals(senha))){
            isConfirmaIdValid = true;
        }
        return isConfirmaIdValid;
    }


    /**
     * Cria um objeto user
     *
     * cria m objeto user da classe User que vai guardar as informações do
     * usuário
     *
     */
    public void registerUser(){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "user").build();

        User user = new User(getNome(),getSenha(),getEmail());

        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> {
            db.userDao().insertAll(user);
            User usuarioInserido = db.userDao().selectByName(getNome());
            System.out.println("Usuario inserido: ID = " + usuarioInserido.getUId());
        });
    }

    public void registroSucesso() {
        registerUser();
        Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG ).show();
        finish();
    }
}
