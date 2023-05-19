package view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.ifsc.blocodenotas.R;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    ListView listaNotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaNotas = findViewById(R.id.listView);

        db = openOrCreateDatabase("banco", getBaseContext().MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id LONG PRIMARY KEY AUTOINCREMENT, titulo VARCHAR NOT NULL, texto VARCHAR)");
    }

    public void listaPessoas(){
        Cursor cursor = db.rawQuery("SELECT * FROM notas",null);
        cursor.moveToFirst();
        ArrayList<String> arrayList = new ArrayList<String>();
        while(cursor.isAfterLast()){
            arrayList.add(cursor.getString(0));
            cursor.moveToNext();
        }
    }
}