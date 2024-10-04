package level_1;

import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String DIGITS = "0123456789";
	private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?/[]{}|";

	public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase,
			boolean includeUppercase, boolean includeSpecial) {
		StringBuilder characterPool = new StringBuilder();
		if (includeLowercase) {
			characterPool.append(LOWERCASE);
		}
		if (includeUppercase) {
			characterPool.append(UPPERCASE);
		}
		if (includeNumbers) {
			characterPool.append(DIGITS);
		}
		if (includeSpecial) {
			characterPool.append(SPECIAL_CHARACTERS);
		}
		if (characterPool.length() == 0) {
			throw new IllegalArgumentException("At least one character type must be selected.");
		}

		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characterPool.length());
			password.append(characterPool.charAt(randomIndex));
		}

		return password.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the desired length of the password: ");
		int length = scanner.nextInt();

		System.out.print("Include numbers? (true/false): ");
		boolean includeNumbers = scanner.nextBoolean();

		System.out.print("Include lowercase letters? (true/false): ");
		boolean includeLowercase = scanner.nextBoolean();

		System.out.print("Include uppercase letters? (true/false): ");
		boolean includeUppercase = scanner.nextBoolean();

		System.out.print("Include special characters? (true/false): ");
		boolean includeSpecial = scanner.nextBoolean();

		try {
			String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase,
					includeSpecial);
			System.out.println("Generated password: " + password);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}

		scanner.close();
	}
}
