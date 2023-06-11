package br.com.ifsc.blocodenotas.view;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.ifsc.blocodenotas.R;
import br.com.ifsc.blocodenotas.controller.NotaController;
import br.com.ifsc.blocodenotas.model.Nota;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    ListView listaNotas;
    Intent intent = new Intent(this, ExibirNota.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaNotas = findViewById(R.id.listView);

        db = openOrCreateDatabase("banco", getBaseContext().MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id LONG PRIMARY KEY AUTOINCREMENT, titulo VARCHAR NOT NULL, texto VARCHAR)");

        NotaController notaController = new NotaController(getApplicationContext());
        ArrayAdapter<Nota> adapter = new ArrayAdapter<Nota>(this,
                android.R.layout.simple_list_item_1,
                notaController.getListaNotas());
        listaNotas.setAdapter(adapter);

        listaNotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Nota n = (Nota) parent.getItemAtPosition(position);
                intent.putExtra("notaId", n.getId());
                startActivity(intent);
            }
        });
    }

    public void criarNota(View v){
        intent.putExtra("notaId", 0);
        startActivity(intent);
    }

    public void listarNotas(){
        Cursor cursor = db.rawQuery("SELECT * FROM notas",null);
        cursor.moveToFirst();
        ArrayList<String> arrayList = new ArrayList<String>();
        while(cursor.isAfterLast()){
            arrayList.add(cursor.getString(0));
            cursor.moveToNext();
        }
    }
}