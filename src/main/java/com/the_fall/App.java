package com.the_fall;

import com.the_fall.controller.Admin;
import com.the_fall.repository.impl.EmployeeRespositoryMemory;
import com.the_fall.repository.impl.SaleRepositoryMemory;
import com.the_fall.service.impl.PaymantServiceBasic;
import com.the_fall.ui.menus.PrincipalMenu;

public class App {
    public static void main(String[] args) {
        // Inicializar dependencias
        var employeeRepo = new EmployeeRespositoryMemory();
        var saleRepo = new SaleRepositoryMemory();
        var paymantService = new PaymantServiceBasic();

        // Controlador
        var adminController = new Admin(employeeRepo, saleRepo, paymantService);

        // Lanzar menú principal
        new PrincipalMenu(adminController).handle();
    }
}
