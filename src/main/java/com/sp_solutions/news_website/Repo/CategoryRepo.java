package com.sp_solutions.news_website.Repo;

import com.sp_solutions.news_website.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
}
