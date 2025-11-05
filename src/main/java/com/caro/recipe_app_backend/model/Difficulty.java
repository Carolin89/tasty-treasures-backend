package com.caro.recipe_app_backend.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Difficulty {
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard");

    private final String label;

    Difficulty(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}