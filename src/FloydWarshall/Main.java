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
		algo.floydWarshall(graph);
		
	}

	private static void extract(String fileName) throws IOException {
		
		//Affiche le nom du fichier passé en param
		System.out.println(fileName);
		
		Writer output;
		output = new BufferedWriter(new FileWriter("exportFloydWarshall.txt", true));  //clears file every time
		
		String line;
		Reader input = new FileReader(new File(fileName));
		LineNumberReader inputStream = new LineNumberReader(input);
		String[] secondes;
			
		while ((line = inputStream.readLine()) != null) {
		
			secondes = line.split(" ");
			
			if(Integer.parseInt(secondes[2]) >= 1200 && Integer.parseInt(secondes[2]) <= 1800) {
				
				System.out.println(line);
				output.append(line + "\n");
			}
			
		}
		
		output.close();
		inputStream.close();
		input.close();
	}
	
	private static void traitment() throws IOException {
		
		String line;
		Reader input = new FileReader(new File("exportFloydWarshall.txt"));
		LineNumberReader inputStream = new LineNumberReader(input);
			
		while ((line = inputStream.readLine()) != null) {

			System.out.println(line);
			
		}
		
		inputStream.close();
		input.close();
	}
	
}