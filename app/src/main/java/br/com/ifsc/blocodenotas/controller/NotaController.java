package br.com.ifsc.blocodenotas.controller;

import android.content.Context;

import java.util.ArrayList;

import br.com.ifsc.blocodenotas.model.Nota;
import br.com.ifsc.blocodenotas.model.NotaDAO;

public class NotaController {
    Context mContext;
    NotaDAO notaDao;
    public NotaController(Context c){
        mContext = c;
        notaDao = new NotaDAO(c);
    }

    public boolean criarNota(Nota n){
        if(notaDao.insert(n)){
            return true;
        }
        return false;
    }

    public boolean atualizarNota(Nota n){
        if(notaDao.update(n)){
            return true;
        } else {
            return false;
        }
    }

    public Nota getNota(Long id){
        return notaDao.getNota(id);
    }

    public ArrayList<Nota> getListaNotas(){
        return notaDao.getAll();
    }

    public boolean deleteNota(Long id){
        if(notaDao.delete(id)){
            return true;
        } else {
            return false;
        }
    }
}
