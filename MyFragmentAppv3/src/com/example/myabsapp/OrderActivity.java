package com.example.myabsapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class OrderActivity extends Activity implements ActionBar.TabListener {
	static final String TAG = "OrderActivity";
	ArrayList<Map<String, String>> orderList;
	public static Context appContext;
	public static DrinksOrderFragment drinksOrderFragment;
	public static DessertsOrderFragment dessertsOrderFragment;

	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (ABSApp.getInstance().isDataBuilt() == false) {
			ABSApp.getInstance().buildAllData();
		}

		setContentView(R.layout.activity_main);
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		ActionBar.Tab dessertsTab = actionBar.newTab().setText("Desserts");
		ActionBar.Tab drinksTab = actionBar.newTab().setText("Drinks");

		getActionBar().setDisplayHomeAsUpEnabled(true);

		drinksOrderFragment = new DrinksOrderFragment();
		dessertsOrderFragment = new DessertsOrderFragment();

		drinksTab.setTabListener(this);
		dessertsTab.setTabListener(this);

		actionBar.addTab(dessertsTab);
		actionBar.addTab(drinksTab);

	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Log.d(TAG, "OnTabSelected");
		if (tab.getPosition() == 0) {
			ft.replace(R.id.fragment_container, dessertsOrderFragment);
			// Toast.makeText(getApplicationContext(), "Fragment A",
			// Toast.LENGTH_SHORT).show();

		}

		else {
			ft.replace(R.id.fragment_container, drinksOrderFragment);

		}
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	

}
