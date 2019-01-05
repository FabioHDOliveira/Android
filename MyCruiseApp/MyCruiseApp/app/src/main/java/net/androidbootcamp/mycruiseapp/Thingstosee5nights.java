package net.androidbootcamp.mycruiseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Thingstosee5nights extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thingstosee5nights);

        Button btnnassau = (Button)findViewById(R.id.btnNassau);
        Button btnCastaway = (Button)findViewById(R.id.btnCozumel);

        btnnassau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Thingstosee5nights.this, ActivitiesNassau.class));
            }
        });

        btnCastaway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Thingstosee5nights.this, ActivitiesCastaway.class));
            }
        });
    }
}
