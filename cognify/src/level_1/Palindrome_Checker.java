package level_1;

import java.util.Scanner;

public class Palindrome_Checker {
	public static void main(String args[]) {
		Scanner obj = new Scanner(System.in);
		String str = obj.next();
		int n = str.length();
		boolean result = Palindrome_Checker.Palindrome(str, n);
		if (result) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	public static boolean Palindrome(String s, int n) {
		int z, x, c = 0, v = n - 1;
		for (z = 0; z < n / 2; z++) {
			if (s.charAt(z) != s.charAt(v)) {
				c = 10;
				break;
			}
			v--;
		}
		if (c == 10) {
			return false;
		} else {
			return true;
		}
	}
}