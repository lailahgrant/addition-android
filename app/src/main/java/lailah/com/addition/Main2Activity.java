package lailah.com.addition;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    //variable declarations
    EditText fistNumber;
    EditText secondNumber;
    TextView addResult;
    Button btnAdd;
    Button btnBack;
    Button btnExit;

    double num1=0,num2=0,sum=0; //assign variables to 0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //set a value to variables
        fistNumber = (EditText)findViewById(R.id.editText3);//R.id.editText3 is got from text mode in act..xml
        secondNumber = (EditText)findViewById(R.id.editText4);
        addResult = (TextView)findViewById(R.id.textView6);
        btnAdd = (Button)findViewById(R.id.button2);
        btnBack = (Button)findViewById(R.id.button3);
        btnExit = (Button)findViewById(R.id.button4);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //add boolean for validation
                boolean isValidate = true;

                //create a condition of if input field is empty ,,, getYext() - for reading input
                if(fistNumber.getText().toString().length() <=0){
                    fistNumber.setError("Value Required");
                    isValidate=false;
                }

                if(secondNumber.getText().toString().length() <=0){
                    secondNumber.setError("Value Required");
                    isValidate=false;
                }

                //now if validation is ok - if user enters values greater than 0
                if(isValidate){
                    //convert the integer num1,num2 to double from strings
                    num1 = Double.parseDouble(fistNumber.getText().toString());
                    num2 = Double.parseDouble(secondNumber.getText().toString());
                    sum=num1+num2;

                    //convert the sum result back to string inorder to display it as a label
                    addResult.setText(Double.toString(sum));

                    //create a Toast
                    Toast.makeText(getApplicationContext(),String.valueOf(sum), Toast.LENGTH_LONG).show();

                }



            }
        });

        //code for btnBack
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Intent class calls the mainActivity to run when back button is pressed
                Intent  i = new Intent(v.getContext(),MainActivity.class);
                v.getContext().startActivity(i);
            }
        });


        //code for exit button
        btnExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //create an alert
                final AlertDialog.Builder b = new AlertDialog.Builder(Main2Activity.this);
                b.setTitle("Exit");
                b.setMessage("Do you want to exit??");
                b.setPositiveButton("Yes.Exit now!", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int i){ //code executes when yes is clicked
                        finish();  //totally terminated/stopped
                        System.exit(0);
                    }
                });

                //now we set no :- if no is clicked,, stay on that activity
                b.setNegativeButton("Not now!", new DialogInterface.OnClickListener(){
                   public void onClick(DialogInterface di, int i){
                       di.dismiss();
                   }
                });

                AlertDialog ad =b.create();
                ad.show();

            }
        });



    }
}
