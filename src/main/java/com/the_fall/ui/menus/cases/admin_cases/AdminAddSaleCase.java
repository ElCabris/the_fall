package com.the_fall.ui.menus.cases.admin_cases;

import com.the_fall.controller.AdminController;
import com.the_fall.ui.utils.Validators;
import java.util.Scanner;

public class AdminAddSaleCase {
    public static void execute(AdminController admin, Scanner sc) {
        while (true) {
            System.out.print("   Ingrese monto de la venta: ");
            String amountInput = sc.nextLine();
            if (!Validators.readValidDouble(amountInput)) {
                System.out.println("\n   Monto inválido, debe ser un número real positivo. \n");
                break;
            }
            double amount = Double.parseDouble(amountInput);
            admin.addSale(amount);
            System.out.println("\n   Venta registrada. 💵");
            break;
        }
    }
}