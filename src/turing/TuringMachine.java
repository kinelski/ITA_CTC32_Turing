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
	private StringBuilder log;
	
	// CONSTRUTORES=======================================================================
	public TuringMachine(){
		reset();
	}
	
	public TuringMachine (String startTape){
		reset();
		setStartTape(startTape);
	}
	
	// METODOS PARA CONSTRUIR A MT=======================================================
	public void reset(){
		accepted = false;
		stopped = false;
		state = 0;
		
		tape = new Tape();
		instructions = new ArrayList<Instruction>();
		finalStates = new TreeSet<Integer>();
		log = new StringBuilder();
	}
	
	public void setStartTape (String startTape){
		tape = new Tape(startTape);
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
	
	// METODOS PARA CONSTRUIR A MT POR MEIO DE ARQUIVOS TXT==============================
	public void addInstructionsFromFile (String path){
		FileManager.readInstructionsFromFile(this, path);
	}
	
	public void addFinalStatesFromFile (String path){
		FileManager.readFinalStatesFromFile(this, path);
	}
	
	public void setStartTapeFromFile (String path){
		FileManager.readStartTapeFromFile(this, path);
	}
	
	// METODOS DE OPERACAO DA MT=========================================================
	public void run(){
		while (!stopped){
			updateLog();
			clock();
		}
		
		accepted = finalStates.contains(state);
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
	
	private void updateLog(){
		log.append(tape.getTapeWithIndex() + " (State: " + state + ")\r\n");
	}
	
	// METODOS PARA OBTER O RESULTADO====================================================
	public String getLog(){
		return log.toString();
	}
	
	public String getTape(){
		return tape.getTape();
	}
	
	public boolean getAccepted(){
		return accepted;
	}
	
	// METODOS PARA ESCREVER O RESULTADO EM ARQUIVOS TXT=================================
	public void writeOutputToFile (String path){
		FileManager.writeOutputToFile(this, path);
	}
	
	public void writeLogToFile (String path){
		FileManager.writeLogToFile(log.toString(), path);
	}

}
