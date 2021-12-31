package lailah.com.addition;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private TextView username;

    //sessions
    private String USERDATA="USERDATA";
    SharedPreferences sharedPreferences;

    private SQLiteDatabase SQLITEDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        username=(TextView)findViewById(R.id.username);
        SQLITEDB=openOrCreateDatabase("people.db", Context.MODE_PRIVATE, null);
        sharedPreferences=getSharedPreferences(USERDATA, Context.MODE_PRIVATE);

        int id = sharedPreferences.getInt("userid",0);

        Cursor cursor = SQLITEDB.rawQuery("SELECT name FROM users WHERE id=?", new String[]{String.valueOf(id)});
        cursor.moveToFirst();

        String name=cursor.getString(cursor.getColumnIndex("name")); //name passed is a field from database table

        username.setText(name);

    }

    //logout button
    public void logOut(View view){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
