package com.paulaccarvalho.appfoodapi.infrastructure.repository;

import java.util.List;
import org.springframework.stereotype.Component;
import com.paulaccarvalho.appfoodapi.domain.model.State;
import com.paulaccarvalho.appfoodapi.domain.repository.StateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class StateRepositoryImpl implements StateRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<State> list() {
    return manager.createQuery("from State", State.class).getResultList();
  }

  @Override
  public State byId(Long id) {
    return manager.find(State.class, id);
  }

  @Transactional
  @Override
  public State add(State state) {
    return manager.merge(state);
  }

  @Transactional
  @Override
  public void remove(State state) {
    state = byId(state.getId());
    manager.remove(state);
  }
}
