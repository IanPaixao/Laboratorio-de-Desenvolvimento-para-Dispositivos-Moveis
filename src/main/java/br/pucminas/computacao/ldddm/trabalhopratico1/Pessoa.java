package br.pucminas.computacao.ldddm.trabalhopratico1;

import java.net.URL;
import java.util.Calendar;

/**
 * Created by Ian Rodrigues on 2018.
 */

public class Pessoa {

    private String nome;
    private Calendar dataNasc;
    private String telefone;
    private String email;


    public String getNome() {
        return nome;
    }// fim get nome

    public void setNome(String nome) {
        this.nome = nome;
    }// fim set nome

    public Calendar getDataNasc() {
        return dataNasc;
    }//fim get data

    public void setDataNasc(Calendar dataNasc) {
        this.dataNasc = dataNasc;

    }// fim set data

    public String getTelefone() {
        return telefone;
    }//fim get telefone

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }// fim set telefone

    public String getEmail() {
        return email;
    }//fim get email

    public void setEmail(String email) {
        this.email = email;
    }//fim set email

}