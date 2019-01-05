package net.androidbootcamp.mycruiseapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmpActivity extends Activity {

    TableLayout theView;
    SQLiteDatabase wdb;
    EditText txtCCNumber, txtPassword, txtCVV, txtExpireDate;
    Button btnClear;
    int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp);


        btnClear = (Button)findViewById(R.id.btnClear);
        txtCCNumber = (EditText)findViewById(R.id.txtCCNumber);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        txtCVV = (EditText)findViewById(R.id.txtCVV);
        txtExpireDate = (EditText)findViewById(R.id.txtExpireDate);

        btnClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //Clear EditText
                txtCCNumber.getText().clear();
                txtPassword.getText().clear();
                txtCVV.getText().clear();
                txtExpireDate.getText().clear();
                Toast.makeText(getApplicationContext(), "Payment Accepted", Toast.LENGTH_SHORT).show();

            }
        });

        ArrayList<String> guestIds = getIntent().getStringArrayListExtra("ids");
        final Spinner s = (Spinner) findViewById(R.id.deptNum_fk);

        // Context, layout , source of the data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, guestIds);
        s.setAdapter(adapter);

        wdb = net.androidbootcamp.mycruiseapp.DBoperationSupport.getWritable(this);
        theView = (TableLayout) findViewById(R.id.theEmpTable);

        // Select All Query
        final String selectQuery = "SELECT  id, fn, ln ,  room_id, roomType, MainGuest " +
                "FROM guests, department " +
                "where guests.room_id = department.roomid ";
        net.androidbootcamp.mycruiseapp.DBoperationSupport.displayAll(theView,wdb,this, selectQuery); // display the rows (if any exists)
        final Button btn = (Button) findViewById(R.id.btnEmpAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView eID = (TextView) findViewById(R.id.gtID);
                EditText eFName = (EditText)findViewById(R.id.guestFN);
                EditText eLName = (EditText)findViewById(R.id.guestLN);
                String guestId = s.getSelectedItem().toString();


                if (clicks >= 2){
                    btn.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "If you want to add more guest, you should add more Room", Toast.LENGTH_SHORT).show();

                }else{
                    ContentValues values = new ContentValues();

                    values.put("fn", eFName.getText().toString());
                    values.put("ln", eLName.getText().toString());
                    values.put("room_id", guestId);

                    // all columns would have a value
                    long newRowId = wdb.insert("Guests", null, values);
                    eID.setText(newRowId + "");
                    DBoperationSupport.displayAll(theView,wdb,EmpActivity.this, selectQuery);
                }

                clicks++;


            }
        });
    }

}
