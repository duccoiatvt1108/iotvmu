package com.example.test01_iot_21_11;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "MainActivity";
    private SensorManager sensorManager;
    private Sensor accelerometer,magnetometer,gyroscope;
    TextView xvalue,yvalue,zvalue;
    TextView xgyroscopevalue,ygyroscopevalue,zgyroscopevalue;
    TextView xmagnetometervalue,ymagnetometervalue,zmagnetometervalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);//allow use sensors
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);//cảm biến gia tốc
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);//cảm biến từ trường(từ kế)
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if(accelerometer != null){
            sensorManager.registerListener(MainActivity.this,accelerometer,sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Accelerometer Sensor Listener");
        }
        else{
            xvalue.setText("AcceleroMeter isn't supported in this device");
            yvalue.setText("AcceleroMeter isn't supported in this device");
            zvalue.setText("AcceleroMeter isn't supported in this device");
        }

        xvalue = (TextView) findViewById(R.id.xvalue);
        yvalue = (TextView) findViewById(R.id.yvalue);
        zvalue = (TextView) findViewById(R.id.zvalue);

        xgyroscopevalue = (TextView) findViewById(R.id.xGyroValue);
        ygyroscopevalue = (TextView) findViewById(R.id.yGyroValue);
        zgyroscopevalue = (TextView) findViewById(R.id.zGyroValue);

        if(gyroscope != null){
            sensorManager.registerListener(MainActivity.this,gyroscope,sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Gyroscope Sensor Listener");
        }
        else {
            xgyroscopevalue.setText("GyroScope isn't supported in this device");
            ygyroscopevalue.setText("GyroScope isn't supported in this device");
            zgyroscopevalue.setText("GyroScope isn't supported in this device");
        }
        xmagnetometervalue = (TextView) findViewById(R.id.xMagnetValue);
        ymagnetometervalue = (TextView) findViewById(R.id.yMagnetValue);
        zmagnetometervalue = (TextView) findViewById(R.id.zMagnetValue);

        if(magnetometer != null){
            sensorManager.registerListener(MainActivity.this,magnetometer,sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered MagnetoMeter Sensor Listener");
        }
        else {
            xmagnetometervalue.setText("MagnetoMeter isn't supported in this device");
            ymagnetometervalue.setText("MagnetoMeter isn't supported in this device");
            zmagnetometervalue.setText("MagnetoMeter isn't supported in this device");
        }
        //sensorManager.registerListener(MainActivity.this,magnetometer,sensorManager.SENSOR_DELAY_NORMAL);
        //Log.d(TAG, "onCreate: Registered Magnetometer Sensor Listener");
        
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            xvalue.setText("X Acc axis: "+event.values[0]);
            yvalue.setText("Y Acc axis: "+event.values[1]);
            zvalue.setText("Z Acc axis: "+event.values[2]);
            Log.d(TAG, "onSensorChanged: X acc: "+ event.values[0] + " Y acc: "+event.values[1]+" Z acc: "+ event.values[2]);
        }
        else if(sensor.getType() == Sensor.TYPE_GYROSCOPE){
            xgyroscopevalue.setText("X Gyro axis: "+event.values[0]);
            ygyroscopevalue.setText("Y Gyro axis: "+event.values[1]);
            zgyroscopevalue.setText("Z Gyro axis: "+event.values[2]);
            Log.d(TAG, "onSensorChanged: X gyro: "+ event.values[0] + " Y gyro: "+event.values[1]+" Z gyro: "+ event.values[2]);
        } else if(sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            xmagnetometervalue.setText("X Magnet axis: "+event.values[0]);
            ymagnetometervalue.setText("Y Magnet axis: "+event.values[1]);
            zmagnetometervalue.setText("Z Magnet axis: "+event.values[2]);
            Log.d(TAG, "onSensorChanged: X magnet: "+ event.values[0] + " Y magnet: "+event.values[1]+" Z magnet: "+ event.values[2]);
        }

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}