package com.the_fall.ui.utils;

import java.util.*;

public class Validators {
    
    // Validación de input en opciones de menú
    public static boolean readValidOption(List<Integer> range, String input) {
        return parseInt(input)
                .map(range::contains)
                .orElse(false);
    }

    // Validación de input double positivo
    public static boolean readValidDouble(String input) {
        return parseDouble(input)
                .filter(amount -> amount > 0)
                .isPresent();
    }

    // Validación de input int positivo
    public static boolean readValidInt(String input) {
        return parseInt(input)
                .filter(amount -> amount > 0)
                .isPresent();
    }

    // Parseo de Integer
    private static Optional<Integer> parseInt(String input) {
        try {
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    // Parseo de Double
    private static Optional<Double> parseDouble(String input) {
        try {
            return Optional.of(Double.parseDouble(input));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}