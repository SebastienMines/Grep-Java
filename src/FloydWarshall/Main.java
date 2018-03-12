package FloydWarshall;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
		
		//String fileName = args[0];
		String fileName = new String("rollernet.dyn");

		extract(fileName);
		
	}

	private static void extract(String fileName) throws IOException {
		
		//Affiche le nom du fichier passé en param
		System.out.println(fileName);
		
		String line;
		Reader input = new FileReader(new File(fileName));
		LineNumberReader inputStream = new LineNumberReader(input);
		
		while ((line = inputStream.readLine()) != null) {
			
			System.out.println(inputStream.getLineNumber() + " : " + line);
			
		}
		
		inputStream.close();
		input.close();
	}
	
}