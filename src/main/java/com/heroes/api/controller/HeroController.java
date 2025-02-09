package com.heroes.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.heroes.api.service.HeroService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;

    @GetMapping("/api/heroes")
    public ResponseEntity<List<String>> heroes() {
        return ResponseEntity.ok(heroService.getAllHeroes());
    }

}
