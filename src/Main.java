import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		Grep grep = new Grep("Ta.*z","file.txt");
		grep.readFile();
		//System.out.println("Regex: "+grep.getRegex()+", Texte: "+ grep.getTexte());
	}

}
