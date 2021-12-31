package lailah.com.addition;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class MyWelcome extends Activity {

    private final int SPLAS_DElAY = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//FEATURE_NO_TITLE - its a constant since its in uppercase
        //hide title on title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide title not the title bar

        //code that displays the content in full screen mode
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_my_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MyWelcome.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        },SPLAS_DElAY);
    }
}
