package turing;

class Instruction {

	private int startState;
	private char readSymbol;
	
	public int finalState;
	public char writeSymbol;
	public Move move;
	
	public Instruction (int startState, char readSymbol, int finalState, char writeSymbol, Move move){
		this.startState = startState;
		this.readSymbol = readSymbol;
		
		this.finalState = finalState;
		this.writeSymbol = writeSymbol;
		this.move = move;
	}
	
	public int getStartState(){
		return startState;
	}
	
	public char getReadSymbol(){
		return readSymbol;
	}
	
}
