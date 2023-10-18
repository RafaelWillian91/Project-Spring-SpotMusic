package com.github.RafaWillian91.SpotMusic.controller;

import com.github.RafaWillian91.SpotMusic.model.Music;
import com.github.RafaWillian91.SpotMusic.model.Playlist;
import com.github.RafaWillian91.SpotMusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.model.IModel;

import javax.validation.Valid;

@Controller
@RequestMapping("playlist/{playlistID}/musics")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping("/listMusic")
    public String listar(@PathVariable("playlistID") long playlistID, Model model) {
        model.addAttribute("music", musicService.listMusic(playlistID));
        model.addAttribute("playlistID", playlistID);
        return "music/list";
    }

    @GetMapping("/registerMusic")//passando um model vazio
    public String register(@ModelAttribute ("music") Music music, @PathVariable ("playlistID") long playListid){
            return "music/add";
    }

    @PostMapping("/saveMusic")
    public String save(@PathVariable("playlistID") long playlistId, @Valid @ModelAttribute("music") Music music, BindingResult
            result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/music/add";
        }

        musicService.save(music, playlistId);

        attr.addFlashAttribute("mensagem", "Musica criada com Sucesso!");

        //Cottroller /playlist/listar is called
        return "redirect:/playlist/" + playlistId + "/musics/listMusic";
    }

    @GetMapping("/{id}/updateMusic")
    public ModelAndView editPlaylist(@PathVariable("id") long id,@PathVariable("playlistID") long playlistID, ModelMap model){
        Music music = musicService.viewData(id);
        model.addAttribute("music", music);
        return new ModelAndView("/music/add");
    }

    @PutMapping("/saveMusic")
    public String update(@Valid @ModelAttribute ("music") Music music, @PathVariable("playlistID") long playlistID , BindingResult result, RedirectAttributes attr){

        if(result.hasErrors()){
            return "music/add";
        }

        musicService.save(music, playlistID);

        attr.addFlashAttribute("mensagem", "Musica Atualizada com Sucesso!");

        return "redirect:/playlist/"+ playlistID + "/musics/listMusic";
    }


    @GetMapping("{musicId}/remove")
    public String remove(@PathVariable ("playlistID") long playlistId, @PathVariable("musicId")
    long musicaId, RedirectAttributes attr){
        musicService.delete(musicaId);
        attr.addFlashAttribute("mensagem",
                "Música excluída com sucesso.");
        return "redirect:/playlist/" + playlistId + "/musics/listMusic";
    }



}