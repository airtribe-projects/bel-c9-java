package org.airtribe.AsyncApiApplication.service;

import org.airtribe.AsyncApiApplication.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class ApiService {

  public static String URL = "https://dummyjson.com/products";

  @Autowired
  public RestTemplate _restTemplate;

  @Autowired
  public WebClient _webClient;

  public String clientHello() {
    String result = _restTemplate.getForObject("http://localhost:8080/hello", String.class);
    System.out.println(result);
    return result;
  }

  public Result getProducts() {
    Result result = _restTemplate.getForObject(URL, Result.class);
    System.out.println(result);

    for(int i=0;i<100;i++) {
      System.out.println("Doing some work in the foreground");
    }

    return result;
  }

  public Mono<Result> getProductsAsync() {
    long startTime = System.currentTimeMillis();

    Mono<Result> result = _webClient.get()
        .uri(URL)
        .retrieve()
        .bodyToMono(Result.class)
        .doFinally(signalType -> {
          long endTime = System.currentTimeMillis();
          System.out.println("Time taken: " + (endTime - startTime));

          System.out.println("Received the response");
        }).doFirst(() -> {
          System.out.println("Making the async call");
        });

    long endTime = System.currentTimeMillis();
    System.out.println("Time taken outside: " + (endTime - startTime));

    for(int i=0;i<100;i++) {
      System.out.println("Doing some work in the foreground");
    }
    return result;
  }

  public Result getProductsSyncWebClient() {
    long startTime = System.currentTimeMillis();

    Result result = _webClient.get()
        .uri(URL)
        .retrieve()
        .bodyToMono(Result.class)
        .block();

    long endTime = System.currentTimeMillis();
    System.out.println("Time taken outside: " + (endTime - startTime));

    for(int i=0;i<100;i++) {
      System.out.println("Doing some work in the foreground");
    }
    return result;
  }
}
