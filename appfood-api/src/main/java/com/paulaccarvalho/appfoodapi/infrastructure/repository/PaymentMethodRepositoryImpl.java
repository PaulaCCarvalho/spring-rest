package com.paulaccarvalho.appfoodapi.infrastructure.repository;

import java.util.List;
import org.springframework.stereotype.Component;
import com.paulaccarvalho.appfoodapi.domain.model.PaymentMethod;
import com.paulaccarvalho.appfoodapi.domain.repository.PaymentMethodRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<PaymentMethod> all() {
    return manager.createQuery("from payment_method", PaymentMethod.class).getResultList();
  }

  @Override
  public PaymentMethod byId(Long id) {
    return manager.find(PaymentMethod.class, id);
  }

  @Transactional
  @Override
  public PaymentMethod add(PaymentMethod paymentMethod) {
    return manager.merge(paymentMethod);
  }

  @Transactional
  @Override
  public void remove(PaymentMethod paymentMethod) {
    paymentMethod = byId(paymentMethod.getId());
    manager.remove(paymentMethod);
  }

}
