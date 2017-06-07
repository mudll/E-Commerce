package com.example.muril.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.muril.e_commerce.util.ArrayFormEdit;
import com.example.muril.e_commerce.util.LibraryClass;
import com.example.muril.e_commerce.util.MensagemUtil;
import com.example.muril.e_commerce.util.Validate;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by muril on 05/04/2017.
 */


public class LoginActivity extends AppCompatActivity {

    private Button cadastrar;
    private Button entrar;
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cadastrar = (Button) findViewById(R.id.btn_cadastrar);


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        firebase = new Firebase("https://e-commerce-aa1f2.firebaseio.com/Usuario");

    }

    public void entrar(View view) {

        boolean loginOk = true;

        final String login = ((EditText) findViewById(R.id.edit_usuario)).getText().toString();
        final String senha = ((EditText) findViewById(R.id.edit_senha)).getText().toString();

        ArrayList<ArrayFormEdit> loginForm = new ArrayList<>();
        loginForm.add(new ArrayFormEdit((EditText) findViewById(R.id.edit_usuario), "Usuario"));
        loginForm.add(new ArrayFormEdit((EditText) findViewById(R.id.edit_senha), "Senha"));

        if (loginOk) loginOk = Validate.validateNotNull(loginForm);

        if (loginOk) {
            firebase.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot valor : dataSnapshot.getChildren()) {
                                Usuario user = valor.getValue(Usuario.class);
                                if (user.getNick().equals(login)) {
                                    if (user.getSenha().equals(senha)) {
                                        MensagemUtil.addMsg(LoginActivity.this, "Login Realizado Com Sucesso");
                                        firebase.child("Logado").setValue(user);
                                        Intent i = new Intent(LoginActivity.this, LojaMain.class);
                                        startActivity(i);
                                    } else {
                                        EditText senhaW = (EditText) findViewById(R.id.edit_senha);
                                        senhaW.setFocusable(true);
                                        senhaW.requestFocus();
                                        senhaW.setError("Senha inválida");
                                    }
                                }
                            }
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                        }
                    }
            );
        }


    }
}

