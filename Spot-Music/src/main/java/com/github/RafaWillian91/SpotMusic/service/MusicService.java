package com.github.RafaWillian91.SpotMusic.service;

import com.github.RafaWillian91.SpotMusic.model.Music;
import com.github.RafaWillian91.SpotMusic.model.Playlist;
import com.github.RafaWillian91.SpotMusic.repository.MusicRepository;
import com.github.RafaWillian91.SpotMusic.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class MusicService {

    @Autowired
    MusicRepository musicRepository;
    @Autowired
    PlaylistRepository playlistRepository;

    public List<Music> listMusic(long playlistId){
        Optional<Playlist> playlist = playlistRepository.findById(playlistId);
        return playlist.get().getListMusic();
    }

    public void save(Music music, long playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);

        if(playlist != null){
            music.setPlaylists(playlist);
            musicRepository.save(music);
        }else{
            throw new PlaylistNotFoundException("A Playlist com o ID especificado não foi encontrada");
        }

    }


    public Music viewData(long idMusic){
        return musicRepository.getReferenceById(idMusic);
    }

    public void delete(long musicId){
        musicRepository.deleteById(musicId);
    }

}
