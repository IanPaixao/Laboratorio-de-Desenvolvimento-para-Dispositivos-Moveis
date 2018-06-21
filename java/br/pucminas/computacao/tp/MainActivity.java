package br.pucminas.computacao.tp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import br.pucminas.computacao.tp.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }// End onCreate()

    protected void onResume(){
        super.onResume();
        String[] states = getResources().getStringArray(R.array.estados);
        String[] cities = getResources().getStringArray(R.array.cidades);

        if(states.length == 27 && cities.length == 27) {
            startAtividade(states,cities);
        }else Toast.makeText(getApplicationContext(), "ERROR: Missing Cities Or States", Toast.LENGTH_SHORT).show();;
    }// End onResume()

    private void startAtividade(String[] uf,String[] cid){
        startActivity(new Intent(this,Atividade.class).putExtra("City",cid).putExtra("States",uf));
        finish();
    }// End startAtividade()
}//End MainActivity
