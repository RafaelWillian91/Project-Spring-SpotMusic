package com.github.RafaWillian91.SpotMusic.controller;

import com.github.RafaWillian91.SpotMusic.model.Playlist;
import com.github.RafaWillian91.SpotMusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("playlists")
public class PlaylistController {

    //dependency injection at the time of creating the controller
    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/list")
    public String listar(Model model) {
        model.addAttribute("playlists", playlistService.listAll());
        return "/playlist/list";
    }

    @GetMapping("/save")
    public void savePlaylist(){

    }

}
