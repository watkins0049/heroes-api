package com.heroes.api.service;

import java.util.List;

import com.heroes.api.store.entity.Hero;
import com.heroes.api.store.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository repository;

    public List<String> getAllHeroes() {
        return repository.findAll()
                .stream()
                .map(Hero::getAlias)
                .toList();
    }

}
