package com.paulaccarvalho.appfoodapi.domain.repository;

import java.util.List;
import com.paulaccarvalho.appfoodapi.domain.model.Kitchen;

public interface KitchenRepository {
  List<Kitchen> list();

  Kitchen find(Long id);

  Kitchen add(Kitchen kitchen);

  void remove(Kitchen kitchen);

}
