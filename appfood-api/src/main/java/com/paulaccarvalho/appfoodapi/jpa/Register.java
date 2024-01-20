package com.paulaccarvalho.appfoodapi.jpa;

import java.util.List;
import org.springframework.stereotype.Component;

import com.paulaccarvalho.appfoodapi.domain.model.Kitchen;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class Register {

  @PersistenceContext
  private EntityManager manager;

  public List<Kitchen> list() {
    return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
  }

  public Kitchen find(Long id){
    return manager.find(Kitchen.class, id);
  }

  @Transactional
  public Kitchen add(Kitchen kitchen) {
    return manager.merge(kitchen);
  }

  @Transactional
  public void remove(Kitchen kitchen){
    kitchen = find(kitchen.getId());
    manager.remove(kitchen);
  }

}
