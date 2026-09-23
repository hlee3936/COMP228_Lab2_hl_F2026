package com.hl.week3.lab1;

public class EmployeeCalculator {
	static int employeeCount = 0;
	
	static double calculateAverageSalary(double[] salaries) {
		double sum = 0;
		for (int i = 0; i < salaries.length; i++) {
			sum += salaries[i];
		}
		return sum / salaries.length;
	}
	
	static double calculateBonus(double salary) {
		return salary * 0.1;
	}
	
	static double calculateBonus(double salary, double percentage) {
		return salary * (percentage / 100);
	}
}