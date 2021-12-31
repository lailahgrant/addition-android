package lailah.com.addition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //create an object of ListView class
    ListView lv;

    //create an array that will hold values of the List View
    String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, days);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View view, int i, long arg3) {
        TextView temp=(TextView)view ;
        Toast.makeText(this,temp.getText()+" "+i, Toast.LENGTH_LONG).show();
    }
}
