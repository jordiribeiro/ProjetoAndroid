package com.example.aluno.aula0708;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnKeyListener {
       EditText numero;
        TextView mensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero = (EditText) findViewById(R.id.numero);
        numero.setOnKeyListener(this);

    }

    @Override
    public boolean onKey(View v,int keyCode,KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() != KeyEvent.ACTION_DOWN){
            EditText mensagem;
           verificaPalpite();
           return true;
        }
        return false;
    }

    public void verificaPalpite(){
        mensagem= (TextView) findViewById(R.id.resposta);
        String valor= numero.getText().toString();
        int valorfinal=Integer.parseInt(valor);
        int i = (int)( 1 + (Math.random() * 100));

        if(valorfinal==i){
            mensagem.setText("Acertou!");
        }else if (valorfinal>i){
            mensagem.setText("O valor é menor!");
        }else{
            mensagem.setText("O valor é maior!");
        }

    }
}
