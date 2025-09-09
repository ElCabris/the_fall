package com.the_fall.ui.menus.cases.admin_cases;

import com.the_fall.controller.AdminController;

public class AdminShowTotalSalesCase {
    public static void execute(AdminController admin) {
        System.out.println("   Total ventas: " + admin.getTotalSale() + " 📊");
    }
}