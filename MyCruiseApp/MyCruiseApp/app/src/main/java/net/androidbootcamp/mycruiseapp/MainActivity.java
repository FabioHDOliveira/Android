package net.androidbootcamp.mycruiseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spnLine,spnShip;
    String spnSelected;
    Button btnNext;
    ArrayAdapter<String> adp1,adp2;
    List<String> lineList, shipList;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lineList=new ArrayList<String>();

        lineList.add("---Select a Line---");
        lineList.add("Disney Cruise");
        //lineList.add("MSC Cruise");

        spnLine= (Spinner) findViewById(R.id.spnLine);
        spnShip= (Spinner) findViewById(R.id.spnShip);

        adp1=new ArrayAdapter<String> (this,android.R.layout.simple_dropdown_item_1line,lineList);
        adp1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spnLine.setAdapter(adp1);

        spnLine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                pos=arg2;
                add();

            }

            private void add() {
                // TODO Auto-generated method stub


                switch(pos)
                {

                    case 0:

                        Toast.makeText(getApplicationContext(), "Select a Line", Toast.LENGTH_SHORT).show();

                        select();

                        break;

                    case 1:
                        shipList= new ArrayList<String>();
                        shipList.add("Disney Dream");
                        shipList.add("Disney Fantasy");
                        shipList.add("Disney Magic");

                        adp2=new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_dropdown_item_1line,shipList);
                        adp2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        spnShip.setAdapter(adp2);

                        select();

                        break;
                    case 2:
                        shipList= new ArrayList<String>();
                        shipList.add("MSC Music");
                        shipList.add("MSC Fantasy");
                        shipList.add("MSC Seaside");

                        adp2=new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_dropdown_item_1line,shipList);
                        adp2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        spnShip.setAdapter(adp2);

                        select();

                        break;
                }

            }

            private void select() {
                // TODO Auto-generated method stub

                spnShip.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        // TODO Auto-generated method stub


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        btnNext = (Button)findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                spnSelected = spnShip.getSelectedItem().toString();

                if(spnSelected == "Disney Dream") {
                    startActivity(new Intent(MainActivity.this, Disney_Dream.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Sorry, this Cruise is Sold Out", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
