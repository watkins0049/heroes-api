package com.heroes.api.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
@Table(name="HERO")
@RequiredArgsConstructor
public class Hero {

    @Id
    private final String alias;
    private final String name;

}
