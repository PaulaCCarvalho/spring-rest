package com.paulaccarvalho.appfoodapi.domain.repository;

import java.util.List;
import com.paulaccarvalho.appfoodapi.domain.model.State;

public interface StateRepository {
  List<State> list();

  State byId(Long id);

  State add(State state);

  void remove(State state);
}
