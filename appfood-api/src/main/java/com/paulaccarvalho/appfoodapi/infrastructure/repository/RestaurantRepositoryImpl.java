package com.paulaccarvalho.appfoodapi.infrastructure.repository;

import java.util.List;
import org.springframework.stereotype.Component;
import com.paulaccarvalho.appfoodapi.domain.model.Restaurant;
import com.paulaccarvalho.appfoodapi.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Restaurant> all() {
    return manager.createQuery("from restaurant", Restaurant.class).getResultList();
  }

  @Override
  public Restaurant byId(Long id) {
    return manager.find(Restaurant.class, id);
  }

  @Transactional
  @Override
  public Restaurant add(Restaurant restaurant) {
    return manager.merge(restaurant);
  }

  @Transactional
  @Override
  public void remove(Restaurant restaurant) {
    restaurant = byId(restaurant.getId());
    manager.remove(restaurant);
  }
}
