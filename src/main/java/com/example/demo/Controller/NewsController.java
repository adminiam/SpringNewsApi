package com.example.demo.Controller;


import com.example.demo.Service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class NewsController {
    private NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/getNews")
    public ResponseEntity<List<String>> getHeadlines() {
        return ResponseEntity.ok(newsService.getNewsHeaders());
    }
}
