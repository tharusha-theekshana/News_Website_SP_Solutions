package com.sp_solutions.news_website.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String newsTitle;

    private String description;

    @ManyToMany(mappedBy = "news")
    @JoinTable(name = "news_category", joinColumns = @JoinColumn(name = "news_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categorySet = new HashSet<>();
}
