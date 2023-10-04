package com.github.RafaWillian91.SpotMusic.repository;

import com.github.RafaWillian91.SpotMusic.model.*;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{


}
