package com.paulaccarvalho.appfoodapi.domain.repository;

import java.util.List;
import com.paulaccarvalho.appfoodapi.domain.model.PaymentMethod;

public interface PaymentMethodRepository {
  List<PaymentMethod> all();

  PaymentMethod byId(Long id);

  PaymentMethod add(PaymentMethod paymentMethod);

  void remove(PaymentMethod paymentMethod);
}
