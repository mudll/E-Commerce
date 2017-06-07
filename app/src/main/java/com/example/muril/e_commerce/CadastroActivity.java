package com.example.muril.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.muril.e_commerce.util.ArrayFormEdit;
import com.example.muril.e_commerce.util.LibraryClass;
import com.example.muril.e_commerce.util.Mask;
import com.example.muril.e_commerce.util.MensagemUtil;
import com.example.muril.e_commerce.util.Validate;
import com.firebase.client.Firebase;

import java.util.ArrayList;

/**
 * Created by muril on 05/04/2017.
 */

public class CadastroActivity extends AppCompatActivity {

    private Button voltar;
    private Button confirmar;
    private Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        EditText maskcpf = (EditText) findViewById(R.id.campo_cpf);
        maskcpf.addTextChangedListener(Mask.insert("###.###.###-##", maskcpf));

        EditText maskdata = (EditText) findViewById(R.id.campo_data_nascimento);
        maskdata.addTextChangedListener(Mask.insert("##/##/####", maskdata));

        EditText masktelefone = (EditText) findViewById(R.id.campo_telefone);
        masktelefone.addTextChangedListener(Mask.insert("(##)#####-####", masktelefone));

        voltar = (Button) findViewById(R.id.btn_voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                finish();
            }
        });

        firebase = LibraryClass.getFirebase();


    }

    public void confirmar(View view) {

        boolean cadastroOk = true;

        ArrayList<ArrayFormEdit> camposdoformulario = new ArrayList<>();

        camposdoformulario.add(new ArrayFormEdit((EditText) findViewById(R.id.campo_nome), "Nome"));
        camposdoformulario.add(new ArrayFormEdit((EditText) findViewById(R.id.campo_data_nascimento), "Data de Nascimento"));
        camposdoformulario.add(new ArrayFormEdit((EditText) findViewById(R.id.campo_cpf), "CPF"));
        camposdoformulario.add(new ArrayFormEdit((EditText) findViewById(R.id.campo_email), "Email"));
        camposdoformulario.add(new ArrayFormEdit((EditText) findViewById(R.id.campo_telefone), "Telefone"));
        camposdoformulario.add(new ArrayFormEdit((EditText) findViewById(R.id.new_usuario), "Usuário"));
        camposdoformulario.add(new ArrayFormEdit((EditText) findViewById(R.id.new_senha), "Senha"));
        camposdoformulario.add(new ArrayFormEdit((EditText) findViewById(R.id.new_repitasenha), "Confirmar Senha"));

        if (cadastroOk) cadastroOk = Validate.validateNotNull(camposdoformulario);
        if (cadastroOk) cadastroOk = Validate.validateSenha(camposdoformulario);
        if (cadastroOk)
            cadastroOk = Validate.validateEmail((EditText) findViewById(R.id.campo_email));
        if (cadastroOk) cadastroOk = Validate.validateCPF((EditText) findViewById(R.id.campo_cpf));


        if (cadastroOk) {
            MensagemUtil.addMsg(CadastroActivity.this, "Cadastro Realizado Com Sucesso");
            Intent i = new Intent(CadastroActivity.this, LoginActivity.class);

            String nome = (camposdoformulario.get(0).editTxt).getText().toString();
            String dataNasc = (camposdoformulario.get(1).editTxt).getText().toString();
            String cpf = (camposdoformulario.get(2).editTxt).getText().toString();
            String email = (camposdoformulario.get(3).editTxt).getText().toString();
            String telefone = (camposdoformulario.get(4).editTxt).getText().toString();
            String nick = (camposdoformulario.get(5).editTxt).getText().toString();
            String senha = (camposdoformulario.get(6).editTxt).getText().toString();

            Usuario user = new Usuario(nome, dataNasc, cpf, email, telefone, nick, senha);

            String id = firebase.push().getKey();

            firebase.child("Usuario").child(id).setValue(user);
            startActivity(i);
        }


        final EditText nomeError = (EditText) findViewById(R.id.campo_nome);
        final EditText usuarioError = (EditText) findViewById(R.id.new_usuario);

        usuarioError.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                usuarioError.setError(null);
            }
        });

        nomeError.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                nomeError.setError(null);
            }
        });
    }
}
