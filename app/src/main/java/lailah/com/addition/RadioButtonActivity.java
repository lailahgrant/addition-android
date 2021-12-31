package lailah.com.addition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    //create class objects
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        //declare method of listener
        addListenerOnButton();

    }

    public void addListenerOnButton(){ //define the declared method
        //put values into objects
        radioGroup = (RadioGroup)findViewById(R.id.radioButtonG);
        btnDisplay = (Button)findViewById(R.id.button5);

        //set a listener
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get selected radio button from radio
                int selectedId = radioGroup.getCheckedRadioButtonId();

                //find the radiobutton returned by id
                radioButton = (RadioButton)findViewById(selectedId);

                //create a toast
                Toast.makeText(RadioButtonActivity.this, "imh "+radioButton.getText(), Toast.LENGTH_LONG).show();

            }
        });

    }

}
