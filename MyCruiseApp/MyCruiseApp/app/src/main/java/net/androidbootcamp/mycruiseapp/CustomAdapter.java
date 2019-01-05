package net.androidbootcamp.mycruiseapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

	private Context context;
	private List<RowItem> rowItems;

	CustomAdapter(Context context, List<RowItem> rowItems) {
		this.context = context;
		this.rowItems = rowItems;
	}

	@Override
	public int getCount() {
		return rowItems.size();
	}

	@Override
	public Object getItem(int position) {
		return rowItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return rowItems.indexOf(getItem(position));
	}

	private class ViewHolder {
		ImageView profile_pic;
		TextView port_name;
		TextView status;
		TextView departsType;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder = new ViewHolder();

			holder.port_name = (TextView) convertView
					.findViewById(R.id.port_name);
			holder.profile_pic = (ImageView) convertView
					.findViewById(R.id.profile_pic);
			holder.status = (TextView) convertView.findViewById(R.id.status);
			holder.departsType = (TextView) convertView
					.findViewById(R.id.port_type);

			RowItem row_pos = rowItems.get(position);

			holder.profile_pic.setImageResource(row_pos.getProfile_pic_id());
			holder.port_name.setText(row_pos.getPort_name());
			holder.status.setText(row_pos.getStatus());
			holder.departsType.setText(row_pos.getDepartsType());

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}

}
