package br.pucminas.computacao.tp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class FragmentMenu extends AppCompatActivity {
    Button add;

    @Override
    protected void onCreate(Bundle savedBundleState){
        super.onCreate(savedBundleState);
        setContentView(R.layout.fragment);
        Intent intent = getIntent();
        add = (Button)findViewById(R.id.add_City);

    }// End onCreate()

    public void onResume(){
        super.onResume();
    }// End onResume()

    public void startAtividadeActivity(String[] estados){
        startActivity(new Intent(this,Atividade.class).putExtra("States",estados));
    }// End start AtividadeActivity()

    public void startAdicionarActivity(){
        startActivity(new Intent(this,Adicionar.class));
    }// End start AdicionarActivity()


}// End Fragment
