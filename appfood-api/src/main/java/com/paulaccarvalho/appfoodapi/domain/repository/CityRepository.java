package com.paulaccarvalho.appfoodapi.domain.repository;

import java.util.List;

import com.paulaccarvalho.appfoodapi.domain.model.City;

public interface CityRepository {

  List<City> all();

  City byId(Long id);

  City add(City city);

  void remove(City city);
}
