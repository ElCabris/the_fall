package com.the_fall.ui.menus;

import com.the_fall.controller.AdminController;
import com.the_fall.model.Employee;
import com.the_fall.ui.interfaces.IMenu;
import com.the_fall.ui.utils.Validators;

import java.util.List;
import java.util.Scanner;

public class AdminMenu implements IMenu {

    private final Scanner sc = new Scanner(System.in);
    private final AdminController admin; 

    public AdminMenu(AdminController admin) {
        this.admin = admin;
    }

    @Override
    public void show() {
        System.out.println("""

            ==== MENU ADMIN ====
            1. Registrar Empleado
            2. Listar Empleados
            3. Actualizar Empleado
            4. Eliminar Empleado
            5. Ingresar Venta
            6. Consultar Ventas Totales
            7. Pagar Empleado
            8. Consultar saldo actual
            9. Volver al Menú Principal
        """);
    }

    @Override
    public void handle() {
        while (true) {
            show();
            System.out.print("Seleccione una opción: ");
            String input = sc.nextLine();

            List<Integer> opcionesValidas = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

            if (!Validators.readValidOption(opcionesValidas, input)) {
                System.out.println("\nOpción inválida, intente de nuevo.\n");
                continue;
            }

            int opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1 -> {
                    while (true) {
                        System.out.print("Ingrese el ID: ");
                        String idInput = sc.nextLine();
                        if (!Validators.readValidInt(idInput)) {
                            System.out.println("\nID inválido, debe ser un entero positivo.");
                            continue;
                        } 
                        int id = Integer.parseInt(idInput);
                        System.out.print("Ingrese el nombre: ");
                        String name = sc.nextLine();
                        System.out.print("Ingrese la contraseña: ");
                        String password = sc.nextLine();
                        admin.registerEmployee(new Employee(id, name, password));
                        System.out.println("\nEmpleado registrado.");
                        break;
                    }
                }
                case 2 -> {
                    List<Employee> employees = admin.listEmployees();
                    if (employees.isEmpty()) {
                        System.out.println("\nNo hay empleados registrados.");
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
                case 3 -> {
                    while (true) {
                        System.out.print("Ingrese el ID del empleado a actualizar: ");
                        String idInput = sc.nextLine();
                        if (!Validators.readValidInt(idInput)) {
                            System.out.println("\nID inválido, debe ser un entero positivo.");
                            continue;
                        }
                        int id = Integer.parseInt(idInput);
                        if (admin.listEmployees().stream().noneMatch(e -> e.getId() == id)) {
                            System.out.println("\nNo existe un empleado con ese ID.");
                            break;
                        }
                        System.out.print("Nuevo nombre: ");
                        String name = sc.nextLine();
                        System.out.print("Nueva contraseña (dejar vacío para mantener la actual): ");
                        String password = sc.nextLine();
                        
                        Employee existingEmployee = admin.listEmployees().stream()
                            .filter(e -> e.getId() == id)
                            .findFirst()
                            .get();
                            
                        if (password.isEmpty()) {
                            password = existingEmployee.getPassword();
                        }
                        
                        admin.updateEmployee(new Employee(id, name, password));
                        System.out.println("\nEmpleado actualizado. ✏️");
                        break;
                    }
                }
                case 4 -> {
                    while (true) {
                        System.out.print("Ingrese el ID del empleado a eliminar: ");
                        String idInput = sc.nextLine();
                        if (!Validators.readValidInt(idInput)) {
                            System.out.println("\nID inválido, debe ser un entero positivo.");
                            continue;
                        }
                        int id = Integer.parseInt(idInput);
                        if (admin.listEmployees().stream().noneMatch(e -> e.getId() == id)) {
                            System.out.println("\nNo existe un empleado con ese ID.");
                            break;
                        }
                        admin.deleteEmployee(id);
                        System.out.println("\nEmpleado eliminado. 🗑️");
                        break;
                    }
                }
                case 5 -> {
                    while (true) {
                        System.out.print("Ingrese monto de la venta: ");
                        String amountInput = sc.nextLine();
                        if (!Validators.readValidDouble(amountInput)) {
                            System.out.println("\nMonto inválido, debe ser un número real positivo. \n");
                            break;
                        }
                        double amount = Double.parseDouble(amountInput);
                        admin.addSale(amount);
                        System.out.println("\nVenta registrada. 💵");
                        break;
                    }
                }
                case 6 -> System.out.println("📊 Total ventas: " + admin.getTotalSale());
                case 7 -> {
                    while (true) {
                        System.out.print("Ingrese ID del empleado: ");
                        String idInput = sc.nextLine();
                        if (!Validators.readValidInt(idInput)) {
                            System.out.println("\nID inválido, debe ser un entero positivo.");
                            continue;
                        }
                        int id = Integer.parseInt(idInput);
                        if (admin.listEmployees().stream().noneMatch(e -> e.getId() == id)) {
                            System.out.println("\nNo existe un empleado con ese ID.");
                            break;
                        }
                        System.out.print("Monto a pagar: ");
                        String amountInput = sc.nextLine();
                        if (!Validators.readValidDouble(amountInput)) {
                            System.out.println("\nMonto inválido, debe ser un número real positivo.");
                            continue;
                        }
                        double amount = Double.parseDouble(amountInput);
                        try {
                            admin.payEmployee(id, amount);
                            System.out.println("\nPago realizado. 💰");
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n❌ Error: " + e.getMessage());
                            // Permite reintentar con un monto diferente
                        }
                    }
                }
                case 8 -> {
                    double saldoActual = admin.getCurrentBalance();
                    System.out.println("💼 Saldo actual del administrador: " + saldoActual);
                }
                case 9 -> {
                    System.out.println("\nVolviendo al menú principal... ⬅️ ");
                    return;
                }
                default -> System.out.println("⚠️ Opción no reconocida.");
            }
        }
    }
}