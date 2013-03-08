package com.example.myabsapp;

import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class DessertsOrderFragment extends ListFragment {

	public static final String TAG = "DessertsOrderFragment";
	private InteractiveSimpleAdapter adapter;
	public ArrayList<Map<String, String>> dessertsMenuData;
	ListView listview;

	@Override
	public void onAttach(Activity activity) {
		Log.d(TAG, "OnAttach");
		dessertsMenuData = ABSApp.getInstance().getDessertMenuData();
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG, "OnCreateView");
		View v1 = inflater.inflate(R.layout.order_fragment_layout, container,
				false);
		listview = (ListView) v1.findViewById(android.R.id.list);
		String[] from = { "name", "price", "quantity" };
		int[] to = { R.id.label2, R.id.item_price2, R.id.item_quantity2 };
		adapter = new InteractiveSimpleAdapter(getActivity(), dessertsMenuData,
				R.layout.rowlayout2, from, to);
		listview.setAdapter(adapter);
		return v1;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "OnCreate");
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {

		Log.d(TAG, "OnPause");
		// dessertsMenuData = adapter.getData();

		ABSApp.getInstance().setDessertMenuData(adapter.getData());
		super.onPause();
	}

	@Override
	public void onResume() {
		Log.d(TAG, "OnResume");
		super.onResume();
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "OnDestroy");

		super.onDestroy();
	}

	@Override
	public void onDetach() {
		Log.d(TAG, "OnDetach");
		super.onDetach();
	}

}
