import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.nio.file.Files;
import java.util.regex.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class linha {

	public static void main(String[] args) {
		Scanner in = new Scanner(new FileReader("C:/temp/INPUT.txt"));
		while (in.hasNextLine()) {
		    String line = Scanner.nextLine();
		    System.out.println(line);
		}

	}

}
