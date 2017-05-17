package com.example.muril.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.muril.e_commerce.util.ArrayFormEdit;
import com.example.muril.e_commerce.util.MensagemUtil;
import com.example.muril.e_commerce.util.Validate;

import java.util.ArrayList;

/**
 * Created by muril on 05/04/2017.
 */


public class LoginActivity extends AppCompatActivity {

    private Button cadastrar;
    private Button entrar;

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
    }

    public void entrar(View view) {

        boolean loginOk = true;

        ArrayList<ArrayFormEdit> camposdoformulario = new ArrayList<>();

        camposdoformulario.add(new ArrayFormEdit((EditText) findViewById(R.id.edit_senha), "Senha"));
        camposdoformulario.add(new ArrayFormEdit((EditText) findViewById(R.id.edit_usuario), "Login"));

        if (loginOk) loginOk = Validate.validateNotNull(camposdoformulario);
        if (loginOk) loginOk = Validate.validateLogin(camposdoformulario);
        if (loginOk) {
            MensagemUtil.addMsg(LoginActivity.this, "Login Realizado Com Sucesso");
            Intent i = new Intent(LoginActivity.this, LojaMain.class);
            startActivity(i);
        }

    }
}

