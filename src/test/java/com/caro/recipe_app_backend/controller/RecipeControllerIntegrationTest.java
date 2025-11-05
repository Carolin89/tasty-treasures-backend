package com.caro.recipe_app_backend.controller;

import com.caro.recipe_app_backend.dto.RecipeDTO;
import com.caro.recipe_app_backend.model.Difficulty;
import com.caro.recipe_app_backend.model.Recipe;
import com.caro.recipe_app_backend.repository.RecipeRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
    @AutoConfigureMockMvc(addFilters = false)
    @Transactional
    class RecipeControllerIntegrationTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private RecipeRepository recipeRepository;

        @Autowired
        private ObjectMapper objectMapper;
        @Test
        void shouldReturnListOfRecipes() throws Exception {
            mockMvc.perform(get("/api/recipes"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$").isArray());
        }

        @Test
        void shouldReturnSingleRecipeById() throws Exception {
            Recipe recipe = new Recipe();
            recipe.setTitle("Tiramisu");
            recipe.setDescription("Classic Italian dessert");
            recipe.setCategory("Dessert");
            recipe.setServings(4);
            recipe.setPrepTimeMinutes(20);
            recipe.setCookTimeMinutes(0);
            recipe.setDifficulty(Difficulty.MEDIUM);
            recipe.setIngredients(List.of("Mascarpone", "Coffee", "Eggs"));
            recipe.setImageUrl("assets/placeholder.png");
            recipeRepository.save(recipe);

            mockMvc.perform(get("/api/recipes/" + recipe.getId()))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(recipe.getId()))
                    .andExpect(jsonPath("$.title").value("Tiramisu"));}

        @Test
        void shouldUpdateExistingRecipe() throws Exception {
            // given: ein existierendes Rezept in der DB
            Recipe existingRecipe = new Recipe();
            existingRecipe.setTitle("Old Title");
            existingRecipe.setDescription("Old Description");
            existingRecipe.setCategory("Dessert");
            existingRecipe.setServings(2);
            existingRecipe.setCookTimeMinutes(30);
            existingRecipe.setPrepTimeMinutes(10);
            existingRecipe.setDifficulty(Difficulty.EASY);
            existingRecipe.setIngredients(List.of("Sugar", "Milk"));
            existingRecipe.setImageUrl("assets/placeholder.jpg");

            existingRecipe = recipeRepository.save(existingRecipe);

            // and: das aktualisierte DTO
            RecipeDTO updatedDto = new RecipeDTO();
            updatedDto.setId(existingRecipe.getId());
            updatedDto.setTitle("New Title");
            updatedDto.setDescription("Updated Description");
            updatedDto.setCookTimeMinutes(20);
            updatedDto.setPrepTimeMinutes(40);
            updatedDto.setServings(4);
            updatedDto.setCategory("Main");
            updatedDto.setDifficulty(Difficulty.MEDIUM);
            updatedDto.setIngredients(List.of("Flour", "Eggs"));
            updatedDto.setImageUrl("/assets/placeholder.jpg");

            String json = objectMapper.writeValueAsString(updatedDto);

            // when & then
            mockMvc.perform(put("/api/recipes/{id}", existingRecipe.getId())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(existingRecipe.getId()))
                    .andExpect(jsonPath("$.title").value("New Title"))
                    .andExpect(jsonPath("$.description").value("Updated Description"))
                    .andExpect(jsonPath("$.category").value("Main"))
                    .andExpect(jsonPath("$.servings").value(4))
                    .andExpect(jsonPath("$.difficulty").value(Difficulty.MEDIUM.getLabel()))
                    .andExpect(jsonPath("$.ingredients[0]").value("Flour"))
                    .andExpect(jsonPath("$.ingredients[1]").value("Eggs"))
                    .andExpect(jsonPath("$.imageUrl").value("/assets/placeholder.jpg"));
            // verify: DB wurde wirklich geändert
            Recipe updatedRecipe = recipeRepository.findById(existingRecipe.getId()).orElseThrow();
            assertEquals("New Title", updatedRecipe.getTitle());
            assertEquals("Updated Description", updatedRecipe.getDescription());
            assertEquals("Main", updatedRecipe.getCategory());
            assertEquals(4, updatedRecipe.getServings());
            assertEquals(Difficulty.MEDIUM, updatedRecipe.getDifficulty());
            assertEquals(List.of("Flour", "Eggs"), updatedRecipe.getIngredients());
            assertEquals("/assets/placeholder.jpg", updatedRecipe.getImageUrl());
        }


    }
