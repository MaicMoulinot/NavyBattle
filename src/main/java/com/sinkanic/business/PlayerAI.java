/**
 * 
 */
package com.sinkanic.business;

import java.util.ArrayList;
import java.util.Random;

import com.sinkanic.ships.AircraftCarrier;
import com.sinkanic.ships.Battleship;
import com.sinkanic.ships.PatrolBoat;
import com.sinkanic.ships.Ship;
import com.sinkanic.ships.Submarine;

/**
 * @author humanbooster
 *
 */
public class PlayerAI extends Player {
	
	public PlayerAI() {
		super("AI");
		fleet = new ArrayList<Ship>();
		nbTries = 0;
	}
	
	public Cell getRandomCell(int tailleGrilleHorizontal, int tailleGrilleVertical) {
		incrementNbEssais();
		Random randomGenerator = new Random();
	    int randomHorizontal = randomGenerator.nextInt(tailleGrilleHorizontal-1);
	    int randomVertical = 0;
	    if (tailleGrilleVertical > 1) {
	    	randomVertical = randomGenerator.nextInt(tailleGrilleVertical-1);
	    }
	    Cell guessedCell = new Cell(randomHorizontal, randomVertical);
//		int X = 0;
//		int Y = 0;
//		int line = 0;
//		while (nbTries <= (tailleGrilleHorizontal*tailleGrilleVertical) && line < tailleGrilleVertical) {
//			if (nbTries <= ((line+1)*tailleGrilleHorizontal)) {
//				X = (tailleGrilleHorizontal - 1) - (tailleGrilleHorizontal * (line + 1) - nbTries);
//				Y = line;
//				break;
//			} else {
//				line++;
//			}
//		}
//		Cell guessedCell = new Cell(X, Y);
		return guessedCell;
	}
	
	public void createRandomBoat(int tailleGrilleHorizontal, int tailleGrilleVertical, int tailleBateau) {
		Random randomGenerator = new Random();
		boolean isVertical = (randomGenerator.nextInt(2) == 0);
		createRandomBoat(tailleGrilleHorizontal, tailleGrilleVertical, tailleBateau, isVertical);
	}
	
	public void createRandomBoat(int tailleGrilleHorizontal, int tailleGrilleVertical, int tailleBateau, boolean isVertical) {
		int X = 0;
		int Y = 0;
		Random randomGenerator = new Random();
		Ship bateau = null;
		do {
			if(isVertical) {
				X = randomGenerator.nextInt(tailleGrilleHorizontal);
				if (tailleGrilleVertical > tailleBateau) {
					Y = randomGenerator.nextInt(tailleGrilleVertical - tailleBateau);
				}
			} else {
				Y = randomGenerator.nextInt(tailleGrilleVertical);
				if (tailleGrilleHorizontal > tailleBateau) {
					X = randomGenerator.nextInt(tailleGrilleHorizontal - tailleBateau);
				}
			}
			// instantiate proper ship type
			switch (tailleBateau) {
			case 5:
				bateau = new AircraftCarrier(X, Y, isVertical);
				break;
			case 4:
				bateau = new Battleship(X, Y, isVertical);
				break;
			case 3:
				bateau = new Submarine(X, Y, isVertical);
				break;
			case 2:
				bateau = new PatrolBoat(X, Y, isVertical);
				break;
			}
		} while (!isBoatAddable(bateau, tailleGrilleHorizontal, tailleGrilleVertical));
		fleet.add(bateau);
	}
}
