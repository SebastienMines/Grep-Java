import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Grep {
	
	private String regex;
	private String file;
	private String texte;
	
	public Grep(String regex, String file) {
		this.regex = new String(regex);
		this.file = new String(file);
		this.texte = new String("");
	}

	public void splitText(String regex, String line) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<>();
		//System.out.println(line);
		char[] x = line.toCharArray();
		for(int i=0; i<x.length; i++) {
			//System.out.println(lineSplit[i]);
			if(x[i] == 'z') {
				//System.out.println(x[i]);
				int j=i-1;
				if(x[j]=='u') {
					//System.out.println(j);
					int k =j-1;
					if(x[k]=='m') {
						System.out.println(x[k]);
						//System.out.println(j);
						int l =k-1;
						if(x[l]=='m') {
							System.out.println(x[l]);
						}
					}
				}
			}
		}
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
		        //System.out.println(line);
		        splitText("T", line);
		        
		    }
		    
		    //this.texte = sb.toString();
		    
		} finally {
		    br.close();
		}
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}
		
}
