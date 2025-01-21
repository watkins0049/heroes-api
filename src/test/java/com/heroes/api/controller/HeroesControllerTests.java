package com.heroes.api.controller;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroes.api.service.HeroesService;

@DisplayName("class: HeroesController")
public class HeroesControllerTests {

    private HeroesService heroesService;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach() {
        heroesService = mock(HeroesService.class);
        HeroesController heroesController = new HeroesController(heroesService);
        mockMvc = MockMvcBuilders.standaloneSetup(heroesController).build();
    }

    @Nested
    @DisplayName("function: heroes()")
    class HeroesFunction {

        @Nested
        @DisplayName("When a call to get all heroes is made then it")
        class WhenACallToGetAllHeroesIsMade {

            private ResultActions results;
            private List<String> heroes;

            @BeforeEach
            void beforeEach() throws Exception {
                heroes = List.of("Batman", "Superman");
                doReturn(heroes).when(heroesService).getAllHeroes();
                results = mockMvc.perform(get("/heroes"));
            }

            @Test
            @DisplayName("should return an OK response")
            void shouldReturnOKResponse() throws Exception {
                results.andExpect(status().isOk());
            }

            @Test
            @DisplayName("should return a list of heroes")
            void itShouldReturnAListOfHeroes()
                    throws UnsupportedEncodingException, JsonMappingException, JsonProcessingException {
                ObjectMapper mapper = new ObjectMapper();
                List<String> responseHeroes = mapper.readValue(results.andReturn().getResponse().getContentAsString(),
                        new TypeReference<List<String>>() {
                        });
                assertThat(responseHeroes).isEqualTo(heroes);
            }
        }
    }

}
