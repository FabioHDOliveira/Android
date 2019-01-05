package net.androidbootcamp.mycruiseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Disney_Dream extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disney__dream);

        ImageView priceImg;
        priceImg = (ImageView)findViewById(R.id.imgPrice);

        priceImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Disney_Dream.this, DisneyDream_Price.class));
            }
        });

        ImageView activitiesImg;
        activitiesImg = (ImageView)findViewById(R.id.imgActivities);

        activitiesImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Disney_Dream.this, DisneyDream_activities.class));
            }
        });

        ImageView imgPorts;
        imgPorts = (ImageView)findViewById(R.id.imgPorts);

        imgPorts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Disney_Dream.this, Portsofcall.class));
            }
        });

        ImageView imgFood;
        imgFood = (ImageView)findViewById(R.id.imgFood);

        imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Disney_Dream.this, RoomService.class));
            }
        });


    }


}
