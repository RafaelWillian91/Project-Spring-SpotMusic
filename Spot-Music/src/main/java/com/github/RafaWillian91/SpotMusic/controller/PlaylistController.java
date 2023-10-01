package com.github.RafaWillian91.SpotMusic.controller;

import com.github.RafaWillian91.SpotMusic.model.Playlist;
import com.github.RafaWillian91.SpotMusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

    @GetMapping("/register")
    public String savePlaylist(@ModelAttribute("playlist") Playlist playlist){
        return "/playlist/add";
    }

    public String save(@Valid @ModelAttribute ("playlist") Playlist playlist, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "/playlist/add";
        }

          playlistService.save(playlist);

          attr.addAttribute("mensagem", "PlayList criada com Sucesso!");

        return "redirect:/playlist/listar";
    }
}
