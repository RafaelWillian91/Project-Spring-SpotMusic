package com.github.RafaWillian91.SpotMusic.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 60, message = "O campo deve ser maior que 1 e no máximo 60 caracteres!")
    @Column(nullable = false, length = 60)
    @NotEmpty(message = "O campo 'nome' não pode estar vazio")
    private String name;
    @NotBlank
    @Column(nullable = false)
    @NotEmpty(message = "O campo 'nome' não pode estar vazio")
    @Size(min = 2, max = 60, message = "O campo deve ser maior que 1 e no máximo 60 caracteres!")
    private String description;
    @OneToMany(mappedBy = "playlists", cascade = CascadeType.ALL)
    private List<Music> listMusic;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Music> getListMusic() {
        return listMusic;
    }

    public void setListMusic(List<Music> listMusic) {
        this.listMusic = listMusic;
    }
}
