package com.paulaccarvalho.appfoodapi.infrastructure.repository;

import java.util.List;
import org.springframework.stereotype.Component;
import com.paulaccarvalho.appfoodapi.domain.model.Permission;
import com.paulaccarvalho.appfoodapi.domain.repository.PermissionRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class PermissionRepositoryImpl implements PermissionRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Permission> all() {
    return manager.createQuery("from permission", Permission.class).getResultList();
  }

  @Override
  public Permission byId(Long id) {
    return manager.find(Permission.class, id);
  }

  @Transactional
  @Override
  public Permission add(Permission permission) {
    return manager.merge(permission);
  }

  @Transactional
  @Override
  public void remove(Permission permission) {
    permission = byId(permission.getId());
    manager.remove(permission);
  }
}
