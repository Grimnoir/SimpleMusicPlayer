package com.example.musicapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.ArrayList;
import android.content.ContentUris;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.PowerManager;
import android.util.Log;

public class MusicService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,MediaPlayer.OnCompletionListener{

	MediaPlayer player;
	ArrayList<Songs> songs;
	int songPosition;
	final IBinder musicBind = new MusicBinder();
	
	@Override
	public void onCreate() {
		super.onCreate();
		songPosition=0;
		player = new MediaPlayer();
		InitializeMusicPlayer();
	}
	
    public void InitializeMusicPlayer()
    {
    	player.setWakeMode(getApplicationContext(),PowerManager.PARTIAL_WAKE_LOCK);
    	player.setAudioStreamType(AudioManager.STREAM_MUSIC);
    	player.setOnPreparedListener(this);
    	player.setOnCompletionListener(this);
    	player.setOnErrorListener(this);
    }
    
    public void setList(ArrayList<Songs> theSongs)
    {
    	  songs=theSongs;
    }
    
    public class MusicBinder extends Binder {
    	  MusicService getService() 
    	  {
    	    return MusicService.this;
    	  }
    	}
    
    
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return musicBind;
	}
	
	@Override
	public boolean onUnbind(Intent intent){
	  player.stop();
	  player.release();
	  return false;
	}
	@Override
	public void onCompletion(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		mp.start();
		
	} 
	
	public void playSong(){
		player.reset();
		Songs playSong = songs.get(songPosition);
		long currentSong = playSong.getId();
		Uri trackUri = ContentUris.withAppendedId(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,currentSong);
		try
		{
			  player.setDataSource(getApplicationContext(), trackUri);
		}
		catch(Exception e)
		{
			  Log.e("MUSIC SERVICE", "Error setting data source", e);
		}
		player.prepareAsync();
	}
	
	public void setSong(int songIndex)
	{
		  songPosition=songIndex;
	}
}
