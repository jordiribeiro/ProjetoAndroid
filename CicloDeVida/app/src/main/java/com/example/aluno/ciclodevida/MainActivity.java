package com.example.aluno.ciclodevida;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
    }

    public void navegar(View v){
        Intent i = new Intent(this,SegundaActivity.class);
        i.putExtra("nome",((EditText)findViewById(R.id.nome)).getText().toString());
        startActivity(i);
    }

}
