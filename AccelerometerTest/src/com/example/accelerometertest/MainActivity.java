package com.example.accelerometertest;

import android.os.Bundle;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	
	TextView X, Y, Z;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		X = (TextView)findViewById(R.id.xCoordinate);
		Y = (TextView)findViewById(R.id.yCoordinate);
		Z = (TextView)findViewById(R.id.zCoordinate);
		
		mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		
		mSensorManager.registerListener(this, 
					mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	public void onResume() {
		super.onResume();
		
		mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		
	}
	
	public void onPause() {
		super.onPause();
		
		mSensorManager.unregisterListener(this);
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		
		
		
		if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
		{
			double xAxis = event.values[0];
			double yAxis = event.values[1];
			double zAxis = event.values[2];
			
			X.setText("X: " + xAxis);
			Y.setText("Y: " + yAxis);
			Z.setText("Z: " + zAxis);
		}
		
	}

	

}


