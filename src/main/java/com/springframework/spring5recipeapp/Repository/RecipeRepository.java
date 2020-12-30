package com.springframework.spring5recipeapp.Repository;

import com.springframework.spring5recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
