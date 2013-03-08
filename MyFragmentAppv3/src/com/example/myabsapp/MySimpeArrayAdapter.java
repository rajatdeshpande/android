package com.example.myabsapp;



import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MySimpeArrayAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] names;

	// private final String[] prices;
	// private final String[] quantities;

	static class ViewHolder {
		public TextView text_item;
		public TextView text_price;
		public TextView text_quantity;
		public Button button_add;
		public Button button_remove;
		public ImageView image;
	}

	public MySimpeArrayAdapter(Context context, String[] names) {
		super(context, R.layout.rowlayout, names);
		this.context = context;
		this.names = names;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
//		View tempView = new View(context);
		if (rowView == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			rowView = inflater.inflate(R.layout.rowlayout, null);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.text_item = (TextView) rowView.findViewById(R.id.label);
			viewHolder.image = (ImageView) rowView.findViewById(R.id.icon);
			viewHolder.button_add = (Button) rowView.findViewById(R.id.item_increase);
			viewHolder.button_remove = (Button) rowView.findViewById(R.id.item_decrease);
			rowView.setTag(viewHolder);
//			tempView.setTag(viewHolder);
		}

		ViewHolder holder = (ViewHolder) rowView.getTag();
//		ViewHolder holder = (ViewHolder) tempView.getTag();
		String s = names[position];
		holder.text_item.setText(s);
		if (s.startsWith("Windows7") || s.startsWith("iPhone")
				|| s.startsWith("Solaris")) {
			holder.image.setImageResource(R.drawable.no);
		} else {
			holder.image.setImageResource(R.drawable.yes);
		}

		return rowView;
	}



}
