import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.nio.file.Files;
import java.util.regex.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {

public static void main(String[] args) {
	Path caminho = Paths.get("C:/temp/INPUT.txt");
	try {
		byte[] texto = Files.readAllBytes(caminho);
		String leitura = new String(texto);
		System.out.println(leitura);
	} catch(Exception error)	{  
    }
}
}
