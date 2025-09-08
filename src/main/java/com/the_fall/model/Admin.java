package com.the_fall.model;

public class Admin {
    private double totalBalance;
    private double currentBalance;

    public Admin() {
        this.totalBalance = 0;
        this.currentBalance = 0;
    }

    public void addSale(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto de venta debe ser positivo");
        }
        this.totalBalance += amount;
        this.currentBalance += amount;
    }

    public void makePayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto de pago debe ser positivo");
        }
        if (amount > currentBalance) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar el pago");
        }
        this.currentBalance -= amount;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
}