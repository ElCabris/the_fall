package com.the_fall.ui.menus.cases.admin_cases;

import com.the_fall.controller.AdminController;
import com.the_fall.model.Employee;
import com.the_fall.ui.utils.Validators;
import java.util.Scanner;

public class AdminUpdateEmployeeCase {
    public static void execute(AdminController admin, Scanner sc) {
        while (true) {
            System.out.print("   Ingrese el ID del empleado a actualizar: ");
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
            System.out.print("   Nuevo nombre: ");
            String name = sc.nextLine();
            System.out.print("   Nueva contraseña (dejar vacío para mantener la actual): ");
            String password = sc.nextLine();
            
            Employee existingEmployee = admin.listEmployees().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();
                
            if (password.isEmpty()) {
                password = existingEmployee.getPassword();
            }
            
            admin.updateEmployee(new Employee(id, name, password));
            System.out.println("\n   Empleado actualizado. ✏️");
            break;
        }
    }
}