package lailah.com.addition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox chkios, chkAndroid, chkWindows;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        //declare listeners
        addListenerOnChkios();
        addListenerOnButton();
    }

    //crate a listener for incase iphone is clicked
    public void addListenerOnChkios(){
        chkios = (CheckBox)findViewById(R.id.checkBox3);
        chkios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if chkios is clicked
                if(((CheckBox)v).isChecked()){
                    Toast.makeText(CheckBoxActivity.this, "Info, Try Android", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    //if button is clickedp
    public void addListenerOnButton(){
        chkios=(CheckBox)findViewById(R.id.checkBox3);
        chkAndroid=(CheckBox)findViewById(R.id.checkBox);
        chkWindows=(CheckBox)findViewById(R.id.checkBox2);
        btnDisplay=(Button)findViewById(R.id.button6);

        //set a listener on button
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //run when the button is clicked

                StringBuffer result = new StringBuffer(); //used because we a using append()
                result.append("IPhone check: ").append(chkios.isChecked());
                result.append("\nAndroid check: ").append(chkAndroid.isChecked());
                result.append("\n Windows Mobile check: ").append(chkWindows.isChecked());

                Toast.makeText(CheckBoxActivity.this, result.toString(),Toast.LENGTH_LONG).show();

            }
        });

    }

}
