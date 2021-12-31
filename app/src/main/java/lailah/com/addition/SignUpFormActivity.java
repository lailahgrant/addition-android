package lailah.com.addition;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpFormActivity extends AppCompatActivity {


    private SQLiteDatabase sqliteDB;
    private EditText name,email,pwd,pwd1;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);

        name=(EditText)findViewById(R.id.editText5);
        email=(EditText)findViewById(R.id.editText6);
        pwd=(EditText)findViewById(R.id.editText7);
        pwd1=(EditText)findViewById(R.id.editText8);
        message=(TextView)findViewById(R.id.message);

        sqliteDB=openOrCreateDatabase("people.db", Context.MODE_PRIVATE,null);
        sqliteDB.execSQL("CREATE TABLE IF NOT EXISTS users(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,name VARCHAR(50),email VARCHAR(50),password VARCHAR(15));");

    }

    public void signupDo(View view){
        //variable that will hold entered field
        String myname =name.getText().toString();
        String myemail=email.getText().toString();
        String mypwd=pwd.getText().toString();
        String myconfirmpwd=pwd1.getText().toString();

        //check if passwords match
        if(mypwd.equals(myconfirmpwd)){

            //check if fields arenot empty
            if(myname !="" && myemail !="" && mypwd !=""){
                //insert into table
                sqliteDB.execSQL("INSERT INTO users(name,email,password) VALUES('"+myname+"', '"+myemail+"', '"+mypwd+"')");
                //message showing success
                message.setText("Signup successfully");
            }else{
                message.setText("All fields are required");
            }//empty

        }else {
            message.setText("Passwords dont match");
        }
       // Toast.makeText(SignUpFormActivity.this , "working" , Toast.LENGTH_LONG).show();
    }

    //take the login button onclick to the other activity(LoginActivity)
    public void loginShow(View view){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }


}
