package parser;

import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SelfParser {

	static int score = 0;

	@Test
	public void parseClass() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\parser\\ClassToTest.java"));
			String code = "";
			String line;
			while ((line = br.readLine()) != null) {
				code += line + "\n";
			}
			br.close();
			if (code.contains("int total")) {
				System.out.println("Correct declaration of variable 'total'.");
				score += 10;
			}
		} catch (Exception e) {

			System.out.println("Didn't work");
		}
	}

	@Test
	public void constructorTest() {
		ClassToTest ctt = new ClassToTest();
		try {
			assertNotNull(ctt);
			System.out.println("Constructor successful.");
			score += 10;
		} catch (AssertionError cf) {
			System.out.println("Constructor unsuccessful.");
		}

	}

	@AfterAll
	public static void outputScore() {
		System.out.println("\nScore: " + score);
	}

}