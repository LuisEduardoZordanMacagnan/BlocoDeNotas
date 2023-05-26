package controller;

import android.content.Context;

import java.util.ArrayList;

import model.Nota;
import model.NotaDAO;

public class NotaController {
    Context mContext;
    NotaDAO notaDao;
    public NotaController(Context c){
        mContext=c;
        notaDao = new NotaDAO(c);
    }

    public boolean criarNota(Nota n){
        if(notaDao.insert(n)){
            return true;
        }
        return false;
    }

    public Nota getNota(Long id){
        return null;
    }

    public ArrayList<Nota> getListaNotas(){
        return null;
    }

    public boolean deleteNota(Long id){
        return false;
    }
}
