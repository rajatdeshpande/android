package com.example.myabsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class HomeScreenActivity extends Activity implements OnClickListener{
	static final String TAG = "HomeScreenActivity";
	ImageButton OrderButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Create Menu stuff
		
		
		setContentView(R.layout.home_screen_layout);
		OrderButton = (ImageButton) findViewById(R.id.imageButtonOrder);
		OrderButton.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, OrderActivity.class);
		

		startActivity(intent);
		
		
	}

	@Override
	protected void onDestroy() {
		ABSApp.getInstance().setDataBuilt(false);
		super.onDestroy();
	}
	
	

}
