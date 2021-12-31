package lailah.com.addition;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText email,password;
    private TextView message;
    private SQLiteDatabase SQLITEDB;

    //to get the fields, we shall need to get them in sessions
    //we set sessions using Sharedprefferred
    private String USERDATA="USERDATA"; //use this variable to get  values in the SharedPreferrence
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        message=(TextView)findViewById(R.id.message);

        SQLITEDB=openOrCreateDatabase("people.db", Context.MODE_PRIVATE,null);
        //Context.MODE_PRIVATE - database is only accessible by that application

        sharedPreferences=getSharedPreferences(USERDATA,Context.MODE_PRIVATE);

    }

    public void loginDo(View view){
        //convert entered fields from EditText to String type
        String emailValue=email.getText().toString();
        String passwordValue=password.getText().toString();

        //check if email and pwd is empty
        if(emailValue!="" && passwordValue!=""){

        //declare id variable
            int id;
        // declare cursor variable that will hold fields from the database - Cursor inbuilt
            Cursor cursor;

        //cursor holds the fields from table
            cursor=SQLITEDB.rawQuery("SELECT id FROM users WHERE email=? AND password=?",new String[]{emailValue,passwordValue}); //rawQuery() - returns Cursor
        //new String[]{emailValue,passwordValue} - String array binds parameters to the placeholder

            //check if table is not empty
            if(cursor.getCount() > 0){
                cursor.moveToFirst(); //if row exist, should go to the first row
                id=cursor.getInt(cursor.getColumnIndex("id")); //id variable picks the index of the id(field in table)

                //deal with sessions in android
                SharedPreferences.Editor e=sharedPreferences.edit(); //Editor is class of SharedPreference
                e.putInt("userid",id); //pass "userid" key that we shall pass around in other activities, we use putInt() since its keeping an int id variable
                e.commit();

                //if login is correct,, redirect to Dashboard Activity
                Intent i = new Intent(this, DashboardActivity.class);
                startActivity(i);

            }else{
                message.setText("Email and password dont exist");
            }

        }else{
            message.setText("All fields are required");
        }

    }

    public void resetDo(View view){
        //when reaet is clicked.,, should clear all field
        email.setText(""); password.setText("");  //set the field to empty ""
    }
}
