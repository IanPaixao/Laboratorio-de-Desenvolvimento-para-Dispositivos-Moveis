package br.pucminas.computacao.tp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.pucminas.computacao.tp.R;

public class Adicionar extends AppCompatActivity{
    EditText textcity;
    Button button;
    AlertDialog.Builder alertdialog;

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.adicionar);
        textcity = (EditText)findViewById(R.id.add_City);
        button = (Button)findViewById(R.id.add);
        alertdialog = new AlertDialog.Builder(this);
    }// End onCreate()

    public void onResume(){
        super.onResume();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String string = textcity.getText().toString();
                Menu.cities.add(string);
                alertdialog.setTitle("Inserção Banco de Dados");
                alertdialog.setMessage("A cidade foi inserida no banco de dados com sucesso!");
                alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){ startFragmentMenu(); }});

                alertdialog.show();
            }});
    }// End onResume()

    public void startAtividade(String[] estados){
        startActivity(new Intent(this,Atividade.class).putExtra("States",estados));
    }// End startFragmentMenu()

    public void startFragmentMenu(){
        startActivity(new Intent(this,FragmentMenu.class));
    }// End startFragmentMenu()
}// End Adicionar()
