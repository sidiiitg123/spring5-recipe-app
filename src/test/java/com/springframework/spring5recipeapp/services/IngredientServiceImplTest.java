package com.springframework.spring5recipeapp.services;

import com.springframework.spring5recipeapp.Repository.RecipeRepository;
import com.springframework.spring5recipeapp.Repository.UnitOfMeasureRepository;
import com.springframework.spring5recipeapp.commands.IngredientCommand;
import com.springframework.spring5recipeapp.convertors.IngredientCommandToIngredient;
import com.springframework.spring5recipeapp.convertors.IngredientToIngredientCommand;
import com.springframework.spring5recipeapp.convertors.UnitOfMeasureCommandToUnitOfMeasure;
import com.springframework.spring5recipeapp.convertors.UnitOfMeasureToUnitOfMeasureCommand;
import com.springframework.spring5recipeapp.model.Ingredient;
import com.springframework.spring5recipeapp.model.Recipe;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyLong;

public class IngredientServiceImplTest {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;


    IngredientService ingredientService;

    //init converters
    public IngredientServiceImplTest(IngredientCommandToIngredient ingredientCommandToIngredient) {
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, ingredientCommandToIngredient,
                recipeRepository, unitOfMeasureRepository);
    }

    @Test
    public void findByRecipeIdAndId() throws Exception {
    }

    @Test
    public void findByRecipeIdAndReceipeIdHappyPath() throws Exception {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(1L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        //then
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        //when
        assertEquals(Long.valueOf(3L), ingredientCommand.getId());
        assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());
    }
    @Test
    public void testDeleteById() throws Exception {
        //given
        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(3L);
        recipe.addIngredient(ingredient);
        ingredient.setRecipe(recipe);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        //when
        ingredientService.deleteById(1L, 3L);

        //then
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }


}
