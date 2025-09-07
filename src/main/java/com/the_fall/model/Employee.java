package src.main.java.com.the_fall.model;

public class Employee {
  private int id;
  private String name;
  private double balance;

  public Employee(int id, String name) {
    this.id = id;
    this.name = name;
    this.balance = 0;
  }

  public double getBalace() {
    return balance;
  }

  public void wethdrawBalance(double amount) {
    if (amount <= this.balance) {
      this.balance -= amount;
    } else {
      throw new IllegalArgumentException("Insufficient balance");
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

}
