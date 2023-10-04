package com.github.RafaWillian91.SpotMusic.repository;

import com.github.RafaWillian91.SpotMusic.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {


}
