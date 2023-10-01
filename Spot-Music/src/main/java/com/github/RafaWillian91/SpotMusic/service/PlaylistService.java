package com.github.RafaWillian91.SpotMusic.service;



import com.github.RafaWillian91.SpotMusic.model.Playlist;
import com.github.RafaWillian91.SpotMusic.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;


    public List<Playlist> listAll(){
        List<Playlist> listAll = playlistRepository.findAll();
        if(listAll.isEmpty()){
            return null;
        }
        return listAll;
    }




}
