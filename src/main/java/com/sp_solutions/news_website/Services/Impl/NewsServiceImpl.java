package com.sp_solutions.news_website.Services.Impl;

import com.sp_solutions.news_website.Entity.News;
import com.sp_solutions.news_website.Repo.NewsRepo;
import com.sp_solutions.news_website.Services.NewsService;
import com.sp_solutions.news_website.Utils.StringConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private NewsRepo newsRepo;

    public NewsServiceImpl(NewsRepo newsRepo) {
        this.newsRepo = newsRepo;
    }


    // Service method for get all news
    @Override
    public List<News> getAllNews() {
        try{
            List<News> newsList = newsRepo.findAll();
            return newsList;

        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Service method for add news
    @Override
    public ResponseEntity<String> addNews(News news) {
        try {
            if (news.getNewsTitle() == null || news.getNewsTitle().isEmpty() || news.getDescription() == null || news.getDescription().isEmpty() || news.getCategorySet().isEmpty()) {
                return new ResponseEntity(StringConstants.NOT_FOUND_REQUIRED_NEWS_DATA, HttpStatus.BAD_REQUEST);
            }

            newsRepo.save(news);
            return new ResponseEntity(StringConstants.ADD_NEWS,HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(StringConstants.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
