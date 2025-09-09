package com.the_fall.ui.menus.cases.admin_cases;

import com.the_fall.controller.AdminController;
import com.the_fall.model.Employee;
import com.the_fall.ui.utils.Validators;
import java.util.Scanner;
import java.util.List;

public class AdminListEmployeeCase {
    public static void execute(AdminController admin) {
        List<Employee> employees = admin.listEmployees();
        if (employees.isEmpty()) {
            System.out.println("\n   No hay empleados registrados.");
        }
        else {
            employees.forEach(e -> System.out.println(e.getId() 
                + " - " 
                + e.getName() 
                + " (Saldo: " 
                + e.getBalace() 
                + ")"));
        }
    }
}