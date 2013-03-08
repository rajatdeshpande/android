package com.example.myabsapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

public class ABSApp extends Application {

	static final String TAG = "ABSApp";

	ArrayList<Map<String, String>> dessertMenuData;
	ArrayList<Map<String, String>> drinksMenuData;
	ArrayList<Map<String, String>> mainsMenuData;
	boolean dataBuilt = false;

	public boolean isDataBuilt() {
		return dataBuilt;
	}

	private static ABSApp mInstance;

	public ArrayList<Map<String, String>> getDessertMenuData() {
		return dessertMenuData;
	}

	public void setDessertMenuData(
			ArrayList<Map<String, String>> dessertMenuData) {
		this.dessertMenuData = dessertMenuData;
	}

	public ArrayList<Map<String, String>> getDrinksMenuData() {
		return drinksMenuData;
	}
 
	public void setDrinksMenuData(ArrayList<Map<String, String>> drinksMenuData) {
		this.drinksMenuData = drinksMenuData;
	}

	public ArrayList<Map<String, String>> getMainsMenuData() {
		return mainsMenuData;
	}

	public void setMainsMenuData(ArrayList<Map<String, String>> mainsMenuData) {
		this.mainsMenuData = mainsMenuData;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;

		Log.d(TAG, "OnCreate");
		// dessertMenuData = buildDessertsData();
		// drinksMenuData = buildDrinksData();
		// mainsMenuData = buildMainsData();
	}

	public static ABSApp getInstance() {
		return mInstance;
	}

	private HashMap<String, String> putData(String name, String purpose,
			String quantity) {
		HashMap<String, String> item = new HashMap<String, String>();
		item.put("name", name);
		item.put("price", purpose);
		item.put("quantity", quantity);
		return item;
	}

	void buildDessertsData() {
		Log.d(TAG, "buildDessertsData");

		dessertMenuData = new ArrayList<Map<String, String>>();
		dessertMenuData.add(putData("Ras Malai", "200", "0"));
		dessertMenuData.add(putData("Jelly Bean", "5", "0"));
		dessertMenuData.add(putData("Raj bhog", "600", "0"));
		dessertMenuData.add(putData("Kaju Katli", "100", "0"));
		dessertMenuData.add(putData("Soan Papdi", "500", "0"));
		dessertMenuData.add(putData("Soan Papdi", "323", "0"));
		dessertMenuData.add(putData("Soan Papdi2", "200", "0"));
		dessertMenuData.add(putData("Soan Papdi3", "200", "0"));
		dessertMenuData.add(putData("Soan Papdi4", "200", "0"));
		dessertMenuData.add(putData("Soan Papdi5", "200", "0"));
		dessertMenuData.add(putData("Soan Papdi6", "200", "0"));

	}

	void buildDrinksData() {

		Log.d(TAG, "buildDrinksData");
		Toast.makeText(getApplicationContext(), "Making Drinks Menu",
				Toast.LENGTH_LONG).show();

		drinksMenuData = new ArrayList<Map<String, String>>();
		drinksMenuData.add(putData("Coffee", "200", "0"));
		drinksMenuData.add(putData("Vanila Milk Shake", "5", "0"));
		drinksMenuData.add(putData("Tea", "600", "0"));
		drinksMenuData.add(putData("Rum", "100", "0"));
		drinksMenuData.add(putData("Whatever", "500", "0"));
	}

	public void setDataBuilt(boolean dataBuilt) {
		this.dataBuilt = dataBuilt;
	}

	void buildMainsData() {
		Log.d(TAG, "buildMainsData");

		mainsMenuData = new ArrayList<Map<String, String>>();
		mainsMenuData.add(putData("Wraps", "200", "0"));
		mainsMenuData.add(putData("Idlis", "5", "0"));
		mainsMenuData.add(putData("Samosas", "600", "0"));
		mainsMenuData.add(putData("Pulao", "100", "0"));
		mainsMenuData.add(putData("Pizza", "500", "0"));

	}

	@Override
	public void onTerminate() {

		Log.d(TAG, "OnTerminate");

		super.onTerminate();
	}

	public void buildAllData() {
		buildDessertsData();
		buildDrinksData();
		buildMainsData();
		dataBuilt = true;

	}

}
