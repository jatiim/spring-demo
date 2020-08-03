package com.adorsys.demo.service;

import com.adorsys.demo.entity.ToDo;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientImpl implements RestClient {

  @Autowired
  RestTemplate restTemplate;

  @Override
  public List<ToDo> getToDos() {
    ToDo[] toDos = restTemplate
        .getForObject("https://jsonplaceholder.typicode.com/todos", ToDo[].class);
    return Arrays.stream(toDos).map(toDo -> {
      toDo.setTitle("Changed title.");
      return toDo;
    }).collect(Collectors.toList());
  }
}
