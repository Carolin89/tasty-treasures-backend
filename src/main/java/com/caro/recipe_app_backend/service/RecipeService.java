package com.caro.recipe_app_backend.service;

import com.caro.recipe_app_backend.dto.RecipeDTO;
import com.caro.recipe_app_backend.mapper.RecipeMapper;
import com.caro.recipe_app_backend.model.Recipe;
import com.caro.recipe_app_backend.repository.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeService(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    public List<RecipeDTO> getAll() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::toDto)
                .toList();
    }

    public RecipeDTO getById(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found with id " + id));
        return recipeMapper.toDto(recipe);
    }

    public RecipeDTO create(RecipeDTO recipeDTO) {
        Recipe entity = recipeMapper.toEntity(recipeDTO);
        Recipe saved = recipeRepository.save(entity);
        return recipeMapper.toDto(saved);
    }

    public RecipeDTO update(Long id, RecipeDTO recipeDTO) {
        Recipe existing = recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found with id " + id));

        existing.setTitle(recipeDTO.getTitle());
        existing.setDescription(recipeDTO.getDescription());
        existing.setCategory(recipeDTO.getCategory());
        existing.setServings(recipeDTO.getServings());

        existing.setDifficulty(recipeDTO.getDifficulty());
        existing.setIngredients(recipeDTO.getIngredients());
        existing.setImageUrl(recipeDTO.getImageUrl());
        Recipe updated = recipeRepository.save(existing);
        return recipeMapper.toDto(updated);
    }

    public RecipeDTO partialUpdate(Long id, RecipeDTO partialDto) {
        Recipe existing = recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found with id " + id));

        if (partialDto.getTitle() != null) existing.setTitle(partialDto.getTitle());
        if (partialDto.getDescription() != null) existing.setDescription(partialDto.getDescription());
        if (partialDto.getCategory() != null) existing.setCategory(partialDto.getCategory());
        if (partialDto.getServings() != null) existing.setServings(partialDto.getServings());
        if (partialDto.getDifficulty() != null) existing.setDifficulty(partialDto.getDifficulty());
        if (partialDto.getIngredients() != null) existing.setIngredients(partialDto.getIngredients());
        if (partialDto.getImageUrl() != null) existing.setImageUrl(partialDto.getImageUrl());
        if (partialDto.getPrepTimeMinutes() != null) existing.setPrepTimeMinutes(partialDto.getPrepTimeMinutes());
        if (partialDto.getCookTimeMinutes() != null) existing.setCookTimeMinutes(partialDto.getCookTimeMinutes());

        Recipe saved = recipeRepository.save(existing);
        return recipeMapper.toDto(saved);
    }


    public void delete(Long id) {
        if (!recipeRepository.existsById(id)) {
            throw new EntityNotFoundException("Recipe not found with id " + id);
        }
        recipeRepository.deleteById(id);
    }
}