package main;

import turing.Move;
import turing.TuringMachine;

public class Main {
	
	public static void main (String[] args){
		TuringMachine tur = new TuringMachine();
		
		tur.addInstructionsFromFile("instructions.txt");
		tur.addFinalStatesFromFile("final_states.txt");
		tur.setStartTapeFromFile("start_tape.txt");
		
		tur.run();
		tur.writeOutputToFile("output.txt");
		tur.writeLogToFile("log.txt");
	}
	
}
