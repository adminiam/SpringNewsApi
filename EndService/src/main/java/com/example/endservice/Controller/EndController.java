package com.example.endservice.Controller;

import com.example.endservice.Service.EndService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EndController {
    private EndService endService;

    public EndController(EndService endService) {
        this.endService = endService;
    }

    @GetMapping("/news")
    public ResponseEntity<List<String>> getNews(){
        return endService.getNews();
    }
}
