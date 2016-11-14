package turing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TuringMachine {

	/*
	 * Default:
	 * Estado inicial: 0
	 * Estado final: nenhum
	 */
	
	private boolean accepted;
	private boolean stopped;
	private int state;
	
	private Tape tape;
	private List<Instruction> instructions;
	private Set<Integer> finalStates;
	
	public TuringMachine (String startTape){
		accepted = false;
		stopped = false;
		state = 0;
		
		tape = new Tape(startTape);
		instructions = new ArrayList<Instruction>();
		finalStates = new TreeSet<Integer>();
	}
	
	public void addInstruction (int startState, char readSymbol, int finalState, char writeSymbol, Move move){
		for (Instruction inst : instructions){
			if (inst.getStartState() == startState && inst.getReadSymbol() == readSymbol){
				inst.finalState = finalState;
				inst.writeSymbol = writeSymbol;
				inst.move = move;
				
				return;
			}
		}
		
		Instruction inst = new Instruction(startState, readSymbol, finalState, writeSymbol, move);
		instructions.add(inst);
	}
	
	public void addFinalState (int state){
		finalStates.add(state);
	}
	
	public void run(){
		while (!stopped)
			clock();
		
		accepted = finalStates.contains(state);
	}
	
	public String getTape(){
		return tape.getTape();
	}
	
	public boolean getAccepted(){
		return accepted;
	}
	
	private void clock(){
		char readSymbol = tape.read();
		
		for (Instruction inst : instructions){
			if (inst.getStartState() == state && inst.getReadSymbol() == readSymbol){
				state = inst.finalState;
				tape.write(inst.writeSymbol);
				
				if (inst.move == Move.LEFT)
					tape.moveLeft();
				else
					tape.moveRight();
				
				return;
			}
		}
		
		stopped = true;
	}

}
