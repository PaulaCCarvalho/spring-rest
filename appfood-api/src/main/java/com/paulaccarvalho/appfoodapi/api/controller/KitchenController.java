package com.paulaccarvalho.appfoodapi.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.paulaccarvalho.appfoodapi.domain.model.Kitchen;
import com.paulaccarvalho.appfoodapi.domain.repository.KitchenRepository;

@RestController
@RequestMapping(value = "/kitchens")
public class KitchenController {

  @Autowired
  private KitchenRepository kitchenRepository;

  @GetMapping
  public List<Kitchen> list() {
    return kitchenRepository.list();
  }

  @GetMapping("/{kitchenId}")
  public Kitchen find(@PathVariable("kitchenId") Long id) {
    return kitchenRepository.find(id);
  }
}
