package com.the_fall.ui.menus.cases.admin_cases;

import com.the_fall.controller.AdminController;
import com.the_fall.model.Employee;
import com.the_fall.ui.utils.Validators;
import java.util.Scanner;

public class AdminPayEmployeeCase {
    public static void execute(AdminController admin, Scanner sc) {
        while (true) {
            System.out.print("   Ingrese ID del empleado: ");
            String idInput = sc.nextLine();
            if (!Validators.readValidInt(idInput)) {
                System.out.println("\n   ID inválido, debe ser un entero positivo.");
                continue;
            }
            int id = Integer.parseInt(idInput);
            if (admin.listEmployees().stream().noneMatch(e -> e.getId() == id)) {
                System.out.println("\n   No existe un empleado con ese ID.");
                break;
            }
            System.out.print("   Monto a pagar: ");
            String amountInput = sc.nextLine();
            if (!Validators.readValidDouble(amountInput)) {
                System.out.println("\n   Monto inválido, debe ser un número real positivo.");
                continue;
            }
            double amount = Double.parseDouble(amountInput);
            try {
                admin.payEmployee(id, amount);
                System.out.println("\n   Pago realizado. 💰");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\n   Error: " + e.getMessage() + " ❌");
                // Permite reintentar con un monto diferente
            }
        }
    }
}