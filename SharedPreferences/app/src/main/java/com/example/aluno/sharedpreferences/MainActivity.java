package com.example.aluno.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.op1) {
            Toast.makeText(this,"Você escolheu SALVAR",
                    Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor;
            SharedPreferences sp;
            sp = getSharedPreferences("teste", 0);
            editor = sp.edit();
            editor.putString("nome",((EditText)findViewById(R.id.edt1)).getText().toString());
            editor.putString("telefone",((EditText)findViewById(R.id.edt2)).getText().toString());
            editor.putString("email",((EditText)findViewById(R.id.edt3)).getText().toString());
            editor.putString("cpf",((EditText)findViewById(R.id.edt4)).getText().toString());
            editor.putString("endereco",((EditText)findViewById(R.id.edt5)).getText().toString());

            editor.commit();

            ((EditText) findViewById(R.id.edt1)).setText("");
            ((EditText) findViewById(R.id.edt2)).setText("");
            ((EditText) findViewById(R.id.edt3)).setText("");
            ((EditText) findViewById(R.id.edt4)).setText("");
            ((EditText) findViewById(R.id.edt5)).setText("");

            return true;
        }else if (id == R.id.op2) {
            Toast.makeText(this,"Você escolheu LER",
                    Toast.LENGTH_SHORT).show();
            SharedPreferences sp;
            sp = getSharedPreferences("teste", 0);
            ((TextView) findViewById(R.id.edt1)).setText(sp.getString("nome",null));
            ((TextView) findViewById(R.id.edt2)).setText(sp.getString("telefone",null));
            ((TextView) findViewById(R.id.edt3)).setText(sp.getString("email",null));
            ((TextView) findViewById(R.id.edt4)).setText(sp.getString("cpf",null));
            ((TextView) findViewById(R.id.edt5)).setText(sp.getString("endereco",null));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }

