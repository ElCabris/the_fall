package com.the_fall.service;

import com.the_fall.model.Employee;

public interface IPaymantService {
  void pay(Employee employee, double amount);
}
