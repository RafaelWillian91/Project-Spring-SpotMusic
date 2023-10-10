package com.github.RafaWillian91.SpotMusic.controller;

import com.github.RafaWillian91.SpotMusic.model.Playlist;
import com.github.RafaWillian91.SpotMusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
    public String savePlaylist(@ModelAttribute("playlists") Playlist playlist){
        return "/playlist/add";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute ("playlists") Playlist playlist , BindingResult result, RedirectAttributes attr){


        if(result.hasErrors()){
            return "playlist/add";
        }

          playlistService.save(playlist);

          attr.addFlashAttribute("mensagem", "PlayList criada com Sucesso!");

          //Cottroller /playlist/listar is called
        return "redirect:/playlists/list";
    }

    @GetMapping("/{id}/update")
    public ModelAndView editPlaylist(@PathVariable("id") long id, ModelMap model){
        Playlist playlist = playlistService.viewData(id);
        model.addAttribute("playlists", playlist);
        return new ModelAndView("/playlist/add", model);
    }

    //HTTP routing for the method was done by supporting Spring's hidden HTTP methods.
    @PutMapping("/save")
    public String update(@Valid @ModelAttribute ("playlists") Playlist playlist , BindingResult result, RedirectAttributes attr){

        if(result.hasErrors()){
            return "playlist/add";
        }

        playlistService.save(playlist);

        attr.addFlashAttribute("mensagem", "PlayList Atualizada com Sucesso!");

        return "redirect:/playlists/list";
    }

    @GetMapping("/{id}/delete")
    public String delete (@PathVariable("id") long id ,RedirectAttributes attr){
        playlistService.delete(id);
        attr.addFlashAttribute("mensagem", "PlayList excluída com Sucesso!");
        return "redirect:/playlists/list";
    }







    }
