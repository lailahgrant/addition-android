package lailah.com.addition;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SqliteDB extends AppCompatActivity {

    //make an object of sqlitedatabase
    SQLiteDatabase SQLITEDATABASE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_db);

        //create a database
        SQLITEDATABASE=openOrCreateDatabase("saipali.db",Context.MODE_PRIVATE,null);

        //create atable
        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS emp(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,empname VARCHAR(25), dept VARCHAR(25), salary float);");

        SQLITEDATABASE.execSQL("insert into emp(empname,dept,salary) values('Fanny','IT',2000)");
        //if db with table is created, make a toast

        Toast.makeText(SqliteDB.this, "Database with Table Created Successfully", Toast.LENGTH_LONG).show();

    }
}
