import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class General {

	public static String readFile(String fileName) throws FileNotFoundException {
		Scanner fileScan = new Scanner(new File(fileName));
		String concat = "";
		while (fileScan.hasNextLine()) {
			String line = fileScan.nextLine();
			Scanner lineScan = new Scanner(line);
			while (lineScan.hasNext()) {
				concat += lineScan.next() + " ";
			}
			concat += "\n";
		}
		return concat.trim();
	}
	
	public static String choice(String prompt, String[] choices, Scanner input) {
		System.out.println(prompt);
		for (int i = 0; i < choices.length - 1; i++) {
			System.out.print(choices[i] + ", ");
		}
		System.out.print("or " + choices[choices.length - 1] + "? ");
		List<String> james = new ArrayList();
		return input.next().toLowerCase().trim();

	}
	
}
