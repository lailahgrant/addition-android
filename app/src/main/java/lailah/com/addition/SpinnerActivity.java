package lailah.com.addition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{

//declare an array to hold the country
String[] country={"Uganda","Kenya","Tanzania","DRC","Rwanda","Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        //getting the inteface of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner)findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //create the ArrayAdapter instance having country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

    }

    //performing action OnItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id){
        Toast.makeText(getApplicationContext(),country[position],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0){
        Toast.makeText(this, "Please select your country ", Toast.LENGTH_LONG).show();
    }



}
