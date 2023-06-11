package br.com.ifsc.blocodenotas.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDAO {

    SQLiteDatabase sqLiteDatabase;

    public NotaDAO(Context c){
        this.sqLiteDatabase = c.openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);
    }
    public boolean insert(Nota n){
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("titulo", n.getTitulo());
            contentValues.put("texto", n.getTexto());
            Long i = (Long) sqLiteDatabase.insert("notas", null, contentValues);
            n.setId(i);
            sqLiteDatabase.close();
            return true;
        } catch (RuntimeException e){
            return false;
        }
    }

    public boolean update(Nota n){
        try{
            ContentValues contentValues = new ContentValues();
            contentValues.put("titulo", n.getTitulo());
            contentValues.put("texto", n.getTexto());

            sqLiteDatabase.update("notas", contentValues, "WHERE id = "+n.getId(), null);
            sqLiteDatabase.close();
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public ArrayList<Nota> getAll(){
        ArrayList<Nota> notas = new ArrayList<Nota>();
        Cursor cursor = sqLiteDatabase.query("notas", new String[]{"id", "titulo", "texto"}, null, null, null, null, null);
        while(cursor.moveToNext()){
            Nota n = new Nota(cursor.getString(2), cursor.getString(3));
            n.setId(cursor.getLong(1));
            notas.add(n);
        }
        return notas;
    }

    public Nota getNota(Long id){
        for (Nota nota : getAll()) {
            if(id == nota.getId()){
                return nota;
            }
        }
        return null;
    }

    public boolean delete(Long id){
        try {
            sqLiteDatabase.delete("banco", "WHERE id = "+id, null);
            sqLiteDatabase.close();
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
