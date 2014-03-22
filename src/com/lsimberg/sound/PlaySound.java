package com.lsimberg.sound;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.util.Log;

public class PlaySound {
	private SoundPool soundPool;
	private int soundID;
	private boolean loaded = false;
	private int streamID;
	private Activity act;
	
	public PlaySound(Activity act, int resIdSound) {
	    this.act = act;
		act.setVolumeControlStream(AudioManager.STREAM_MUSIC);
	    soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
	    soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
	      @Override
	      public void onLoadComplete(SoundPool soundPool, int sampleId,
	          int status) {
	        loaded = true;
	      } 
	    });
	    soundID = soundPool.load(act, resIdSound, 1);
	}
	
	/**
	 * 
	 * @param loop how many times will replay (-1 infinity)
	 */
	public void play(int loop){
    	AudioManager audioManager = (AudioManager)act.getSystemService(act.AUDIO_SERVICE);
        float actualVolume = (float) audioManager
            .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
            .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        // Is the sound loaded already?
        if (loaded) {
        	System.out.println(soundID);
          streamID = soundPool.play(soundID, volume, volume, 1, loop, 1f);
        }
	}
	
	public void stop(){
    	soundPool.stop(streamID); 
	}
	
}
