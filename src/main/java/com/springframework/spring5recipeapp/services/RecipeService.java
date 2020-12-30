package com.springframework.spring5recipeapp.services;


import com.springframework.spring5recipeapp.commands.RecipeCommand;
import com.springframework.spring5recipeapp.model.Recipe;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
