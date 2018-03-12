package FloydWarshall;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.Writer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//String fileName = args[0];
		String fileName = new String("rollernet.dyn");

		extract(fileName);
		
		traitment();
		
		AllPairShortestPath algo = new AllPairShortestPath();
		//algo.floydWarshall(graph);
		
	}

	private static void extract(String fileName) throws IOException {
		
		//Affiche le nom du fichier passé en param
		//System.out.println(fileName);
		
		Writer output;
		output = new BufferedWriter(new FileWriter("exportFloydWarshall.txt", true));  //clears file every time
		
		String line;
		Reader input = new FileReader(new File(fileName));
		LineNumberReader inputStream = new LineNumberReader(input);
		String[] secondes;
			
		while ((line = inputStream.readLine()) != null) {
		
			secondes = line.split(" ");
			
			if(Integer.parseInt(secondes[2]) >= 1200 && Integer.parseInt(secondes[2]) <= 1205) {
				
				//System.out.println(line);
				output.append(line + "\n");
			}
			
		}
		
		output.close();
		inputStream.close();
		input.close();
	}
	
	private static int[][] traitment() throws IOException {
		
		String line;
		Reader input = new FileReader(new File("exportFloydWarshall.txt"));
		LineNumberReader inputStream = new LineNumberReader(input);
		int[][] matrice = new int[61][61];
		
		for (int i = 0; i < 61; i++) {
			
		    for (int j = 0; j < 61; j++) {
		    	
		    	matrice[i][j] = 0;
		    }
		    
		}
		
		String[] split;
			
		while ((line = inputStream.readLine()) != null) {
			
			split = line.split(" ");
			
			//Parcours la matrice en hauteur
			for(int rows = 0; rows < 61; rows++) {
				
				if(rows == Integer.parseInt(split[0])) {
					matrice[rows][0] = 1;
				}
				
				//Parcours la matrice en largeur
				for(int col = 0; col < 61; col++) {
					
					if(col == Integer.parseInt(split[1])) {
						matrice[rows][col] = 1;
					}
			
				}
					
			}
						
		}
				
		for (int i = 0; i < matrice.length; i++) {
		    for (int j = 0; j < matrice[i].length; j++) {
		        System.out.print(matrice[i][j] + " ");
		    }
		    System.out.println();
		}
		
		inputStream.close();
		input.close();
		
		return matrice;
	}
	
}