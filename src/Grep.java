import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Grep {
	
	private String regex;
	private String file;
	
	public Grep(String regex, String file) {
		this.regex = new String(regex);
		this.file = new String(file);
	}

	public void splitText(String word, String text) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<>();
		
		
	}
	
	public void readFile() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(this.file));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    System.out.println(everything);
		} finally {
		    br.close();
		}
	}
	
	public boolean regex() {
		
		return true;
	}
}
