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
	private final static int INF = 99999, V = 62;

	public static void main(String[] args) throws IOException {
		

		double[] tab_indice = new double[62];
		
		//String fileName = args[0];
		String fileName = new String("rollernet.dyn");

		extract(fileName);
		int[][] graph = traitment();
		
		AllPairShortestPath algo = new AllPairShortestPath();
		//algo.floydWarshall(graph);
		
		int[][] fw_matrix = algo.floydWarshall(graph);
		
		for (int line = 0; line < 62; line++) {
			int somme_distance = 0;
			for (int col = 0; col < 62; col++) {
				if (col != line) {
					somme_distance += fw_matrix[line][col];
				}
			}
			tab_indice[line] = (float)(V - 1) / somme_distance;
			//System.out.println(tab_indice[line]);
		}
		
		//Normalisation entre 0 et 1
		double min_indice = tab_indice[0];
		
		for (int i = 1; i < 62; i++) {
			if(tab_indice[i] < min_indice) {
				min_indice = tab_indice[i];
			}
		}
		
		double max_indice = tab_indice[0];
		for (int i = 1; i < 62; i++) {
			if(tab_indice[i] > max_indice) {
				max_indice = tab_indice[i];
			}
		}
		
		for (int i = 1; i < 62; i++) {
			tab_indice[i] = (tab_indice[i] - min_indice) / (max_indice - min_indice);
		}

		for (int i = 0; i < 62; i++) {
			System.out.println(tab_indice[i]);
		}
					
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
				output.write(line + "\n");
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
		for (int i = 0; i < 62; i++) {
			
		    for (int j = 0; j < 62; j++) {
		    	
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
			for(int rows = 0; rows < 62; rows++) {
				
				//Parcours la matrice en largeur
				for(int col = 0; col < 62; col++) {
					
					if(rows == noeud1 && col == noeud2) {
						matrice[rows][col] = 1;
						matrice[col][rows] = 1;
					}
			
				}
					
			}
						
		}
		
		//init matrice à INF
		for (int i = 0; i < 62; i++) {
			
		    for (int j = 0; j < 62; j++) {
		    	
		    	if(i == j) {
			    	matrice[i][j] = 0;
		    	}
		    }
		    
		}
				
		for (int i = 0; i < matrice.length; i++) {
		    for (int j = 0; j < matrice[i].length; j++) {
		        //System.out.print(matrice[i][j] + " ");
				output.write(matrice[i][j] + " ");
		    }
		    //System.out.println();
			output.write("\n");
		}
		
		output.close();
		inputStream.close();
		input.close();
		
		return matrice;
	}
	
}