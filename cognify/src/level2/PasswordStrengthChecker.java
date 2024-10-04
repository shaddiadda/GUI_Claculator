package level2;

import java.util.Scanner;

public class PasswordStrengthChecker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a password: ");
		String password = scanner.nextLine();

		int score = 0;

		// Check length
		if (password.length() < 8) {
			System.out.println("Password is too short. It should be at least 8 characters.");
		} else {
			score++;
		}

		// Check for uppercase letters
		if (password.matches(".*[A-Z].*")) {
			score++;
		} else {
			System.out.println("Password should contain at least one uppercase letter.");
		}

		// Check for lowercase letters
		if (password.matches(".*[a-z].*")) {
			score++;
		} else {
			System.out.println("Password should contain at least one lowercase letter.");
		}

		// Check for numbers
		if (password.matches(".*[0-9].*")) {
			score++;
		} else {
			System.out.println("Password should contain at least one number.");
		}

		// Check for special characters
		if (password.matches(".*[!@#$%^&*()_+=-{};:'<>,./?].*")) {
			score++;
		} else {
			System.out.println("Password should contain at least one special character.");
		}

		// Evaluate password strength
		if (score == 5) {
			System.out.println("Strong password!");
		} else if (score >= 3) {
			System.out.println("Medium password. Consider adding more complexity.");
		} else {
			System.out.println("Weak password. Please choose a stronger password.");
		}
	}
}