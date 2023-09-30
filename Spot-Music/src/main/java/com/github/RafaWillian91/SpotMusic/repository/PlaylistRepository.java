package com.github.RafaWillian91.SpotMusic.repository;

import com.github.RafaWillian91.SpotMusic.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

    @Override
    <S extends Playlist> S save(S entity);

}
