package lailah.com.addition;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Main3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //hide title on title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide title not the title bar

        //code that displays the content in full screen mode
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
}
