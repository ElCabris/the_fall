package src.main.java.com.the_fall.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import src.main.java.com.the_fall.model.Employee;
import src.main.java.com.the_fall.repository.IEmployeeRepository;

public class EmployeeRespositoryMemory implements IEmployeeRepository {
  private final List<Employee> employees;

  public EmployeeRespositoryMemory() {
    this.employees = new ArrayList<>();
  }

  @Override
  public void add(Employee e) {
    if (e == null) {
      throw new IllegalArgumentException("The employee cannot be null");
    }
    employees.add(e);
  }

  @Override
  public void update(Employee e) {
    if (e == null) {
      throw new IllegalArgumentException("The employee cannot be null");
    }
    Optional<Employee> existing = employees.stream().filter(emp -> emp.getId() == e.getId()).findFirst();

    if (existing.isPresent()) {
      int index = employees.indexOf(existing.get());
      employees.set(index, e);
    } else {
      throw new IllegalArgumentException("Employee with ID " + e.getId() + " not found");
    }
  }

  @Override
  public void delete(int id) {
    employees.removeIf(emp -> emp.getId() == id);
  }

  @Override
  public List<Employee> getAll() {
    return new ArrayList<>(employees);
  }

  @Override
  public Employee getById(int id) {
    return employees.stream().filter(emp -> emp.getId() == id).findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Employee with ID " + id + " not found"));
  }
}
