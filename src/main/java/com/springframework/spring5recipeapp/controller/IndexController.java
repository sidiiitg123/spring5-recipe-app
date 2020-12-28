package com.springframework.spring5recipeapp.controller;

import com.springframework.spring5recipeapp.Repository.CategoryRepository;
import com.springframework.spring5recipeapp.Repository.UnitOfMeasureRepository;
import com.springframework.spring5recipeapp.model.Category;
import com.springframework.spring5recipeapp.model.UnitOfMeasure;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {


    private  CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String sayHello(){

        Optional<Category> ct= categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> um=unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("cat id is" + ct.get().getId() );
        System.out.println("uom id is" + um.get().getId() );
        System.out.println("asddasdsd");
        return "index";
    }
}
