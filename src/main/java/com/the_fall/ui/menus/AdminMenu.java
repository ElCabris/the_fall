package com.the_fall.ui.menus;

import com.the_fall.controller.AdminController;
import com.the_fall.model.Employee;
import com.the_fall.ui.interfaces.IMenu;
import com.the_fall.ui.utils.Validators;
import com.the_fall.ui.menus.cases.admin_cases.*;

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
            System.out.print("   Seleccione una opción: ");
            String input = sc.nextLine();

            List<Integer> opcionesValidas = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

            if (!Validators.readValidOption(opcionesValidas, input)) {
                System.out.println("\n   Opción inválida, intente de nuevo.\n");
                continue;
            }

            int opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1 -> AdminRegisterEmployeeCase.execute(admin, sc);
                case 2 -> AdminListEmployeeCase.execute(admin);
                case 3 -> AdminUpdateEmployeeCase.execute(admin, sc);
                case 4 -> AdminDeleteEmployeeCase.execute(admin, sc);
                case 5 -> AdminAddSaleCase.execute(admin, sc);
                case 6 -> AdminShowTotalSalesCase.execute(admin);
                case 7 -> AdminPayEmployeeCase.execute(admin, sc);
                case 8 -> AdminShowCurrentBalanceCase.execute(admin);
                case 9 -> { AdminExitCase.execute(); return; }
                default -> System.out.println("   Opción no reconocida. ⚠️");
            }
        }
    }
}