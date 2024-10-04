package level2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileEncryptionDecryption {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Do you want to encrypt or decrypt a file? (e/d)");
		char choice = scanner.next().charAt(0);

		System.out.print("Enter the file name or path: ");
		String fileName = scanner.next();

		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("File not found.");
			return;
		}

		String outputFile = fileName + (choice == 'e' ? "_encrypted" : "_decrypted");

		try {
			String fileContent = readFile(file);
			String result = (choice == 'e') ? encrypt(fileContent) : decrypt(fileContent);
			writeFile(new File(outputFile), result);
			System.out.println("Operation successful. Result saved to " + outputFile);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static String readFile(File file) throws IOException {
		Scanner scanner = new Scanner(file);
		StringBuilder content = new StringBuilder();
		while (scanner.hasNextLine()) {
			content.append(scanner.nextLine()).append("\n");
		}
		scanner.close();
		return content.toString();
	}

	private static void writeFile(File file, String content) throws IOException {
		FileWriter writer = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(writer);
		printWriter.print(content);
		printWriter.close();
	}

	private static String encrypt(String content) {
		StringBuilder encrypted = new StringBuilder();
		for (char c : content.toCharArray()) {
			encrypted.append((char) (c + 3)); // simple Caesar cipher encryption
		}
		return encrypted.toString();
	}

	private static String decrypt(String content) {
		StringBuilder decrypted = new StringBuilder();
		for (char c : content.toCharArray()) {
			decrypted.append((char) (c - 3)); // simple Caesar cipher decryption
		}
		return decrypted.toString();
	}
}
