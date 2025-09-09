package com.the_fall.ui.menus.cases.admin_cases;

import com.the_fall.controller.AdminController;
import com.the_fall.model.Employee;
import com.the_fall.ui.utils.Validators;
import java.util.Scanner;

public class AdminRegisterEmployeeCase {
    public static void execute(AdminController admin, Scanner sc) {
        while (true) {
            System.out.print("   Ingrese el ID: ");
            String idInput = sc.nextLine();
            if (!Validators.readValidInt(idInput)) {
                System.out.println("\n   ID inválido, debe ser un entero positivo.");
                continue;
            } 
            int id = Integer.parseInt(idInput);
            System.out.print("   Ingrese el nombre: ");
            String name = sc.nextLine();
            System.out.print("   Ingrese la contraseña: ");
            String password = sc.nextLine();
            admin.registerEmployee(new Employee(id, name, password));
            System.out.println("\n   Empleado registrado.");
            break;
        }
    }
}