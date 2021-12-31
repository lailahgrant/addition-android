package lailah.com.addition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerDemoActivity extends AppCompatActivity {

    Spinner spin;
    ImageView imageview;

    //declare an array to hold the country
    String[] country={"Uganda","Kenya","Tanzania","DRC","Rwanda","Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);

        spin = (Spinner)findViewById(R.id.spinner2);
        imageview = (ImageView)findViewById(R.id.imageView);

        //create the ArrayAdapter instance having country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                if(arg2==0){
                    imageview.setImageResource(R.drawable.img);
                }else if(arg2==1){
                    imageview.setImageResource(R.drawable.imgs);
                }else if(arg2==2){
                    imageview.setImageResource(R.drawable.imag);
                }else if(arg2==3){
                    imageview.setImageResource(R.drawable.imgz);
                }else{
                    imageview.setImageResource(R.drawable.snake);
                }

                Toast.makeText(getApplicationContext(),country[arg2],Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
