package com.hl.week3.lab1;

public class Driver {

	public static void main(String[] args) {
		double[] salaries = {
				55000,
				62000,
				71000,
				48000,
				85000
		};
		EmployeeCalculator.employeeCount = salaries.length;
		
		System.out.println("Employee Salaries: ");
		for (int i = 0; i < salaries.length; i++) {
			System.out.println(salaries[i]);
		}
		System.out.println();
		
		double averageSalary = EmployeeCalculator.calculateAverageSalary(salaries);
		System.out.println("Average Salary: " + averageSalary);
		System.out.println();
		
		double defaultBonus = EmployeeCalculator.calculateBonus(salaries[0]);
		System.out.println("10% Bonus: " + defaultBonus);
		System.out.println();
		
		double customBonus = EmployeeCalculator.calculateBonus(salaries[1], 15);
		System.out.println("15% Bonus: " + customBonus);
		System.out.println();
		
		System.out.println("Total Employees: " + EmployeeCalculator.employeeCount);
	}

}
