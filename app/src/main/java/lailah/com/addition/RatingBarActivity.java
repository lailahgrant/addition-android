package lailah.com.addition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingBarActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView txtRatingValue;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        //add 2 fns
        addListenerOnRatingBar();
        addListenerOnButton();

    }

    //rating bar
    public void addListenerOnRatingBar(){
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        txtRatingValue=(TextView)findViewById(R.id.textView17);

    //if rating value is changed, display current rating value in the empty label next to the Result label
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtRatingValue.setText(String.valueOf(rating));
            }
        });

    }

    //button
    public void addListenerOnButton(){
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        btnSubmit=(Button)findViewById(R.id.button8);

        //if button is clicked, then display the current rating value
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RatingBarActivity.this, String.valueOf(ratingBar.getRating()),Toast.LENGTH_LONG).show();
            }
        });
    }
}
