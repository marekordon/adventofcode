package ordon.marek.adventofcode;

import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] tab = line.split(", ");
		int[] position = {0,0};
		Direction currentDirection = Direction.NORTH;
		char where = 'R';
		int whereInt =0;
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
			where = tab[i].charAt(0);
			whereInt = Integer.parseInt(tab[i].substring(1));
			currentDirection = changeDirection(currentDirection, where);
			System.out.println(currentDirection+" "+whereInt);
			switch (currentDirection){
				case NORTH:
					position[1] = position[1]+whereInt;
					break;
				case SOUTH:
					position[1] = position[1]-whereInt;
					break;
				case WEST:
					position[0] = position[0]-whereInt;
					break;
				case EAST:
					position[0] = position[0]+whereInt;
					break;
				default:
					break;
			}
			System.out.println(position[0]+", "+position[1]);
		}
		System.out.println((Math.abs(position[0])+Math.abs(position[1])));
//		System.out.println(position[0]);
//		System.out.println(position[1]);
	}
	
	private static Direction changeDirection(Direction current, char where){
		switch(current){
			case NORTH:
				if(where=='R')
					return Direction.EAST;
				else 
					return Direction.WEST; 
			case SOUTH:
				if(where=='R')
					return Direction.WEST;
				else
					return Direction.EAST;
			case WEST:
				if(where=='R')
					return Direction.NORTH;
				else
					return Direction.SOUTH;
			case EAST:
				if(where=='R')
					return Direction.SOUTH;
				else 
					return Direction.NORTH;
			default:
				return Direction.NORTH;
		}
	}
	
	public enum Direction {
		NORTH, SOUTH, EAST, WEST
	}

}

