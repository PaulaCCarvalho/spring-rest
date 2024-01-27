package com.paulaccarvalho.appfoodapi.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.paulaccarvalho.appfoodapi.domain.model.City;
import com.paulaccarvalho.appfoodapi.domain.repository.CityRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class CityRepositoryImpl implements CityRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<City> all() {
    return manager.createQuery("from city", City.class).getResultList();
  }

  @Override
  public City byId(Long id) {
    return manager.find(City.class, id);
  }

  @Transactional
  @Override
  public City add(City city) {
    return manager.merge(city);
  }

  @Transactional
  @Override
  public void remove(City city) {
    city = byId(city.getId());
    manager.remove(city);
  }
}
