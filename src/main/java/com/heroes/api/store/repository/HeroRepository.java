package com.heroes.api.store.repository;

import com.heroes.api.store.entity.Hero;
import org.springframework.data.repository.ListCrudRepository;

public interface HeroRepository extends ListCrudRepository<Hero, String> {
}
