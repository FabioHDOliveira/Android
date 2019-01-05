package net.androidbootcamp.mycruiseapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Portsofcall extends Activity implements AdapterView.OnItemClickListener {

    String[] port_names;
    TypedArray profile_pics;
    String[] statues;
    String[] departsType;

    List<RowItem> rowItems;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portsofcall);

        rowItems = new ArrayList<RowItem>();

        port_names = getResources().getStringArray(R.array.Port_names);

        profile_pics = getResources().obtainTypedArray(R.array.profile_pics);

        statues = getResources().getStringArray(R.array.statues);

        departsType = getResources().getStringArray(R.array.departsType);

        for (int i = 0; i < port_names.length; i++) {
            RowItem item = new RowItem(port_names[i],
                    profile_pics.getResourceId(i, -1),
                    statues[i],
                    departsType[i]);
            Log.d("Ports Of Call","" + i + port_names[i]);
            rowItems.add(item);
            Log.d("Ports Of Call", "add item");
        }
        Log.d("Port Of Call", "done");

        mylistview = (ListView) findViewById(R.id.list);
        CustomAdapter adapter = new CustomAdapter(this, rowItems);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        String port_name = rowItems.get(position).getPort_name();
        Toast.makeText(getApplicationContext(), "" + port_name,
                Toast.LENGTH_SHORT).show();
        if(position == 0){
            startActivity(new Intent(Portsofcall.this, Thingstosee3nights.class));
        }
        else  if(position == 1){
            startActivity(new Intent(Portsofcall.this, Thingstosee5nights.class));
        }
        else{
            startActivity(new Intent(Portsofcall.this, Thingstosee7nights.class));
        }
    }

}
