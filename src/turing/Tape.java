package turing;

class Tape {

	public static int TAPE_SIZE = 1000;
	
	private char[] tape;
	private int index;
	
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
			if (i < start.length())
				tape[i] = start.charAt(i);
			else
				tape[i] = 'B';
		}
		
		if (start.length() > TAPE_SIZE)
			System.out.println ("WARNING: string exceeds maximum tape size.");
	}
	
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
	
	public char read(){
		return tape[index];
	}
	
	public void write (char symbol){
		tape[index] = symbol;
	}
	
	public String getTape(){
		StringBuilder stringTape = new StringBuilder();
		
		for (int i = 0; i < TAPE_SIZE; i++)
			stringTape.append(tape[i]);
		
		return stringTape.toString();
	}
}
