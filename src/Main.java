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
		String fileName = new String("file.txt");
		String fileNameHtml = new String("fileHtml.txt");

		grep(fileName);
		grepHtml(fileNameHtml);

		
	}

	private static void grep(String fileName) throws IOException {
		
		//Affiche le nom du fichier pass� en param
		System.out.println(fileName);
		
		String line;
		Reader input = new FileReader(new File(fileName));
		LineNumberReader inputStream = new LineNumberReader(input);
		char[][] automata = new char[5][5];
		Grep m = new Grep(automata,"TamuSE");
		
		while ((line = inputStream.readLine()) != null) {
			
			if (m.findTamuse(line)) {
				System.out.println(inputStream.getLineNumber() + " : " + line);
			}
			
		}
		
		inputStream.close();
		input.close();
	}
	
	
	private static void grepHtml(String fileName) throws IOException {
		
		//Affiche le nom du fichier pass� en param
		System.out.println(fileName);
		Writer output;
		output = new BufferedWriter(new FileWriter("export.txt", true));  //clears file every time
		
					
		String line;
		Reader input = new FileReader(new File(fileName));
		LineNumberReader inputStream = new LineNumberReader(input);
		char[][] automata = new char[5][5];
		Grep m = new Grep(automata,"a href");
		
		while ((line = inputStream.readLine()) != null) {
			
			if (m.findHtml(line)) {
				//System.out.println(inputStream.getLineNumber() + " : " + line);
				String pattern = "(http|https)(:\\/\\/.*)(\\\")";
				Pattern r = Pattern.compile(pattern);
				
				Matcher ma = r.matcher(line);
				String[] tab = null;
				
				if(ma.find( )) {
					output.append(ma.group(0).replace("\"",""));
					System.out.print(ma.group(0).replace("\"",""));
					tab = ma.group(0).split("/");
					
					for(int i = 2; i < tab.length; i++){
						
						if( i >= 2) {
							//System.out.println(inputStream.getLineNumber() + " : " + tab[i] + "/");
						}
					}
				}
				else {
					//System.out.println("No match");
				}
				
				String pattern2 = "((http)(:\\/\\/\\w*.)(\\d*)(\\w*.\\w*))|((https)(:\\/\\/\\w*.)(\\w*.)(\\w*.\\w*))";
				Pattern r2 = Pattern.compile(pattern2);
				
				Matcher ma2 = r2.matcher(line);
				if(ma2.find( )) {
					if(ma2.group(5) == null) {
						output.append(" | "+ma2.group(10)+" | "+ma2.group(0));
						System.out.println(" | "+ma2.group(10)+" | "+ma2.group(0));
					}
					else {
						output.append(" | "+ma2.group(5)+" | "+ma2.group(0));
						System.out.println(" | "+ma2.group(5)+" | "+ma2.group(0));
					}
					output.append("\n");
				}
				else {
					//System.out.println("No match");
				}
			}
			
		}
		output.close();
		inputStream.close();
		input.close();
	}
	
}