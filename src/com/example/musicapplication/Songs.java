package com.example.musicapplication;

public class Songs {
	String artistname,title;
	long id;
	
	public Songs(long sID, String sTitle, String sArtist) {
		  id=sID;
		  title=sTitle;
		  artistname=sArtist;
		}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
