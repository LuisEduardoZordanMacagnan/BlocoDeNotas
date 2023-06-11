package br.com.ifsc.blocodenotas.view;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;

import br.com.ifsc.blocodenotas.R;
import br.com.ifsc.blocodenotas.controller.NotaController;
import br.com.ifsc.blocodenotas.model.Nota;

public class ExibirNota extends AppCompatActivity {

    NotaController notaController;
    EditText edTitulo, edTexto;
    Button salvar;
    Long id;
    Nota n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);
        notaController = new NotaController(getApplicationContext());

        edTitulo = findViewById(R.id.editTextTitulo);
        edTexto = findViewById(R.id.editTextTexto);
        salvar = findViewById(R.id.btnSalvar);

        Intent intent = getIntent();
        id = intent.getLongExtra("notaId", 0);

        if(id!=0){
            n = notaController.getNota(id);
            setarValores();
        }
    }

    public void salvarNota(View v){
        String titulo = edTitulo.getText().toString(), texto = edTexto.getText().toString();

        if(!titulo.isEmpty()){
            return;
        }
        if(!texto.isEmpty()){
            return;
        }

        if(id!=0){
            Nota n = new Nota(titulo, texto);
            notaController.criarNota(n);
        } else {
            notaController.atualizarNota(n);
        }
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }

    public void deletarNota(View v){
        notaController.deleteNota(n.getId());
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }

    public void voltar(View v){
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }

    public void setarValores(View v){
        edTitulo.setText(n.getTitulo());
        edTexto.setText(n.getTexto());
    }
}