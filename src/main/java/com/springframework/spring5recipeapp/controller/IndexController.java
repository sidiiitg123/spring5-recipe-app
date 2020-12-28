package com.springframework.spring5recipeapp.controller;

import com.springframework.spring5recipeapp.Repository.CategoryRepository;
import com.springframework.spring5recipeapp.Repository.UnitOfMeasureRepository;
import com.springframework.spring5recipeapp.model.Category;
import com.springframework.spring5recipeapp.model.UnitOfMeasure;
import com.springframework.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
