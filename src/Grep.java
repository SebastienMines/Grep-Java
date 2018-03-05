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

	public void splitText(String line) {
//		char[][] res = 
//			{
//					{'T', 0, 0, 0, 0, 0},
//					{0,'a', 0, 0, 0, 0},
//					{0, 0, 'm', 0, 0, 0},
//					{0, 0, 0, 'm', 0, 0},
//					{0, 0, 0, 0, 'u', 0},
//					{0, 0, 0, 0, 0, 'z'}
//			};
//		// TODO Auto-generated method stub
//		char[] regex = this.getRegex().toCharArray();
//		char[] x = line.toCharArray();
//		
//		for(int i=0; i<x.length; i++) {
//			//System.out.println(lineSplit[i]);
//			for(int j=0; j<this.regex.length(); j++) {
//				//System.out.println("Bla");
//				if(res[j][j] == x[i+1]) {
//					System.out.println(res[j][j]+" - "+x[i+j]);
//				}
//			}
//		}
		try {

			// TODO Auto-generated method stub
			char[] regex = this.getRegex().toCharArray();
			char[] x = line.toCharArray();
			
			for(int i=0; i<x.length; i++) {
				//System.out.println(lineSplit[i]);
				if(x[i] == 'T') {
					//System.out.println(i+"T");
	
					if(x[i+1] == 'a') {
						//System.out.println(i+1+"a");
	
						if(x[i+2] == 'm') {
							//System.out.println(i+2+"m");
	
							if(x[i+4] == 'u') {
								//System.out.println(i+4+"u");
								
								if(x[i+5] == 'z') {
									//System.out.println(i+5+"z");
									
									for(int j=0;j<6;j++) {
										System.out.println(x[i+j]);
									}
									
									System.out.println("true");
								}
							}
						}
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException | NullPointerException e) {

		}
	}
	
	public void readFile() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(this.file));
		
		try {
			
		    StringBuilder sb = new StringBuilder();
		    this.setTexte(this.getTexte() + br.readLine());
		    String line = br.readLine();

		    while (line != null) {
		    	
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
			    this.setTexte(this.getTexte() + br.readLine());

		        //System.out.println(line);
		        splitText(this.texte);
		        
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
