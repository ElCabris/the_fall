package com.the_fall.ui.menus;

import com.the_fall.model.Employee;
import com.the_fall.ui.interfaces.IMenu;
import com.the_fall.ui.utils.Validators;

import java.util.List;
import java.util.Scanner;

public class EmployeeMenu implements IMenu {

    private final Scanner sc = new Scanner(System.in);
    private final Employee employee;

    public EmployeeMenu(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void show() {
        System.out.println("""
            ==== MENU EMPLEADO ====
            1. Consultar saldo
            2. Retirar dinero
            3. Salir
        """);
    }

    @Override
    public void handle() {
        while (true) {
            show();
            System.out.print("Seleccione una opción: ");
            String input = sc.nextLine();

            List<Integer> opcionesValidas = List.of(1, 2, 3);

            if (!Validators.readValidOption(opcionesValidas, input)) {
                System.out.println("❌ Opción inválida, intente de nuevo.\n");
                continue;
            }

            int opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1 -> System.out.println("💰 Saldo actual: " + employee.getBalace());
                case 2 -> {
                    System.out.print("Ingrese monto a retirar: ");
                    String valueInput = sc.nextLine();
                    if (Validators.readValidDouble(valueInput)) {
                        double value = Double.parseDouble(valueInput);
                        try {
                            employee.wethdrawBalance(value);
                            System.out.println("✅ Retiro exitoso. Nuevo saldo: " + employee.getBalace());
                        } catch (IllegalArgumentException e) {
                            System.out.println("❌ " + e.getMessage());
                        }
                    } else {
                        System.out.println("❌ Monto inválido.");
                    }
                }
                case 3 -> {
                    System.out.println("\nSaliendo del menú empleado... 👋 ");
                    return;
                }
                default -> System.out.println("⚠️ Opción no reconocida.");
            }
        }
    }
}
