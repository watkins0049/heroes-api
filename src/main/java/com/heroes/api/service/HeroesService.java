package com.heroes.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HeroesService {

    public List<String> getAllHeroes() {
        return List.of("Superman", "Batman");
    }

}
