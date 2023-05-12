package vision;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.ifsc.blocodenotas.R;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    ListView listaPessoas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPessoas = findViewById(R.id.listView);

        db = openOrCreateDatabase("notas", MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");
        db.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Luís', 18)");
    }

    public void listaPessoas(){
        Cursor cursor = db.rawQuery("SELECT * FROM pessoas",null);
        cursor.moveToFirst();
        ArrayList<String> arrayList = new ArrayList<String>();
        while(cursor.isAfterLast()){
            arrayList.add(cursor.getString(0));
            cursor.moveToNext();
        }
    }
}