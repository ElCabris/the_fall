package com.the_fall;

import com.the_fall.controller.AdminController;
import com.the_fall.model.Admin;
import com.the_fall.repository.IEmployeeRepository;
import com.the_fall.repository.impl.EmployeeRespositoryMemory;
import com.the_fall.ui.menus.PrincipalMenu;

public class App {
    public static void main(String[] args) {
        IEmployeeRepository employeeRepo = new EmployeeRespositoryMemory();
        Admin adminModel = new Admin();
        AdminController adminController = new AdminController(employeeRepo, adminModel);
        PrincipalMenu principalMenu = new PrincipalMenu(adminController);
        principalMenu.handle();
    }
}