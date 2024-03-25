package com.example.demo.Service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class NewsService {
    private final NewsApiClient newsApiClient = new NewsApiClient("940ce1e66cce419995c62ac22010af90");
    private final CopyOnWriteArrayList<String> headlines = new CopyOnWriteArrayList<>();

    public void fetchNewsHeaders() {
        StringBuilder stringBuilder = new StringBuilder();
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q("Putin")
                        .language("en")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        for (Article article: response.getArticles()){
                            headlines.add(String.valueOf(stringBuilder.append(article.getTitle()).append(" Glory to Ukraine")));
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
    }

    public List<String> getNewsHeaders() {
        fetchNewsHeaders();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return headlines;
    }
}

