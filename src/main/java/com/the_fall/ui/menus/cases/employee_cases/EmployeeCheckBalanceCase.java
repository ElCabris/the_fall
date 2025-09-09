package com.the_fall.ui.menus.cases.employee_cases;

import com.the_fall.model.Employee;

public class EmployeeCheckBalanceCase {
    public static void execute(Employee employee) {
        System.out.println("   Saldo actual: " + employee.getBalace() + " 💰\n");
    }
}