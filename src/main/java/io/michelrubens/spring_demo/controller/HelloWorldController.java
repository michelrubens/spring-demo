package io.michelrubens.spring_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.michelrubens.spring_demo.domain.User;
import io.michelrubens.spring_demo.exceptions.ResourceNotFoundException;
import io.michelrubens.spring_demo.service.HelloWorldService;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

  @Autowired
  private HelloWorldService helloWorldService;

  // GET /hello-world
  @GetMapping
  public String helloWorld() {
    return helloWorldService.helloWorld("Michel");
  }

  // POST /hello-world/{id}
  @PostMapping("/{id}")
  public String helloWorldPost(@PathVariable String id,
      @RequestParam(value = "filter", defaultValue = "") String filter, @RequestBody User body) {
    if ("0".equals(id)) {
      throw new ResourceNotFoundException("Usuário com ID 0 não foi encontrado no sistema.");
    }
    return "Hello world " + body.getName() + " " + id + " " + filter;
  }

}
