package com.paulaccarvalho.appfoodapi.domain.repository;

import java.util.List;
import com.paulaccarvalho.appfoodapi.domain.model.Restaurant;

public interface RestaurantRepository {
  List<Restaurant> all();

  Restaurant byId(Long id);

  Restaurant add(Restaurant restaurant);

  void remove(Restaurant restaurant);
}
