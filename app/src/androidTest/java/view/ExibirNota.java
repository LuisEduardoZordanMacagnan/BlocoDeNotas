package view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.ifsc.blocodenotas.R;
import controller.NotaController;
import model.Nota;

public class ExibirNota extends AppCompatActivity {

    NotaController notaController;
    EditText edTitulo, edTexto;
    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);
        notaController = new NotaController(getApplicationContext());

        edTitulo = findViewById(R.id.editTextTitulo);
        edTexto = findViewById(R.id.editTextTexto);
        salvar = findViewById(R.id.btnSalvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarNota(v);
            }
        });
    }

    public void salvarNota(View v){
        String titulo = edTitulo.getText().toString(), texto = edTexto.getText().toString();

        if(!titulo.isEmpty()){
            return;
        }
        if(!texto.isEmpty()){
            return;
        }

        Nota n = new Nota();
        n.setTitulo(titulo);
        n.setTexto(texto);

        notaController.criarNota(n);
    }
}