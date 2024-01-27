package com.paulaccarvalho.appfoodapi.domain.repository;

import java.util.List;

import com.paulaccarvalho.appfoodapi.domain.model.Permission;

public interface PermissionRepository {
  List<Permission> all();

  Permission byId(Long id);

  Permission add(Permission permission);

  void remove(Permission permission);
}
