package com.github.RafaWillian91.SpotMusic.repository;

import com.github.RafaWillian91.SpotMusic.model.*;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>{


}
