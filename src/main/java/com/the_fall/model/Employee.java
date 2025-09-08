package com.the_fall.model;

public class Employee {
    private int id;
    private String name;
    private double balance;
    private String password;

    public Employee(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.balance = 0;
        this.password = password;
    }

    public double getBalace() {
        return balance;
    }

    public void wethdrawBalance(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}