package com.paulaccarvalho.appfoodapi.infrastructure.repository;

import java.util.List;
import org.springframework.stereotype.Component;
import com.paulaccarvalho.appfoodapi.domain.model.Kitchen;
import com.paulaccarvalho.appfoodapi.domain.repository.KitchenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class KitchenRepositoryImpl implements KitchenRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Kitchen> list() {
    return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
  }

  @Override
  public Kitchen find(Long id) {
    return manager.find(Kitchen.class, id);
  }

  @Transactional
  @Override
  public Kitchen add(Kitchen kitchen) {
    return manager.merge(kitchen);
  }

  @Transactional
  @Override
  public void remove(Kitchen kitchen) {
    kitchen = find(kitchen.getId());
    manager.remove(kitchen);
  }

}
