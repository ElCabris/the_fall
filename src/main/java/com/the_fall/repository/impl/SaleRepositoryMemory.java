package com.the_fall.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.the_fall.repository.ISaleRepository;

public class SaleRepositoryMemory implements ISaleRepository {
  private final List<Double> sales;

  public SaleRepositoryMemory() {
    this.sales = new ArrayList<>();
  }

  @Override
  public void add(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("The sale amount must be positive.");
    }
    sales.add(amount);
  }

  @Override
  public double getTotal() {
    return sales.stream().mapToDouble(Double::doubleValue).sum();
  }
}
