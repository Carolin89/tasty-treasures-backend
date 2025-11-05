package com.caro.recipe_app_backend.controller;

import com.caro.recipe_app_backend.dto.RecipeDTO;
import com.caro.recipe_app_backend.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<RecipeDTO> getAll() {
        return recipeService.getAll();
    }

    @GetMapping("/{id}")
    public RecipeDTO getById(@PathVariable Long id) {
        return recipeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDTO create(@Valid @RequestBody RecipeDTO recipeDTO) {
        System.out.println("📥 POST /api/recipes hit: " + recipeDTO);
        return recipeService.create(recipeDTO);
    }

    @PutMapping("/{id}")
    public RecipeDTO update(@PathVariable Long id, @Valid @RequestBody RecipeDTO recipeDTO) {
        return recipeService.update(id, recipeDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecipeDTO> partialUpdate(@PathVariable Long id, @RequestBody RecipeDTO partialDto) {
        RecipeDTO updated = recipeService.partialUpdate(id, partialDto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recipeService.delete(id);
    }
}
