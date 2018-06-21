package br.pucminas.computacao.tp;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class DbController{
    private SQLiteDatabase db;
    private DataBase data_base;

    public DbController(Context context){
        data_base = new DataBase(context);
    }// End DbController()

    public String insert(Tree arvore){
        ContentValues valores;
        long resultado;
        db = data_base.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DataBase.ARVORE,arvore.toString());
        resultado = db.insert(DataBase.TABLE_NAME, null, valores);
        db.close();
        if(resultado == -1) return "Erro ao inserir registro";
        else return "Registro Inserido com sucesso";
    }// End insert()
}// End DbController
