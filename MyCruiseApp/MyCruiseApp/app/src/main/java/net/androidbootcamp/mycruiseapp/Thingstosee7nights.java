package net.androidbootcamp.mycruiseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Thingstosee7nights extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thingstosee7nights);

        Button btnCozumel = (Button)findViewById(R.id.btnCozumel);
        Button btnGeorge = (Button)findViewById(R.id.btnGeorge);

        btnCozumel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Thingstosee7nights.this, ActivitiesCozumel.class));
            }
        });

        btnGeorge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Thingstosee7nights.this, ActivitiesGeorge.class));
            }
        });
    }
}
