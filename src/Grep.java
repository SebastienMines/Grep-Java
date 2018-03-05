import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Grep {
	

	public void splitText(String word, String text) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<>();
		
		
	}
	
	public void readFile(String file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
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
}
