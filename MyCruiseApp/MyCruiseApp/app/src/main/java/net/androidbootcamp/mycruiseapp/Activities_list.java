package net.androidbootcamp.mycruiseapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class Activities_list extends BaseAdapter {

    private Context mContext;
    private List<Activitiesonboard> mActivitiesonboardList;

    //Constructor

    public Activities_list(Context mContext, List<Activitiesonboard> mActivitiesonboardList) {
        this.mContext = mContext;
        this.mActivitiesonboardList = mActivitiesonboardList;
    }

    @Override
    public int getCount() {
        return mActivitiesonboardList.size();
    }

    @Override
    public Object getItem(int position) {
        return mActivitiesonboardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.activity_activities_list, null);

        TextView tvName = (TextView)v.findViewById(R.id.tv_name);
        TextView tvPrice = (TextView)v.findViewById(R.id.tv_price);
        TextView tvDescription = (TextView)v.findViewById(R.id.tv_description);
        //Set text for TextView
        tvName.setText(mActivitiesonboardList.get(position).getName());
        tvPrice.setText(String.valueOf(mActivitiesonboardList.get(position).getPrice()) + " $");
        tvDescription.setText(mActivitiesonboardList.get(position).getDescription());

        //Save product id to tag
        v.setTag(mActivitiesonboardList.get(position).getId());

        return v;
    }

}
