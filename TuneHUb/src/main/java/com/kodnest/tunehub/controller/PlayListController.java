package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.PlayListService;
import com.kodnest.tunehub.service.SongService;


@Controller
public class PlayListController {
	@Autowired
	SongService SongService;
	@Autowired
	PlayListService PlayListService;
	//create playlist and getsongs in checklist to select songs
	@PostMapping("/createplaylists")
	
	 public String createPlaylists(Model model) {
		

			List<Song> songList=SongService.getsongs();
			model.addAttribute("songs", songList);
			return"createplaylists";
		}
	//adding songs to playlist
	
	@PostMapping("/addplaylist")
	 public String addplaylist(@ModelAttribute Playlist playlist) {
		//duplicate songs are not add in playlist
		boolean duplicate=PlayListService.songExits(playlist.getName());
		if(duplicate==false) {
		
		//updating playlist table
		PlayListService.addplaylist(playlist);
		//updating the song table
		List<Song>songList=playlist.getSongs();
		for (Song s : songList) {
			s.getPlaylist().add(playlist);
			
			SongService.updateSong(s);
			
		}
		
		return "adminhome";
		
	}else {
		return "adminhome";
	}
	}
	//get playlist songs by checking Premium
	@PostMapping("/viewplaylists")
	public String viewplaylists(Model model) {
		List<Playlist> getplaylist=PlayListService.getplaylist();
		boolean premium=true;
		if(premium) {
			model.addAttribute("playlists",getplaylist);
		
		return "viewplaylists";
		
	}else {
		return "subsciptionform";
	}
	}
}
	
	
	


