public class Grep {
	
	private char[][] automata;
	
	public Grep(char[][] automata, String regex) {	
		
		char[] cle = regex.toCharArray();
		
		//Affiche la regex passée en paramètre de facon découpée
		for(int i = 0; i < cle.length; i++) {
			System.out.println("regex: "+ i +" "+ cle[i]);
		}
		
		//colonne = position du caractère dans l'automate
		//ligne = la ou commence le mot
		if(regex.equals("TamuSE")) {
			
			automata[0][1] = cle[0]; //T
			automata[1][2] = cle[1]; //a
			automata[2][2] = cle[2]; //m
			automata[2][3] = cle[3]; //u
			automata[3][4] = cle[4]; //S
			automata[0][4] = cle[5]; //E
			
		}else if(regex.equals("a href")){
			automata[0][1] = cle[0]; //a
			automata[1][2] = cle[1]; //
			automata[2][1] = cle[2]; //h
			automata[2][2] = cle[3]; //r
			automata[2][3] = cle[4]; //e
			automata[2][4] = cle[5]; //f
			
		}
		
		
		for(int i = 0 ; i < automata.length; i++ ){  
			
		     for(int j = 0; j< automata[i].length; j++){   
		         System.out.print(automata[i][j]); 
		     } 
		     
		System.out.println(); 
		}  
		
		this.automata = automata;
		
	}

	public boolean findTamuse(String line) {
		
		for(int i = 0; i < line.length(); i++) {
			
			if(accept(i, line)) {
				return true;
			}
			
		}
		return false;
		
	}
	
	public boolean findHtml(String line) {
		
		for(int i = 0; i < line.length(); i++) {
			
			if(acceptHtml(i, line)) {
				return true;
			}
			
		}
		return false;
		
	}

	private boolean accept(int i, String line) {
		
		int currentState = 0;
		int indice = i;
		boolean found = true;
		
		while(indice < line.length() && found) {
			
			found = false;
			for(int j = 0; j < 4; j++) {
				
				if(automata[currentState][j] == line.charAt(indice)) {
					
					found = true;
					indice++;
					currentState = j;
					break;
					
				}
				
			}
			
			if(automata[currentState][4] == 'S') {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean acceptHtml(int i, String line) {
		
		int currentState = 0;
		int indice = i;
		boolean found = true;
		
		while(indice < line.length() && found) {
			
			found = false;
			for(int j = 0; j < 4; j++) {
				
				if(automata[currentState][j] == line.charAt(indice)) {
					
					found = true;
					indice++;
					currentState = j;
					break;
					
				}
				
			}
			
			if(automata[currentState][4] == 'f') {
				return true;
			}
		}
		
		return false;
	}
}