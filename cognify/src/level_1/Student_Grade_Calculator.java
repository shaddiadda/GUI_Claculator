package level_1;

import java.util.Scanner;

public class Student_Grade_Calculator {
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter the number of grades: ");
		int numberOfGrades = obj.nextInt();
		double sum = 0.0;
		for (int i = 1; i <= numberOfGrades; i++) {
			System.out.print("Enter grade " + i + ": ");
			double grade = obj.nextDouble();
			sum += grade;
		}
		double average = sum / numberOfGrades;
		System.out.printf("The average grade is: %.2f%n", average);
	}
}