package net.androidbootcamp.mycruiseapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import java.util.ArrayList;

public class DisneyDream_activities extends Activity {

    private ListView lvProduct;
    private Activities_list adapter;
    private List<Activitiesonboard> mActivitiesonboardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disney_dream_activities);

        lvProduct = (ListView)findViewById(R.id.theList);

        mActivitiesonboardList = new ArrayList<>();
        //Add sample data for list
        //We can get data from DB, webservice here
        mActivitiesonboardList.add(new Activitiesonboard(1, "Virtual Sports Simulators", 28, "Featuring realistic graphics and sounds, virtual sports simulators allow you to kick, swing, throw and compete in some of your favorite active sports while out at sea."));
        mActivitiesonboardList.add(new Activitiesonboard(2, "Royal Court Royal Tea", 210, "Enjoy a whimsical teatime in an idyllic storybook setting adorned with sparkling chandeliers and fanciful icons. The Royal Tea Hostess and Royal Pastry Chef are pleased to make your acquaintance and regale you with stories, dance, sing and encourage you to join in the fun."));
        mActivitiesonboardList.add(new Activitiesonboard(3, "Chill Spa", 89, "We know that teens get stressed out too. That's why we offer this unbelievable, heavenly full-body massage. Your professional therapist will use aromatherapy oils and Swedish massage techniques to banish all that stress."));
        mActivitiesonboardList.add(new Activitiesonboard(4, "Shutters Portrait Studio", 550, "Capture your most precious memories on board with one-of-a-kind portraits taken by our professional photographer during an intimate photo session at Shutters Portrait Studio"));

        //Init adapter
        adapter = new Activities_list(getApplicationContext(), mActivitiesonboardList);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked activity id =" + view.getTag(), Toast.LENGTH_SHORT).show();

                if(position == 0){
                    startActivity(new Intent(DisneyDream_activities.this, BuyActivities.class));
                }
                else if(position == 1){
                    startActivity(new Intent(DisneyDream_activities.this, BuyActivities.class));
                }
                else if(position == 2){
                    startActivity(new Intent(DisneyDream_activities.this, BuyActivities.class));
                }
                else{
                    Toast.makeText(getApplicationContext(), "This activity is no longer available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
