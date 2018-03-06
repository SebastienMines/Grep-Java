import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		//String fileName = args[0];
		String fileName = new String("file.txt");
		String fileNameHtml = new String("fileHtml.txt");

		//grep(fileName);
		grepHtml(fileNameHtml);

		
	}

	private static void grep(String fileName) throws IOException {
		
		//Affiche le nom du fichier passé en param
		System.out.println(fileName);
		
		String line;
		Reader input = new FileReader(new File(fileName));
		LineNumberReader inputStream = new LineNumberReader(input);
		char[][] automata = new char[5][5];
		Grep m = new Grep(automata,"TamuSE");
		
		while ((line = inputStream.readLine()) != null) {
			
			if (m.find(line)) {
				System.out.println(inputStream.getLineNumber() + " : " + line);
			}
			
		}
		
		inputStream.close();
		input.close();
	}
	
	
	private static void grepHtml(String fileName) throws IOException {
		
		//Affiche le nom du fichier passé en param
		System.out.println(fileName);
					
		String line;
		Reader input = new FileReader(new File(fileName));
		LineNumberReader inputStream = new LineNumberReader(input);
		char[][] automata = new char[5][5];
		Grep m = new Grep(automata,"a href");
		
		while ((line = inputStream.readLine()) != null) {
			
			if (m.find(line)) {
				System.out.println(inputStream.getLineNumber() + " : " + line);
			}
			
		}
		
		inputStream.close();
		input.close();
	}
	
}