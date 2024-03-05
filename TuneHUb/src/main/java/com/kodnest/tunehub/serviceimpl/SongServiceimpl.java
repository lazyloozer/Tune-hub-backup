package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepositiory;
import com.kodnest.tunehub.service.SongService;
@Service
public class SongServiceimpl implements SongService {
	
	@Autowired
	SongRepositiory SongRepositiory;
	//adding songs to database
	public String addsong(Song song) {
		SongRepositiory.save(song);
		return "Song Added SuccesFully";
		
	}
//feteching songs for database
	public List<Song> getsongs() {
		
		return SongRepositiory.findAll(); 
	}
	//public boolean songExits(Song song) {
		//return true;
	//}
	
	public boolean songExits(String name) {
		Song song=SongRepositiory.findByName(name);
		if(song==null) {
			
		//if(SongRepositiory.findByName(name)!=null) {
     		return false;
			
		}else {
		return true;
	
		}
	}
	
	
	public List<Song> getCustomersongs() {
		return SongRepositiory.findAll();
	}
	@Override
	public void updateSong(Song s) {
		SongRepositiory.save(s);

		
	}
	
	
	
	
	
	
	
	
}
//Song song=SongRepositiory.findByName(name);
//if(song==full)[
//return false;
//}else{
//return true;
//
