package main;

import turing.Move;
import turing.TuringMachine;

public class Main {

	public static void addInstructions (TuringMachine tur){
		tur.addInstruction(0, 'a', 1, 'X', Move.RIGHT);
		tur.addInstruction(0, 'b', 8, 'X', Move.RIGHT);
		tur.addInstruction(0, 'c', 15, 'X', Move.RIGHT);
		
		tur.addInstruction(1, '1', 2, 'B', Move.RIGHT);
		tur.addInstruction(2, 'a', 3, 'B', Move.RIGHT);
		tur.addInstruction(2, 'b', 2, 'B', Move.RIGHT);
		tur.addInstruction(2, 'c', 2, 'B', Move.RIGHT);
		tur.addInstruction(2, 'B', 22, 'B', Move.LEFT);
		tur.addInstruction(3, 'a', 4, 'B', Move.RIGHT);
		tur.addInstruction(3, 'b', 5, 'X', Move.LEFT);
		tur.addInstruction(3, 'c', 5, 'X', Move.LEFT);
		tur.addInstruction(3, 'B', 5, 'X', Move.LEFT);
		tur.addInstruction(4, 'a', 4, 'B', Move.RIGHT);
		tur.addInstruction(4, 'b', 2, 'B', Move.RIGHT);
		tur.addInstruction(4, 'c', 2, 'B', Move.RIGHT);
		tur.addInstruction(4, 'B', 22, 'B', Move.LEFT);
		tur.addInstruction(5, 'B', 5, 'B', Move.LEFT);
		tur.addInstruction(5, 'X', 6, '0', Move.RIGHT);
		tur.addInstruction(6, 'B', 7, 'X', Move.RIGHT);
		tur.addInstruction(7, 'B', 7, 'B', Move.RIGHT);
		tur.addInstruction(7, 'X', 2, 'B', Move.RIGHT);
		
		tur.addInstruction(8, '1', 9, 'B', Move.RIGHT);
		tur.addInstruction(9, 'a', 9, 'B', Move.RIGHT);
		tur.addInstruction(9, 'b', 10, 'B', Move.RIGHT);
		tur.addInstruction(9, 'c', 9, 'B', Move.RIGHT);
		tur.addInstruction(9, 'B', 22, 'B', Move.LEFT);
		tur.addInstruction(10, 'a', 12, 'X', Move.LEFT);
		tur.addInstruction(10, 'b', 11, 'B', Move.RIGHT);
		tur.addInstruction(10, 'c', 12, 'X', Move.LEFT);
		tur.addInstruction(10, 'B', 12, 'X', Move.LEFT);
		tur.addInstruction(11, 'a', 9, 'B', Move.RIGHT);
		tur.addInstruction(11, 'b', 11, 'B', Move.RIGHT);
		tur.addInstruction(11, 'c', 9, 'B', Move.RIGHT);
		tur.addInstruction(11, 'B', 22, 'B', Move.LEFT);
		tur.addInstruction(12, 'B', 12, 'B', Move.LEFT);
		tur.addInstruction(12, 'X', 13, '0', Move.RIGHT);
		tur.addInstruction(13, 'B', 14, 'X', Move.RIGHT);
		tur.addInstruction(14, 'B', 14, 'B', Move.RIGHT);
		tur.addInstruction(14, 'X', 9, 'B', Move.RIGHT);
		
		tur.addInstruction(15, '1', 16, 'B', Move.RIGHT);
		tur.addInstruction(16, 'a', 16, 'B', Move.RIGHT);
		tur.addInstruction(16, 'b', 16, 'B', Move.RIGHT);
		tur.addInstruction(16, 'c', 17, 'B', Move.RIGHT);
		tur.addInstruction(16, 'B', 22, 'B', Move.LEFT);
		tur.addInstruction(17, 'a', 19, 'X', Move.LEFT);
		tur.addInstruction(17, 'b', 19, 'X', Move.LEFT);
		tur.addInstruction(17, 'c', 18, 'B', Move.RIGHT);
		tur.addInstruction(17, 'B', 19, 'X', Move.LEFT);
		tur.addInstruction(18, 'a', 16, 'B', Move.RIGHT);
		tur.addInstruction(18, 'b', 16, 'B', Move.RIGHT);
		tur.addInstruction(18, 'c', 18, 'B', Move.RIGHT);
		tur.addInstruction(18, 'B', 22, 'B', Move.LEFT);
		tur.addInstruction(19, 'B', 19, 'B', Move.LEFT);
		tur.addInstruction(19, 'X', 20, '0', Move.RIGHT);
		tur.addInstruction(20, 'B', 21, 'X', Move.RIGHT);
		tur.addInstruction(21, 'B', 21, 'B', Move.RIGHT);
		tur.addInstruction(21, 'X', 16, 'B', Move.RIGHT);
		
		tur.addInstruction(22, 'B', 22, 'B', Move.LEFT);
		tur.addInstruction(22, 'X', 23, 'B', Move.RIGHT);
		
		tur.addFinalState(23);
	}
	
	public static void main (String[] args){
		TuringMachine tur = new TuringMachine("c1abcabaabccbcaababababaaaaabacccabababbabbbbababaaaaaccccc");
		
		addInstructions(tur);
		tur.run();
		
		System.out.println(tur.getAccepted());
		System.out.println(tur.getTape());
	}
	
}
