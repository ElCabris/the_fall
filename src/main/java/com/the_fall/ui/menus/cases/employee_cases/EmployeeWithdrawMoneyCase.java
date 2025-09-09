package com.the_fall.ui.menus.cases.employee_cases;

import com.the_fall.model.Employee;
import com.the_fall.ui.utils.Validators;

import java.util.Scanner;

public class EmployeeWithdrawMoneyCase {
    public static void execute(Employee employee, Scanner sc) {
        System.out.print("   Ingrese monto a retirar: ");
        String valueInput = sc.nextLine();

        if (Validators.readValidDouble(valueInput)) {
            double value = Double.parseDouble(valueInput);
            try {
                employee.wethdrawBalance(value);
                System.out.println("   Retiro exitoso. Nuevo saldo: " + employee.getBalace() + " ✅\n");
            } catch (IllegalArgumentException e) {
                System.out.println("   " + e.getMessage() + " ❌\n");
            }
        } else {
            System.out.println("   Monto inválido. ❌\n");
        }
    }
}