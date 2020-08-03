package com.adorsys.demo.controller;

import com.adorsys.demo.entity.ToDo;
import com.adorsys.demo.service.RestClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {

  @Autowired
  RestClient restClient;

  @GetMapping("/todos")
  public List<ToDo> getToDos() {
    return restClient.getToDos();
  }

}
