import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class readline {
	public static void main(String[] args) {
		String caminho = "C:/temp/INPUT.txt";
		int Sortemax = 0;
		ArrayList<Integer> Luck = new ArrayList<>();
		int Timportance;
		try {BufferedReader br = new BufferedReader(new FileReader(caminho));
		  String linha = br.readLine();
		  // Leitura do cabeçalho : valores "n" e "k"
		  String[] header = linha.split(" ");
		  System.out.println(linha);
		  Integer n = Integer.parseInt(header[0]);
		  Integer k = Integer.parseInt(header[1]); 
		  System.out.println(n+"\n"+k+"\n");
		  // Leitura dos valors Li (luck) Ti (importance) para n concursos
		  linha = br.readLine();
		  while (linha != null) {
			  //System.out.println(linha);
			  String[] vect = linha.split(" ");
			  Timportance = Integer.parseInt(vect[1]);
			  if (Timportance != 1) {
				  // Somatoria de Li para concursos sem importancia
				  Sortemax += Integer.parseInt(vect[0]);
			  } else {
				  // Criando array de Li para os concursos importantes
				  Luck.add(Integer.parseInt(vect[0]));
			  }
			  linha = br.readLine();
		  }
		  System.out.println(Sortemax);
		  System.out.println(Luck.size());
		  //Aplicar função SORT no array Luck em ordem crescente, para concursos importantes
		  Collections.sort(Luck, Collections.reverseOrder());
		  //Somatoria de Li para os k´esimos primeiro concursos  e subtração do resto (i >= k) concursos menos importantes
		  for(int i = 0; i < Luck.size(); i++){
			  System.out.println(Luck.get(i));
		      if(i < k) {
		          Sortemax += Luck.get(i); 
		          System.out.println(Luck.get(i)+"soma"+"\n");
		      }
		      else {
		          Sortemax -= Luck.get(i); 
		          System.out.println(Luck.get(i)+"subtrai"+"\n");
		      }
		  }
		  System.out.println(Sortemax);
		}
		catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	    }
}
