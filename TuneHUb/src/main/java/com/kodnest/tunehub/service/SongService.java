package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.Song;

public interface SongService {

	public String addsong(Song song);

	public List<Song> getsongs();


	public List<Song> getCustomersongs();

	//public boolean songExits(Song song);

	public boolean songExits(String name);

	public void updateSong(Song s);


}
