package com.the_fall.ui.menus.cases.admin_cases;

import com.the_fall.controller.AdminController;

public class AdminShowCurrentBalanceCase {
    public static void execute(AdminController admin) {
        double saldoActual = admin.getCurrentBalance();
        System.out.println("   Saldo actual del administrador: " + saldoActual + " 💼");
    }
}