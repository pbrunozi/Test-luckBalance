import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;



public class lerlinha {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Integer n = 0;
		String s;
		String[] vect;
		Integer k = 0;
		int Sortemax = 0; // RESULTADO : Saldo de Sorte da Lena
		// Leitura da primeira linha, n e k, valores permitidos
		// 1 <= n <= 100
		// 0 <= k < n
		System.out.println("Leitura (aos pares) da primeira linha, n e k");
		System.out.println("n = numero de concursos e k=numero de concursos podem perder. Valores permitidos");
		System.out.println("1 <= n <= 100");
		System.out.println("0 <= k < n");
		System.out.println("Formato entra 'x y', um espaço em branco entre x e y");
		boolean IsParse = true;
		while (((n <= 0) || (n > 100)) || ((k <= 0) || (k >= n)) || (IsParse == false))  {
		  IsParse = true;
		  s = input.nextLine();
		  // Necessita tratar os ExceptionError para fornecer input não esperado, não numericos e sem respeitar espaço
		  vect = s.split(" ");
		  if (isParsable(vect[0]) == true) {
			  n = Integer.parseInt(vect[0]);
		  } else
			  IsParse = false;
		  if (isParsable(vect[1]) == true) {
			  k = Integer.parseInt(vect[1]);
		  } else
			  IsParse = false;
		  System.out.println("n= "+n+"  k= "+k);
		}
		// Inicialização dos vetores Contests (sorte) e Timportance (importancia)
		Integer Contests[] = new Integer[n];
		Integer Timportance[] = new Integer[n];
		Integer ValidContests[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			Contests[i] = 0;
			Timportance[i] = 0;
			ValidContests[i] = 0;
		}
		// Leitura dos valores de cada concurso (contestes): Sorte e Importancia
		// 1 <= Sorte <= 10000
		// Importancia 0 ou 1
		System.out.println("Leitura (aos pares) dos valores de cada concurso (contestes): Sorte e Importancia:");
		System.out.println("1 <= Sorte <= 10000");
		System.out.println("Importancia = 0 ou 1");
		System.out.println("Formato entra 'x y', um espaço em branco entre x e y");
		for (int i = 0; i < n; i++) {
			IsParse = true;
			while (((Contests[i]<1) || (Contests[i]>10000)) || ((Timportance[i]<0) || (Timportance[i]>1))) {
			  s = input.nextLine();
			  vect = s.split(" ");
			  if (isParsable(vect[0]) == true) {
				  Contests[i] = Integer.parseInt(vect[0]);
			  } else
				  IsParse = false;
			  if (isParsable(vect[1]) == true) {
				  Timportance[i] = Integer.parseInt(vect[1]);
			  } else
				  IsParse = false;
			  //System.out.println("Contests["+i+"]= "+Contests[i]+"    Timportance["+i+"]= "+Timportance[i]);
	         }
		}
		// Somatoria dos sorte para os concursos sem importancia
		// Gerar novo vetor de contests validos ValidContests, ou seja, contestos com importancia = 1
		int j = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("Contests["+i+"]= "+Contests[i]+"    Timportance["+i+"]= "+Timportance[i]);
			if (Timportance[i] == 0) {
				Sortemax += Contests[i];
			} else {
				ValidContests[j] = Contests[i];
				j++;
			}
				
		}
        int nimport = j;
        //System.out.println("nimpor= "+nimport+"   Sortemax= "+Sortemax);
        for (j = 0; j < nimport; j++)
        	System.out.println("ValidContests["+j+"]= "+ValidContests[j]);
        //Aplicar função SORT no array ValidContests em ordem crescente, para concursos importantes
		Arrays.sort(ValidContests,Collections.reverseOrder());
		//Somatoria de Li para os k´esimos primeiro concursos  e subtração do resto (i >= k) concursos menos importantes
		for(int i = 0; i < nimport; i++){
			System.out.print(ValidContests[i]+" ");
		    if(i < k) {
		        Sortemax += ValidContests[i]; 
		        //System.out.println(ValidContests[i]+"soma"+"\n");
		    }
		    else {
		        Sortemax -= ValidContests[i]; 
		        //System.out.println(Contests[i]+"subtrai"+"\n");
		    }
		}
		System.out.println("\n\nRESULTADO DO SALDO DE SORTE DE LENA ===> "+Sortemax);
	}
	
// Função para tratamento de erro. Checa se string pode ser convertido em integer.
public static boolean isParsable(String input) {
	try {
		Integer.parseInt(input);
	      return true;
	    } catch (final NumberFormatException e) {
	      return false;
	    }
	}

}

