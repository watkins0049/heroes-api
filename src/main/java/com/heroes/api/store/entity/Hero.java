package com.heroes.api.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name="HERO")
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    @Id
    private String alias;
    private String name;

}
