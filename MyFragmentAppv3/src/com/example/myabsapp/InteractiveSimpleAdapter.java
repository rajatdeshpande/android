package com.example.myabsapp;

import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class InteractiveSimpleAdapter extends SimpleAdapter implements
		OnClickListener {

	private Context context;
	public ArrayList<Map<String, String>> data;

	public ArrayList<Map<String, String>> getData() {
		return data;
	}

	public InteractiveSimpleAdapter(Context context,
			ArrayList<Map<String, String>> data, int resource, String[] from,
			int[] to) {

		super(context, data, resource, from, to);

		this.context = context;
		this.data = data;
		// initQuantityTracker();
	}

	static class ViewHolder {

		TextView nametext;
		TextView pricetext;
		TextView quantitytext;
		Button buttonadd;
		Button buttonsubtract;
		ImageView image;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			LayoutInflater inflator = ((Activity) context).getLayoutInflater();
			view = inflator.inflate(R.layout.rowlayout2, null);
			final ViewHolder viewholder = new ViewHolder();
			viewholder.nametext = (TextView) view.findViewById(R.id.label2);
			viewholder.pricetext = (TextView) view
					.findViewById(R.id.item_price2);
			viewholder.quantitytext = (TextView) view
					.findViewById(R.id.item_quantity2);
			viewholder.buttonadd = (Button) view
					.findViewById(R.id.item_increase2);
			viewholder.buttonsubtract = (Button) view
					.findViewById(R.id.item_decrease2);
			viewholder.buttonadd.setOnClickListener(this);
			viewholder.buttonsubtract.setOnClickListener(this);
			// viewholder.quantitytext.setTag(quantityTracker.get(position));
			viewholder.buttonadd.setTag(Integer.valueOf(position));
			viewholder.buttonsubtract.setTag(Integer.valueOf(position));
			view.setTag(viewholder);
		}

		ViewHolder holder = new ViewHolder();
		holder = (ViewHolder) view.getTag();
		// holder.quantitytext.setTag(quantityTracker.get(position));
		holder.buttonadd.setTag(Integer.valueOf(position));
		holder.buttonsubtract.setTag(Integer.valueOf(position));

		holder.nametext.setText(data.get(position).get("name"));
		holder.pricetext.setText(data.get(position).get("price"));
		// holder.quantitytext.setText(quantityTracker.get(position));

		// always populate the folder with data, but modify data in the
		// onclicklistner
		holder.quantitytext.setText(data.get(position).get("quantity"));

		return view;
	}

	@Override
	public void onClick(View v) {

		ViewHolder tempholder = new ViewHolder();
		View tempview;
		Integer tempposition;
		tempview = (View) v.getParent();
		tempposition = (Integer) v.getTag();
		tempholder = (ViewHolder) tempview.getTag();

		if (v.getId() == R.id.item_increase2) {
			// modify the holder which corresponds to the view which is the
			// parent of the clicked button
			tempholder.quantitytext.setText(Integer.toString(Math.max(
					Integer.parseInt(tempholder.quantitytext.getText()
							.toString()) + 1, 0)));

			data.get(tempposition.intValue()).put(
					"quantity",
					Integer.toString(Math.max(Integer
							.parseInt(tempholder.quantitytext.getText()
									.toString()), 0)));

		}

		else if (v.getId() == R.id.item_decrease2) {
			/*
			 * modify the holder which corresponds to the view which is the
			 * parent of the clicked button
			 */
			tempholder.quantitytext.setText(Integer.toString(Math.max(
					Integer.parseInt(tempholder.quantitytext.getText()
							.toString()) - 1, 0)));

			// update the quantity tracker with the updated value

			// update the data with the updated value
			data.get(tempposition.intValue()).put(
					"quantity",
					Integer.toString(Math.max(Integer
							.parseInt(tempholder.quantitytext.getText()
									.toString()), 0)));

		}
	}

}
