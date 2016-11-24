package turing;

class Tape {

	public static int TAPE_SIZE = 1000;
	
	private char[] tape;
	private int index;
	
	// CONSTRUTORES======================================================================
	public Tape(){
		tape = new char[TAPE_SIZE];
		index = 0;
		
		for (int i = 0; i < TAPE_SIZE; i++)
			tape[i] = 'B';
	}
	
	public Tape(String start){
		tape = new char[TAPE_SIZE];
		index = 0;
		
		for (int i = 0; i < TAPE_SIZE; i++){
			if (start != null && i < start.length())
				tape[i] = start.charAt(i);
			else
				tape[i] = 'B';
		}
		
		if (start.length() > TAPE_SIZE)
			System.out.println ("WARNING: string exceeds maximum tape size.");
	}
	
	// MOVIMENTO NA FITA=================================================================
	public void moveLeft(){
		if (index > 0)
			index--;
		else
			System.out.println ("WARNING: could not move left.");
	}
	
	public void moveRight(){
		if (index < TAPE_SIZE - 1)
			index++;
		else
			System.out.println ("WARNING: could not move right.");
	}
	
	// LEITURA E ESCRITA NA FITA=========================================================
	public char read(){
		return tape[index];
	}
	
	public void write (char symbol){
		tape[index] = symbol;
	}
	
	// METODOS PARA OBTER O ESTADO DA FITA===============================================
	public String getTape(){
		StringBuilder stringTape = new StringBuilder();
		int finalPos = finalPosition();
		
		for (int i = 0; i <= finalPos || i <= index; i++)
			stringTape.append(tape[i]);
		
		stringTape.append("BBB...");
		
		return stringTape.toString();
	}
	
	public String getTapeWithIndex(){
		StringBuilder stringTape = new StringBuilder();
		int finalPos = finalPosition();
		
		for (int i = 0; i <= finalPos || i <= index; i++){
			if (i == index)
				stringTape.append('>');
			stringTape.append(tape[i]);
		}
		
		stringTape.append("BBB...");
		
		return stringTape.toString();
	}
	
	public String getIndexPositionAsString(){
		StringBuilder indexPosition = new StringBuilder();
		
		for (int i = 0; i < index; i++)
			indexPosition.append(' ');
		
		indexPosition.append('^');
		
		return indexPosition.toString();
	}
	
	private int finalPosition(){
		int pos = TAPE_SIZE - 1;
		
		while (pos >= 0 && tape[pos] == 'B')
			pos--;
		
		return pos;
	}
	
}
