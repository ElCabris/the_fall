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

    public PrincipalMenu(AdminController admin) {
        this.admin = admin;
    }

    @Override
    public void show() {
        System.out.println("""

            ===== MENU PRINCIPAL =====

            1. Menú Administrador
            2. Menú Empleado
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
                case 2 -> handleEmployeeLogin();
                case 3 -> {
                    System.out.println("👋 Saliendo del sistema...");
                    return;
                }
                default -> System.out.println("⚠️ Opción no reconocida.");
            }
        }
    }

    private void handleEmployeeLogin() {
        int attempts = 0;
        final int maxAttempts = 3;
        
        while (attempts < maxAttempts) {
            System.out.println("\n=== INICIO DE SESIÓN EMPLEADO ===");
            System.out.print("Ingrese ID de empleado: ");
            String idInput = sc.nextLine();
            
            if (!Validators.readValidInt(idInput)) {
                System.out.println("❌ ID inválido, debe ser un número entero.");
                attempts++;
                continue;
            }
            
            int id = Integer.parseInt(idInput);
            System.out.print("Ingrese contraseña: ");
            String password = sc.nextLine();
            
            // Autenticar empleado
            Employee authenticatedEmployee = admin.authenticateEmployee(id, password);
            
            if (authenticatedEmployee != null) {
                System.out.println("✅ Inicio de sesión exitoso. Bienvenido " + authenticatedEmployee.getName());
                new EmployeeMenu(authenticatedEmployee).handle();
                break;
            } else {
                attempts++;
                System.out.println("❌ Credenciales incorrectas. Intentos restantes: " + (maxAttempts - attempts));
                
                if (attempts >= maxAttempts) {
                    System.out.println("🚫 Demasiados intentos fallidos. Volviendo al menú principal.");
                    break;
                }
            }
        }
    }
}