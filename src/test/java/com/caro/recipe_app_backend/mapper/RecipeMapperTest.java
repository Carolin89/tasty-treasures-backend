package com.caro.recipe_app_backend.mapper;

import com.caro.recipe_app_backend.dto.RecipeDTO;
import com.caro.recipe_app_backend.model.Difficulty;
import com.caro.recipe_app_backend.model.Recipe;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeMapperTest {
    private final RecipeMapper mapper = new RecipeMapper();

    @Test
    void shouldMapEntityToDto() {
        // given
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setTitle("Spaghetti Carbonara");
        recipe.setDescription("Klassisches italienisches Gericht");
        recipe.setCategory("Pasta");
        recipe.setServings(2);
        recipe.setDifficulty(Difficulty.MEDIUM);
        recipe.setIngredients(List.of("Spaghetti", "Speck", "Eier"));
        recipe.setImageUrl("/assets/placeholder.jpg");

        // when
        RecipeDTO dto = mapper.toDto(recipe);

        // then
        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Spaghetti Carbonara", dto.getTitle());
        assertEquals("Klassisches italienisches Gericht", dto.getDescription());
        assertEquals("Pasta", dto.getCategory());
        assertEquals(2, dto.getServings());
        assertEquals(Difficulty.MEDIUM, dto.getDifficulty());
        assertEquals(List.of("Spaghetti", "Speck", "Eier"), dto.getIngredients());
    }

    @Test
    void shouldMapDtoToEntity() {
        // given
        RecipeDTO dto = new RecipeDTO();
        dto.setId(10L);
        dto.setTitle("Gemüsepfanne");
        dto.setDescription("Leichte Pfanne mit Sojasauce");
        dto.setCategory("Vegetarisch");
        dto.setServings(3);
        dto.setDifficulty(Difficulty.EASY);
        dto.setIngredients(List.of("Paprika", "Zucchini", "Sojasauce"));
        dto.setImageUrl("/assets/placeholder.jpg");

        // when
        Recipe entity = mapper.toEntity(dto);

        // then
        assertNotNull(entity);
        assertEquals(10L, entity.getId());
        assertEquals("Gemüsepfanne", entity.getTitle());
        assertEquals("Leichte Pfanne mit Sojasauce", entity.getDescription());
        assertEquals("Vegetarisch", entity.getCategory());
        assertEquals(3, entity.getServings());
        assertEquals(Difficulty.EASY, entity.getDifficulty());
        assertEquals(List.of("Paprika", "Zucchini", "Sojasauce"), entity.getIngredients());
        assertEquals("/assets/placeholder.jpg", entity.getImageUrl() );
    }

    @Test
    void shouldHandleNullValuesGracefully() {
        // when
        RecipeDTO dto = mapper.toDto(null);
        Recipe entity = mapper.toEntity(null);

        // then
        assertNull(dto);
        assertNull(entity);
    }

}
