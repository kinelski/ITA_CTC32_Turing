package turing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class FileManager {

	// METODOS DE LEITURA DE ARQUIVOS====================================================
	public static void readInstructionsFromFile (TuringMachine turing, String path){
		try{
			FileInputStream stream = new FileInputStream(path);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String input;
			
			while ((input = reader.readLine()) != null){
				String[] split = input.split(" ");
				
				if (split.length < 5)
					continue;
				
				int startState = Integer.parseInt(split[0]);
				char readSymbol = split[1].charAt(0);
				int finalState = Integer.parseInt(split[2]);
				char writeSymbol = split[3].charAt(0);
				char move = split[4].charAt(0);
				
				if (move == 'L')
					turing.addInstruction(startState, readSymbol, finalState, writeSymbol, Move.LEFT);
				if (move == 'R')
					turing.addInstruction(startState, readSymbol, finalState, writeSymbol, Move.RIGHT);
			}
			
			reader.close();
			stream.close();
		}
		
		catch (Exception e){
			System.out.println("Could not find file: " + path);
		}
	}
	
	public static void readFinalStatesFromFile (TuringMachine turing, String path){
		try{
			FileInputStream stream = new FileInputStream(path);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String input;
			
			while ((input = reader.readLine()) != null){
				String[] split = input.split(" ");
				
				for (int i = 0; i < split.length; i++){
					int finalState = Integer.parseInt(split[i]);
					turing.addFinalState(finalState);
				}
			}
			
			reader.close();
			stream.close();
		}
		
		catch (Exception e){
			System.out.println("Could not find file: " + path);
		}
	}
	
	public static void readStartTapeFromFile (TuringMachine turing, String path){
		try{
			FileInputStream stream = new FileInputStream(path);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			
			turing.setStartTape(reader.readLine());
			
			reader.close();
			stream.close();
		}
		
		catch (Exception e){
			System.out.println("Could not find file: " + path);
		}
	}
	
	// METODOS DE ESCRITA DE ARQUIVOS====================================================
	public static void writeOutputToFile (TuringMachine turing, String path){
		try{
			PrintWriter writer = new PrintWriter(path);
			
			if (turing.getAccepted())
				writer.println("ACCEPTED");
			else
				writer.println("NOT ACCEPTED");
			
			writer.println(turing.getTape());
			
			writer.close();
		}
		
		catch (Exception e){
			System.out.println("Could not create file: " + path);
		}
	}
	
	public static void writeLogToFile (String log, String path){
		try{
			PrintWriter writer = new PrintWriter(path);
			
			writer.print(log);
			
			writer.close();
		}
		
		catch (Exception e){
			System.out.println("Could not create file: " + path);
		}
	}
	
}
