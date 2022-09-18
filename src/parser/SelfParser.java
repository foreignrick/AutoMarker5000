package parser;

import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class SelfParser {

	static int score = 0;
	static String feedback = "";
	
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
				feedback += "Correct declaration of variable 'total'. ";
				score += 10;
			} else {
				feedback += "Incorrect declaration of variable 'total'. ";
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
			feedback += "Constructor successful. ";
			score += 10;
		} catch (AssertionError cf) {
			feedback += "Constructor unsuccessful. ";
		}

	}

	//Runs last
	@AfterAll
	public static void outputScore() {
		System.out.println(feedback);
		System.out.println("Score: " + score);
		try {
			FileWriter fw = new FileWriter("data.csv",true);
			PrintWriter out = new PrintWriter(fw);
			out.print(feedback + ",");
			out.print(Integer.toString(score));
			out.print("\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}