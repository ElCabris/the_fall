package com.the_fall.service.impl;

import com.the_fall.model.Employee;
import com.the_fall.service.IPaymantService;

public class PaymantServiceBasic implements IPaymantService {

  @Override
  public void pay(Employee employee, double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("The payment amount must be positive");
    }
    employee.deposit(amount);
  }
}
