public class Grep {
	
	private char[][] automata;
	
	public Grep(char[][] automata, String regex) {	
		
		char[] cle = regex.toCharArray();
		
		//Affiche la regex passée en paramètre de facon découpée
		for(int i = 0; i<cle.length;i++) {
			System.out.println("regex: "+ i +" "+ cle[i]);
		}
		
		automata[0][1] = cle[0];
		automata[1][2] = cle[1];
		automata[2][2] = cle[2];
		automata[2][3] = cle[3];
		automata[3][4] = cle[4];
		automata[0][4] = cle[5];
		
		this.automata = automata;
		
	}

	public boolean find(String line) {
		
		for(int i = 0; i < line.length(); i++) {
			
			if(accept(i, line)) {
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
}