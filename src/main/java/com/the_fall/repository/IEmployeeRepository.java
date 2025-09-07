package src.main.java.com.the_fall.repository;

import src.main.java.com.the_fall.model.Employee;
import java.util.List;

public interface IEmployeeRepository {

  void add(Employee e);

  void update(Employee e);

  void delete(int id);

  List<Employee> getAll();

  Employee getById(int id);
}
