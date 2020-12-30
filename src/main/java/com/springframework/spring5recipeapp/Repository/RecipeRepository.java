package com.springframework.spring5recipeapp.Repository;

import com.springframework.spring5recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
