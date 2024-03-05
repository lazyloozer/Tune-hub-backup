 
package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.SongService;

@Controller

public class SongController {
	@Autowired
	SongService SongService;
	
	//Adding multiple new Songs to Playlist using model attribute to database
	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song) {
		//checking song exits are not if exits dont add else add
		boolean songStatus=SongService.songExits(song.getName());
		if(songStatus==false) {
			SongService.addsong(song);
		
			//System.out.println("Song Added Succfully");
			return"adminhome";
		}else {
		return "newsong";
		
		}
		
		}

	
	//}
	//fetch data from database
	@PostMapping("/viewsongs")
	
	public String getsongs(Model model) {
		
		model.addAttribute("songs",SongService.getsongs() );
		return"displaysongs";
	}
	//CustomerView Songs
@PostMapping("/playsongs")
	
	public String playsongs(Model model) {
	boolean premium=true;
	if(premium) {
		
		model.addAttribute("songs",SongService.getsongs() );
		return"displaysongs";
	}else {
		return"subsciptionform";
	}
		
	}
	
	}

	
	
	
	
	
		
	
	

	


