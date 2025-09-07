package src.main.java.com.the_fall.service;

import src.main.java.com.the_fall.model.Employee;

public interface IPaymantService {
  void pay(Employee employee, double amount);
}
