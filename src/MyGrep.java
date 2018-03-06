public class MyGrep {
	
	private char[][] automata;
	
	public MyGrep(char[][] automata) {	
		
		automata[0][1] = 'T';
		automata[1][2] = 'a';
		automata[2][2] = 'm';
		automata[2][3] = 'u';
		automata[3][4] = 'S';
		automata[0][4] = 'E';
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