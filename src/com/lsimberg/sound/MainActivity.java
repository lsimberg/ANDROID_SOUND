package com.lsimberg.sound;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
 

public class MainActivity extends Activity {
	private static final String TAG = "Main Activity";
	private PlaySound ps;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ps = new PlaySound(this, R.raw.baby01);
    }


    
    @Override
    protected void onResume() {
    	super.onResume();
    	
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();

    }
 
    public void onStartSound(View v){
    	Log.i(TAG, "Start sound");
    	ps.play(6);	
    }
 
    public void onStopSound(View v){
    	Log.i(TAG, "Stop sound");
    	ps.stop();
    }
    
   
}
