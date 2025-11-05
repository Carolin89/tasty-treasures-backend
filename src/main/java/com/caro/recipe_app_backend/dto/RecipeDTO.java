package com.caro.recipe_app_backend.dto;
import com.caro.recipe_app_backend.model.Difficulty;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class RecipeDTO {
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 2000, message = "Description must not exceed 2000 characters")
    private String description;

    @NotBlank(message = "Category is required")
    private String category;

    @Size(max = 500)
    private String imageUrl;

    @Min(value = 1, message = "Servings must be greater than 0")
    private Integer servings;

    @Min(value = 0, message = "Preparation time must be >= 0")
    private Integer prepTimeMinutes;

    @Min(value = 0, message = "Cooking time must be >= 0")
    private Integer cookTimeMinutes;


    @NotNull(message = "Difficulty must be specified")
    private Difficulty difficulty;

    @NotEmpty(message = "At least one ingredient is required")
    private List<@NotBlank(message = "Ingredient cannot be blank")  String> ingredients;
}
