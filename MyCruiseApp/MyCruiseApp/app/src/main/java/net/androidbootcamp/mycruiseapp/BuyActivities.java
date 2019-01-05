package net.androidbootcamp.mycruiseapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BuyActivities extends Activity {

    TableLayout theView;
    SQLiteDatabase wdb;
    List<String> roomList, numberList;
    static Spinner roomType, roomNumber;
    ArrayAdapter<String> adp1, adp2;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_activities);

        roomList=new ArrayList<String>();

        roomList.add("---Select the Room Type---");
        roomList.add("Inside(Deck 1)");
        roomList.add("OceanView(Deck 2)");
        roomList.add("OceanView(Deck 3)");
        roomList.add("Suit(Deck 3)");

        roomType = (Spinner) findViewById(R.id.roomType);
        roomNumber= (Spinner) findViewById(R.id.roomNumber);

        adp1=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,roomList);
        adp1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        roomType.setAdapter(adp1);

        roomType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                pos = arg2;
                add();


            }

            private void add() {
                // TODO Auto-generated method stub


                switch (pos) {

                    case 0:

                        Toast.makeText(getApplicationContext(), "Select the Room Type", Toast.LENGTH_SHORT).show();

                        select();

                        break;

                    case 1:
                        numberList = new ArrayList<String>();
                        numberList.add("Room 102");
                        numberList.add("Room 106");
                        numberList.add("Room 118");

                        adp2 = new ArrayAdapter<String>(BuyActivities.this,
                                android.R.layout.simple_dropdown_item_1line, numberList);
                        adp2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        roomNumber.setAdapter(adp2);

                        select();

                        break;
                    case 2:
                        numberList = new ArrayList<String>();
                        numberList.add("Room 204");
                        numberList.add("Room 211");
                        numberList.add("Room 218");

                        adp2 = new ArrayAdapter<String>(BuyActivities.this,
                                android.R.layout.simple_dropdown_item_1line, numberList);
                        adp2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        roomNumber.setAdapter(adp2);

                        select();

                        break;

                    case 3:
                        numberList = new ArrayList<String>();
                        numberList.add("Room 301");
                        numberList.add("Room 348");
                        numberList.add("Room 384");

                        adp2 = new ArrayAdapter<String>(BuyActivities.this,
                                android.R.layout.simple_dropdown_item_1line, numberList);
                        adp2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        roomNumber.setAdapter(adp2);

                        select();

                        break;

                    case 4:
                        numberList = new ArrayList<String>();
                        numberList.add("Room 305");
                        numberList.add("Room 356");
                        numberList.add("Room 392");

                        adp2 = new ArrayAdapter<String>(BuyActivities.this,
                                android.R.layout.simple_dropdown_item_1line, numberList);
                        adp2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        roomNumber.setAdapter(adp2);

                        select();

                        break;
                }

            }
            private void select() {
                // TODO Auto-generated method stub

                roomNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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

        wdb = net.androidbootcamp.mycruiseapp.DBoperationSupport.getWritable(this);
        theView = (TableLayout) findViewById(R.id.theTable);

        // Select All Query
        final String selectQuery = "SELECT  actid, actname, actticket FROM BuyActivitiesTable ";
        net.androidbootcamp.mycruiseapp.DBoperationSupport.displayAll(theView,wdb,this, selectQuery); // display the rows (if any exists)

        Button bAdd = (Button) findViewById(R.id.btnAdd);
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dID = (TextView) findViewById(R.id.roomID);
                Spinner dType = (Spinner) findViewById(R.id.roomType);
                Spinner dMainGuest = (Spinner) findViewById(R.id.roomNumber);

                ContentValues values = new ContentValues();
                values.put("actname", dType.getSelectedItem().toString());
                values.put("actticket", dMainGuest.getSelectedItem().toString());

                // all columns would have a value
                long newRowId = wdb.insert("BuyActivitiesTable", null, values);
                dID.setText(newRowId + "");
                net.androidbootcamp.mycruiseapp.DBoperationSupport.displayAll(theView,wdb,BuyActivities.this, selectQuery);
            }
        });

    }

}
