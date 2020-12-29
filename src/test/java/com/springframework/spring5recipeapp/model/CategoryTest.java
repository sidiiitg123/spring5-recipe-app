package com.springframework.spring5recipeapp.model;

import org.junit.Before;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category=new Category();
    }

    @org.junit.Test
    public void getId() {
        Long idVal=4L;
        category.setId(idVal);
        assertEquals(idVal,category.getId());
    }

    @org.junit.Test
    public void getDescription() {
    }

    @org.junit.Test
    public void getRecipes() {
    }
}
