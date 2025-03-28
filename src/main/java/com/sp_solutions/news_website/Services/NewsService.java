package com.sp_solutions.news_website.Services;

import com.sp_solutions.news_website.Entity.News;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewsService {
    List<News> getAllNews();
    ResponseEntity<String> addNews(News news);


}
