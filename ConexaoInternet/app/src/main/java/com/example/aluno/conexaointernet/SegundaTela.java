package com.example.aluno.conexaointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        Intent i = getIntent();
        String nome = i.getStringExtra("resultado");
        ((TextView)findViewById(R.id.resposta)).setText(nome);
    }

    protected void retornar() {
        Intent i = new Intent(SegundaTela.this, MainActivity.class);
        startActivity(i);

    }

}
