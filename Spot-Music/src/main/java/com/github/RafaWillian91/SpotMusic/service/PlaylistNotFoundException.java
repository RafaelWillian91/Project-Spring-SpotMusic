package com.github.RafaWillian91.SpotMusic.service;

public class PlaylistNotFoundException extends RuntimeException {
    public PlaylistNotFoundException(String s) {
        super(s);
    }
}
