package com.the_fall.ui.menus.cases.admin_cases;

import com.the_fall.controller.AdminController;
import com.the_fall.model.Employee;
import com.the_fall.ui.utils.Validators;
import java.util.Scanner;

public class AdminDeleteEmployeeCase {
    public static void execute(AdminController admin, Scanner sc) {
        while (true) {
            System.out.print("   Ingrese el ID del empleado a eliminar: ");
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
            admin.deleteEmployee(id);
            System.out.println("\n   Empleado eliminado. 🗑️");
            break;
        }
    }
}