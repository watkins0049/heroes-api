package com.heroes.api.service;

import com.heroes.api.store.entity.Hero;
import com.heroes.api.store.repository.HeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("class: HeroService")
public class HeroServiceTests {

    private HeroService service;
    private HeroRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = mock(HeroRepository.class);
        service = new HeroService(repository);
    }

    @Nested
    @DisplayName("function: getAllHeroes()")
    class GetAllHeroesFunction {
        @Nested
        @DisplayName("WHEN all heroes are retrieved" +
                "THEN it")
        class WhneAllHeroesAreRetrieved {

            private List<String> heroes;

            @BeforeEach
            void beforeEach() {
                doReturn(List.of(
                        new Hero("Wonder Woman", "Diana Prince"),
                        new Hero("Batman", "Bruce Wayne")))
                        .when(repository)
                        .findAll();

                heroes = service.getAllHeroes();
            }

            @Test
            @DisplayName("should get all heroes")
            void shouldGetAlHeroesFromRepository() {
                verify(repository).findAll();
            }

            @Test
            @DisplayName("should return the aliases of all the heroes")
            void shouldReturnAliases() {
                assertThat(heroes).isEqualTo(List.of("Wonder Woman", "Batman"));
            }
        }
    }

}
