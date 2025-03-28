package com.sp_solutions.news_website.Controllers;

import com.sp_solutions.news_website.Entity.Category;
import com.sp_solutions.news_website.Services.CategoryService;
import com.sp_solutions.news_website.Utils.StringConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "api/v1/category")
@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Method for add category
    @PostMapping
    public ResponseEntity<String> addCategory(@RequestBody Category category){
        try{
            return categoryService.addCategory(category);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(StringConstants.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Method for get all categories
    @GetMapping
    public List<Category> getAllCategories(){
        try{
            return categoryService.getAllCategories();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
