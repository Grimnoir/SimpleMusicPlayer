package com.example.musicapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SongAdapter extends BaseAdapter {
	 ArrayList<Songs> songs;
	 LayoutInflater songInf;
	@Override
	public int getCount() {
		return songs.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		LinearLayout songLayout = (LinearLayout)songInf.inflate(R.layout.songs, arg2, false);
		TextView songView = (TextView)songLayout.findViewById(R.id.song_title);
		TextView artistView = (TextView)songLayout.findViewById(R.id.song_artist);
		Songs currentSong = songs.get(position);
		
		songView.setText(currentSong.getTitle());
		artistView.setText(currentSong.getArtistname());
		
		 songLayout.setTag(position);
		 return songLayout;
	
	}
	
	public SongAdapter(Context c, ArrayList<Songs> theSongs){
		  songs=theSongs;
		  songInf=LayoutInflater.from(c);
		}
}
