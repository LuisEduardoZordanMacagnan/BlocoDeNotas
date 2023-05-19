package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import controller.NotaController;

public class NotaDAO {

    SQLiteDatabase sqLiteDatabase;

    public NotaDAO(Context c){
        this.sqLiteDatabase = c.openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);
    }
    public boolean insert(Nota n){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", n.getTitulo());
        contentValues.put("texto", n.getTexto());
        sqLiteDatabase.insert("notas", null, contentValues);

        return false;
    }

    public boolean update(Nota n){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", n.getTitulo());
        contentValues.put("texto", n.getTexto());
        sqLiteDatabase.update("notas", contentValues, "id", null);
        return false;
    }

    public boolean search(){
        return false;
    }

    public ArrayList<Nota> getAll(){
        return null;
    }

    public boolean getNota(Long id){
        return false;
    }

    public boolean delete(Long id){
        return false;
    }
}
