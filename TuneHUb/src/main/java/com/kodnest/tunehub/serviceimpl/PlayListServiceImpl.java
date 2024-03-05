package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.repository.PlayListRepositiory;
import com.kodnest.tunehub.service.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService  {
	@Autowired
	PlayListRepositiory PlayListRepositiory;
	
	//adding songs to playlist and saving in the database
	public void addplaylist(Playlist playlist) {
		PlayListRepositiory.save(playlist);
		
	}

	//get playlist songs by checking Premium
	public List<Playlist> getplaylist() {
		// TODO Auto-generated method stub
		return PlayListRepositiory.findAll();
	}

//checking duplicate songs if exits dont add
	public boolean songExits(String name) {
		Playlist playlist1= PlayListRepositiory.findByName(name);
		if(playlist1==null) {
		

		return false;
	}
	else {
		return true;
	}
	
	}

}
