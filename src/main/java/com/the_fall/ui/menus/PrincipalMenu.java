package com.the_fall.ui.menus;

import com.the_fall.controller.AdminController;
import com.the_fall.model.Employee;
import com.the_fall.ui.interfaces.IMenu;
import com.the_fall.ui.utils.Validators;

import java.util.List;
import java.util.Scanner;

public class PrincipalMenu implements IMenu {

    private final Scanner sc = new Scanner(System.in);
    private final AdminController admin; 

    public PrincipalMenu(AdminController admin) { // Cambiado de Admin a AdminController
        this.admin = admin;
    }

    @Override
    public void show() {
        System.out.println("""

            ===== MENU PRINCIPAL =====

            1. Menú Administrador
            2. Menú Empleado (demo con empleado fijo)
            3. Salir

        """);
    }

    @Override
    public void handle() {
        while (true) {
            show();
            System.out.print("   Seleccione una opción: ");
            String input = sc.nextLine();

            List<Integer> opcionesValidas = List.of(1, 2, 3);

            if (!Validators.readValidOption(opcionesValidas, input)) {
                System.out.println("❌ Opción inválida, intente de nuevo.\n");
                continue;
            }

            int opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1 -> new AdminMenu(admin).handle();
                case 2 -> {
                    Employee demoEmployee = new Employee(1, "Empleado Demo");
                    new EmployeeMenu(demoEmployee).handle();
                }
                case 3 -> {
                    System.out.println("👋 Saliendo del sistema...");
                    return;
                }
                default -> System.out.println("⚠️ Opción no reconocida.");
            }
        }
    }
}