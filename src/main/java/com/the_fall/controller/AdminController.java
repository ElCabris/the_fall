package com.the_fall.controller;

import java.util.List;
import com.the_fall.model.Employee;
import com.the_fall.repository.IEmployeeRepository;

public class AdminController {

    private final IEmployeeRepository employeeRepo;
    private final com.the_fall.model.Admin adminModel;

    public AdminController(IEmployeeRepository employeeRepo, com.the_fall.model.Admin adminModel) {
        this.employeeRepo = employeeRepo;
        this.adminModel = adminModel;
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
        adminModel.addSale(amount);
    }

    public double getTotalSale() {
        return adminModel.getTotalBalance();
    }

    public double getCurrentBalance() {
        return adminModel.getCurrentBalance();
    }

    public void payEmployee(int id, double amount) {
        Employee e = employeeRepo.getById(id);
        adminModel.makePayment(amount);
        e.deposit(amount);
        employeeRepo.update(e);
    }
}