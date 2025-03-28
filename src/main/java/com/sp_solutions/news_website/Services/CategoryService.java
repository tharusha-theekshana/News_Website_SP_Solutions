package com.sp_solutions.news_website.Services;

import com.sp_solutions.news_website.Entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    ResponseEntity<String> addCategory(Category category);
    List<Category> getAllCategories();
}
