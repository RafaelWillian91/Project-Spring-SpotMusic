package com.github.RafaWillian91.SpotMusic.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "musics")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 60)
    @Column(nullable = false, length = 50)
    private String title;
    @NotBlank
    @Size(min = 2, max = 60)
    @Column(nullable = false, length = 50)
    private String band;
    @Range(min = 0, max = 10)
    @Column(nullable = false)
    private int score;
    @ManyToOne
    @JoinColumn(name = "id_playlists_fk")
    private Playlist playlists;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPlaylists(Playlist playlists) {
        this.playlists = playlists;
    }

    public Playlist getPlaylists() {
        return playlists;
    }
}
