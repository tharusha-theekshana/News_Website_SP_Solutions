package com.sp_solutions.news_website.Services.Impl;

import com.sp_solutions.news_website.Entity.Category;
import com.sp_solutions.news_website.Repo.CategoryRepo;
import com.sp_solutions.news_website.Services.CategoryService;
import com.sp_solutions.news_website.Utils.StringConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    // Service for add category
    @Override
    public ResponseEntity<String> addCategory(Category category) {
        try{
            if (category.getCategoryName() == null || category.getCategoryName().isEmpty()){
                return new ResponseEntity(StringConstants.NOT_FOUND_CATEGORY,HttpStatus.BAD_REQUEST);
            }
            categoryRepo.save(category);
            return new ResponseEntity(StringConstants.ADD_CATEGORY,HttpStatus.CREATED);


        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(StringConstants.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Service for get all categories
    @Override
    public List<Category> getAllCategories() {
        try{
            List<Category> categoryList = categoryRepo.findAll();
            return categoryList;

        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
