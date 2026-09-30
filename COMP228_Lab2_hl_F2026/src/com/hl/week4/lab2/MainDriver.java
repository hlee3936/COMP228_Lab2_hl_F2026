package com.hl.week4.lab2;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Interest interests[] = new Interest[5];
		
		for (int i = 0; i < 5; i++) {
            System.out.println("=== Case " + (i + 1) + " ===");

            BigDecimal principal = null;
            BigDecimal rate = null;
            int time = 0;

            while (true) {
                System.out.print("Enter Principal (decimal only): ");
                String input = scanner.next();
                try {
                    if (!input.contains(".")) {
                        System.out.println("Invalid input. Please enter a decimal value.");
                        continue;
                    }
                    principal = new BigDecimal(input);
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid decimal number.");
                }
            }

            while (true) {
                System.out.print("Enter Rate (decimal only): ");
                String input = scanner.next();
                try {
                    if (!input.contains(".")) {
                        System.out.println("Invalid input. Please enter a decimal value.");
                        continue;
                    }
                    rate = new BigDecimal(input);
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid decimal number.");
                }
            }

            while (true) {
                try {
                    System.out.print("Enter Time in years (integer only): ");
                    time = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.next();
                }
            }

            try {
                interests[i] = new Interest(principal, rate, time);

                BigDecimal simpleInterestBD = interests[i].calculateSimpleInterest(principal, rate, time);
                BigDecimal compoundInterestBD = interests[i].calculateCompoundInterest(principal, rate, time);

                double simpleInterestDouble = interests[i].calculateSimpleInterest(principal.doubleValue(), rate.doubleValue(), time);
                double compoundInterestDouble = interests[i].calculateCompoundInterest(principal.doubleValue(), rate.doubleValue(), time);

                System.out.println("Simple Interest (BigDecimal)   : " + simpleInterestBD);
                System.out.println("Simple Interest (Double)       : " + simpleInterestDouble);
                System.out.println("Compound Interest (BigDecimal) : " + compoundInterestBD);
                System.out.println("Compound Interest (Double)     : " + compoundInterestDouble + "\n");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + "\n");
                i--;
            }
        }
	}

}
