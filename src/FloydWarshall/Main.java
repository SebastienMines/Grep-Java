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
		int[][] graph = traitment();
		
		AllPairShortestPath algo = new AllPairShortestPath();
		algo.floydWarshall(graph);
		
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
			
			if(Integer.parseInt(secondes[2]) >= 15*60 && Integer.parseInt(secondes[2]) <= 45*60) {
				
				//System.out.println(line);
				output.append(line + "\n");
			}
			
		}
		
		output.close();
		inputStream.close();
		input.close();
	}
	
	private static int[][] traitment() throws IOException {
		
		Writer output;
		output = new BufferedWriter(new FileWriter("MatriceFloydWarshall.txt", true));  //clears file every time
		
		String line;
		Reader input = new FileReader(new File("exportFloydWarshall.txt"));
		LineNumberReader inputStream = new LineNumberReader(input);
		int[][] matrice = new int[62][62];
		
		//init matrice à INF
		for (int i = 0; i < 61; i++) {
			
		    for (int j = 0; j < 61; j++) {
		    	
		    	matrice[i][j] = 99999;
		    }
		    
		}
		
		String[] split;
		int noeud1;
		int noeud2;
			
		while ((line = inputStream.readLine()) != null) {
			
			split = line.split(" ");
			noeud1 = Integer.parseInt(split[0]);
			noeud2 = Integer.parseInt(split[1]);
			
			//Parcours la matrice en hauteur
			for(int rows = 0; rows < 61; rows++) {
				
				//Parcours la matrice en largeur
				for(int col = 0; col < 61; col++) {
					
					if(rows == noeud1 && col == noeud2) {
						matrice[rows][col] = 1;
					}
			
				}
					
			}
						
		}
				
		for (int i = 0; i < matrice.length; i++) {
		    for (int j = 0; j < matrice[i].length; j++) {
		        //System.out.print(matrice[i][j] + " ");
				output.append(matrice[i][j] + " ");
		    }
		    //System.out.println();
			output.append("\n");
		}
		
		output.close();
		inputStream.close();
		input.close();
		
		return matrice;
	}
	
}