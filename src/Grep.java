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

		char[] x = line.toCharArray();
		
		try {
			for(int i=0; i<x.length; i++) {
				//System.out.println(lineSplit[i]);
				if(x[i] == 'T') {
					System.out.println(i+"T");
	
					if(x[i+1] == 'a') {
						System.out.println(i+1+"a");
	
						if(x[i+2] == 'm') {
							System.out.println(i+2+"m");
	
							if(x[i+3] == 'm') {
								System.out.println(i+3+"m");
								
								if(x[i+4] == 'u') {
									System.out.println(i+4+"u");
									
									if(x[i+5] == 'z') {
										System.out.println(i+5+"z");
										System.out.println("true");
									}
								}
							}
						}
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("tkt");
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
