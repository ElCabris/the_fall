package com.the_fall.controller;

import java.util.List;

import com.the_fall.model.Employee;
import com.the_fall.repository.IEmployeeRepository;
import com.the_fall.repository.ISaleRepository;
import com.the_fall.service.IPaymantService;

public class Admin {

  private final IEmployeeRepository employeeRepo;
  private final ISaleRepository saleRepo;
  private final IPaymantService paymantService;

  public Admin(IEmployeeRepository employeeRepo, ISaleRepository saleRepo, IPaymantService paymantService) {
    this.employeeRepo = employeeRepo;
    this.saleRepo = saleRepo;
    this.paymantService = paymantService;
  }

  public void registerEmployee(Employee e) {
    employeeRepo.add(e);
  }

  public List<Employee> listEmployees() {
    return employeeRepo.getAll();
  }

  public void updateEmployee(Employee e) {
    employeeRepo.update(e);
  }

  public void deleteEmployee(int id) {
    employeeRepo.delete(id);
  }

  public void addSale(double amount) {
    saleRepo.add(amount);
  }

  public double getTotalSale() {
    return saleRepo.getTotal();
  }

  public void payEmployee(int id, double amount) {
    Employee e = employeeRepo.getById(id);
    paymantService.pay(e, amount);
    employeeRepo.update(e);
  }
}
