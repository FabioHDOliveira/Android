package net.androidbootcamp.mycruiseapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DisneyDream_Price extends AppCompatActivity {

    private static final String TAG = "DisneyDream_Price";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    private TextView txtAdult, txtChild, txtDreamResultPN, txtDreamResultPN2, txtDreamResultPN3, txtResultTotal, txtResultTotal2, txtResultTotal3;
    Spinner spnNight,spnDay;
    String nightSelected;
    int counter;
    int counter2;
    private int numberAdult;
    private int numberChild;
    private double totalCost, totalCost2, totalCost3;
    Button btnUpdatePrice, btnSendInvoice, btnMinusAdult, btnPlusAdult, btnMinusChild, btnPlusChild;
    ArrayAdapter<String> adp3,adp4;
    List<String> nightList, dayList;
    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disney_dream__price);

        nightList=new ArrayList<String>();

        nightList.add("---Select the Nights---");
        nightList.add("3 Nights Bahamas (Port Canaveral Roundtrip)");
        nightList.add("5 Nights Bahamas (Port Canaveral Roundtrip)");
        nightList.add("8 Nights Bahamas (Port Canaveral Roundtrip)");

        spnNight= (Spinner) findViewById(R.id.spnNight);
        spnDay= (Spinner) findViewById(R.id.spnDay);

        adp3=new ArrayAdapter<String> (this,android.R.layout.simple_dropdown_item_1line,nightList);
        adp3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spnNight.setAdapter(adp3);

        spnNight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                pos=arg2;
                add();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        btnUpdatePrice = (Button)findViewById(R.id.btnUpdatePrice);

        btnUpdatePrice.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                txtDreamResultPN = (TextView)findViewById(R.id.txtDreamResultPN);
                txtDreamResultPN2 = (TextView)findViewById(R.id.txtDreamResultPN2);
                txtDreamResultPN3 = (TextView)findViewById(R.id.txtDreamResultPN3);
                txtResultTotal = (TextView)findViewById(R.id.txtResultTotal);
                txtResultTotal2 = (TextView)findViewById(R.id.txtResultTotal2);
                txtResultTotal3 = (TextView)findViewById(R.id.txtResultTotal3);

                numberAdult = Integer.parseInt(txtAdult.getText().toString());
                numberChild = Integer.parseInt(txtChild.getText().toString());

                DecimalFormat currency = new DecimalFormat("$###,###.##");

                nightSelected = spnNight.getSelectedItem().toString();

                if(nightSelected == "3 Nights Bahamas (Port Canaveral Roundtrip)") {
                    if(numberAdult == 0){
                        if(numberChild > 0){
                            Toast.makeText(getApplicationContext(), "A Child cannot go alone. Select at least an Adult", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            txtDreamResultPN.setText("$0.00");
                            txtDreamResultPN2.setText("$0.00");
                            //txtDreamResultPN3.setText("$0.00");
                        }
                    }
                    else {
                        totalCost = (numberAdult + numberChild) * 189 * 3;
                        totalCost2 = (numberAdult + numberChild) * 289 * 3;
                        //totalCost3 = (numberAdult + numberChild) * 389 * 3;
                        txtDreamResultPN.setText("$189");
                        txtDreamResultPN2.setText("$289");
                        //txtDreamResultPN3.setText("$389");
                        txtResultTotal.setText(currency.format(totalCost));
                        txtResultTotal2.setText(currency.format(totalCost2));
                        //txtResultTotal3.setText(currency.format(totalCost3));
                    }
                }

                if(nightSelected == "5 Nights Bahamas (Port Canaveral Roundtrip)") {
                    totalCost = (numberAdult + numberChild) * 189 * 5;
                    totalCost2 = (numberAdult + numberChild) * 289 * 5;
                    totalCost3 = (numberAdult + numberChild) * 389 * 5;
                    txtDreamResultPN.setText("$189");
                    txtDreamResultPN2.setText("$289");
                    //txtDreamResultPN3.setText("$389");
                    txtResultTotal.setText(currency.format(totalCost));
                    txtResultTotal2.setText(currency.format(totalCost2));
                    //txtResultTotal3.setText(currency.format(totalCost3));
                }

                if(nightSelected == "8 Nights Bahamas (Port Canaveral Roundtrip)") {
                    totalCost = (numberAdult + numberChild) * 189 * 8;
                    totalCost2 = (numberAdult + numberChild) * 289 * 8;
                    totalCost3 = (numberAdult + numberChild) * 389 * 8;
                    txtDreamResultPN.setText("$189");
                    txtDreamResultPN2.setText("$289");
                    //txtDreamResultPN3.setText("$389");
                    txtResultTotal.setText(currency.format(totalCost));
                    txtResultTotal2.setText(currency.format(totalCost2));
                    //txtResultTotal3.setText(currency.format(totalCost3));
                }

            }
        });


        btnMinusAdult = (Button)findViewById(R.id.btnMinusAdult);
        btnPlusAdult = (Button)findViewById(R.id.btnPlusAdult);
        btnMinusChild = (Button)findViewById(R.id.btnMinusChild);
        btnPlusChild = (Button)findViewById(R.id.btnPlusChild);
        txtAdult = (TextView)findViewById(R.id.txtAdult);
        txtChild = (TextView)findViewById(R.id.txtChild);

        btnPlusAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                txtAdult.setText(Integer.toString(counter));
            }
        });


       btnMinusAdult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                counter--;
                txtAdult.setText(Integer.toString(counter));

            }
        });

        btnPlusChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                txtChild.setText(Integer.toString(counter2));
            }
        });


        btnMinusChild.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                counter2--;
                txtChild.setText(Integer.toString(counter2));

            }
        });

        btnSendInvoice = (Button)findViewById(R.id.btnSendInvoice);

        btnSendInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisneyDream_Price.this, DisneyDream_Guest.class));
            }
        });


    } // end of onCreate

    private void add() {
        // TODO Auto-generated method stub

        switch(pos)
        {

            case 0:

                Toast.makeText(getApplicationContext(), "Select the Nights", Toast.LENGTH_SHORT).show();

                select();

                break;

            case 1:
                dayList= new ArrayList<String>();
                dayList.add("October 11, 2018");
                dayList.add("November 22, 2018");
                dayList.add("December 27, 2018");

                adp4=new ArrayAdapter<String>(DisneyDream_Price.this,
                        android.R.layout.simple_dropdown_item_1line,dayList);
                adp4.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spnDay.setAdapter(adp4);

                select();

                break;
            case 2:
                dayList= new ArrayList<String>();
                dayList.add("September 20, 2018");
                dayList.add("November 01, 2018");
                dayList.add("December 13, 2018");

                adp4=new ArrayAdapter<String>(DisneyDream_Price.this,
                        android.R.layout.simple_dropdown_item_1line,dayList);
                adp4.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spnDay.setAdapter(adp4);

                select();

                break;

            case 3:
                dayList= new ArrayList<String>();
                dayList.add("August 30, 2018");
                dayList.add("September 13, 2018");
                dayList.add("October 18, 2018");

                adp4=new ArrayAdapter<String>(DisneyDream_Price.this,
                        android.R.layout.simple_dropdown_item_1line,dayList);
                adp4.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spnDay.setAdapter(adp4);

                select();

                break;
        }

    }

    private void select() {
        // TODO Auto-generated method stub

        spnDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


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

    public void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1fragment(), "Inside");
        adapter.addFragment(new Tab2fragment(), "Oceanview");
        adapter.addFragment(new Tab3fragment(), "Suite");

        viewPager.setAdapter(adapter);

    }

}
