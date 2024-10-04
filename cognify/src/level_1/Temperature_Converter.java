package level_1;

import java.util.Scanner;

public class Temperature_Converter {
	public static void main(String args[]) {
		Scanner obj = new Scanner(System.in);
		System.out.println("Temperature Converter");
		System.out.println("Choose the conversion:");
		System.out.println("1. Celsius to Fahrenheit");
		System.out.println("2. Fahrenheit to Celsius");
		int choose = obj.nextInt();
		if (choose == 1) {
			double celsius = obj.nextDouble();
			double fahrenheit = celsiusToFahrenheit(celsius);
			System.out.printf("%.2f°C is equal to %.2f°F%n", celsius, fahrenheit);
		} else if (choose == 2) {
			double fahrenheit = obj.nextDouble();
			double celsius = fahrenheitToCelsius(fahrenheit);
			System.out.printf("%.2f°F is equal to %.2f°C%n", fahrenheit, celsius);
		} else {
			System.out.println("The input is invalid");
		}
	}

	public static double celsiusToFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 9 / 5;
	}
}
