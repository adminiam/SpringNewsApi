package com.example.endservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EndService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<List<String>> getNews() {
        ParameterizedTypeReference<List<String>> responseType = new ParameterizedTypeReference<>() {};


        ResponseEntity<List<String>> responseEntity = restTemplate.exchange("http://localhost:8080/getNews", HttpMethod.GET, null, responseType);

        return responseEntity;
    }
}
