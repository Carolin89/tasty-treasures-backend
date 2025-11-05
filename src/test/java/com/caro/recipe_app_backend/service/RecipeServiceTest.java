package com.caro.recipe_app_backend.service;

import com.caro.recipe_app_backend.dto.RecipeDTO;
import com.caro.recipe_app_backend.mapper.RecipeMapper;
import com.caro.recipe_app_backend.model.Difficulty;
import com.caro.recipe_app_backend.model.Recipe;
import com.caro.recipe_app_backend.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RecipeServiceTest {
    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    private RecipeMapper recipeMapper;

    @InjectMocks
    private RecipeService recipeService;

    private Recipe existingRecipe;
    private RecipeDTO recipeDTO;
    private RecipeDTO updatedDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        existingRecipe = new Recipe();
        existingRecipe.setId(1L);
        existingRecipe.setTitle("Old Title");
        existingRecipe.setDescription("Old Description");
        existingRecipe.setCategory("Old Category");
        existingRecipe.setDifficulty(Difficulty.EASY);
        existingRecipe.setServings(2);
        existingRecipe.setImageUrl("/assets/placeholder.jpg");

        recipeDTO = new RecipeDTO();
        recipeDTO.setId(1L);
        recipeDTO.setTitle("Pasta");
        recipeDTO.setDescription("Lecker");
        recipeDTO.setImageUrl("/assets/placeholder.jpg");

        updatedDTO = new RecipeDTO();
        updatedDTO.setTitle("New Title");
        updatedDTO.setDescription("New Description");
        updatedDTO.setCategory("New Category");
        updatedDTO.setDifficulty(Difficulty.MEDIUM);
        updatedDTO.setServings(4);
        updatedDTO.setImageUrl("/assets/placeholder.jpg");


    }

    @Test
    void getAll_ShouldReturnListOfRecipes() {
        when(recipeRepository.findAll()).thenReturn(List.of(existingRecipe));
        when(recipeMapper.toDto(existingRecipe)).thenReturn(recipeDTO);

        List<RecipeDTO> result = recipeService.getAll();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getTitle()).isEqualTo("Pasta");
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void getById_ShouldReturnRecipe_WhenExists() {
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(existingRecipe));
        when(recipeMapper.toDto(existingRecipe)).thenReturn(recipeDTO);

        RecipeDTO result = recipeService.getById(1L);

        assertThat(result.getTitle()).isEqualTo("Pasta");
        verify(recipeRepository).findById(1L);
    }

    @Test
    void getById_ShouldThrowException_WhenNotFound() {
        when(recipeRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> recipeService.getById(99L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Recipe not found with id 99");
    }

    @Test
    void create_ShouldSaveAndReturnRecipe() {
        when(recipeMapper.toEntity(any(RecipeDTO.class))).thenReturn(existingRecipe);
        when(recipeRepository.save(existingRecipe)).thenReturn(existingRecipe);
        when(recipeMapper.toDto(existingRecipe)).thenReturn(recipeDTO);

        RecipeDTO result = recipeService.create(recipeDTO);

        assertThat(result.getTitle()).isEqualTo("Pasta");
        verify(recipeRepository).save(existingRecipe);
    }

    @Test
    void delete_ShouldCallRepository_WhenExists() {
        when(recipeRepository.existsById(1L)).thenReturn(true);

        recipeService.delete(1L);

        verify(recipeRepository).deleteById(1L);
    }

    @Test
    void delete_ShouldThrow_WhenNotExists() {
        when(recipeRepository.existsById(42L)).thenReturn(false);

        assertThatThrownBy(() -> recipeService.delete(42L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Recipe not found with id 42");
    }

    @Test
    void shouldUpdateExistingRecipe() {
        // Arrange
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(existingRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(recipeMapper.toDto(any(Recipe.class))).thenReturn(updatedDTO);

        // Act
        RecipeDTO result = recipeService.update(1L, updatedDTO);

        // Assert
        assertNotNull(result);
        assertEquals("New Title", existingRecipe.getTitle());
        assertEquals("New Description", existingRecipe.getDescription());
        assertEquals("New Category", existingRecipe.getCategory());
        assertEquals(Difficulty.MEDIUM, existingRecipe.getDifficulty());
        assertEquals(4, existingRecipe.getServings());
        assertEquals("/assets/placeholder.jpg", existingRecipe.getImageUrl());

        verify(recipeRepository).findById(1L);
        verify(recipeRepository).save(existingRecipe);
        verify(recipeMapper).toDto(existingRecipe);
    }

    @Test
    void shouldThrowExceptionWhenRecipeNotFound() {
        // Arrange
        when(recipeRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> recipeService.update(999L, updatedDTO));

        assertTrue(exception.getMessage().contains("Recipe not found with id 999"));
        verify(recipeRepository, never()).save(any());
    }
}
