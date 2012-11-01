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
}
