package com.sp_solutions.news_website.Controllers;

import com.sp_solutions.news_website.Entity.News;
import com.sp_solutions.news_website.Services.NewsService;
import com.sp_solutions.news_website.Utils.StringConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/news")
public class NewsController {

    private NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // Get all news
    @GetMapping
    public List<News> getAllNews(){
        try{
            return newsService.getAllNews();

        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Method for add news
    @PostMapping
    public ResponseEntity<String> addNews(@RequestBody News news){
        try{
            return newsService.addNews(news);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(StringConstants.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
