package ordon.marek.adventofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ordon.marek.adventofcode.Day1.Direction;

public class Day1_2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] tab = line.split(", ");
		int[] position = {0,0};
		List<Pair<Integer,Integer>> list = new ArrayList<Pair<Integer,Integer>>();
		Pair<Integer,Integer> location = new Pair<Integer,Integer>(Integer.valueOf(position[0]),Integer.valueOf(position[1]));
		list.add(location);
		Direction currentDirection = Direction.NORTH;
		char where = 'R';
		int whereInt =0;
		for (int i = 0; i < tab.length; i++) {	
			where = tab[i].charAt(0);
			whereInt = Integer.parseInt(tab[i].substring(1));
			currentDirection = changeDirection(currentDirection, where);
			walk(position,currentDirection,whereInt,list);
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
			
//			System.out.println(position[0]+" "+position[1]);
//			location = new Pair<Integer,Integer>(Integer.valueOf(position[0]),Integer.valueOf(position[1]));
//			if(list.contains(location)){
//				System.out.println("===============================");
//				System.out.println(location.getLeft()+" "+location.getRight());
//				System.out.println((Math.abs(position[0])+Math.abs(position[1])));
//				System.out.println("===============================");
//				break;
//			}
//			list.add(location);
			
		}
		System.out.println((Math.abs(position[0])+Math.abs(position[1])));
	}
	
	public static void walk(int[] position, Direction d,int distance, List<Pair<Integer,Integer>> list){
		int[] currentPosition = {position[0], position[1]};
		Pair<Integer,Integer> location;
		for(int i =0; i<distance; i++){
			switch (d){
				case NORTH:
					currentPosition[1] = currentPosition[1]+1;
					location = new Pair<Integer,Integer>(Integer.valueOf(currentPosition[0]),Integer.valueOf(currentPosition[1]));
					break;
				case SOUTH:
					currentPosition[1] = currentPosition[1]-1;
					location = new Pair<Integer,Integer>(Integer.valueOf(currentPosition[0]),Integer.valueOf(currentPosition[1]));
					break;
				case WEST:
					currentPosition[0] = currentPosition[0]-1;
					location = new Pair<Integer,Integer>(Integer.valueOf(currentPosition[0]),Integer.valueOf(currentPosition[1]));
					break;
				case EAST:
					currentPosition[0] = currentPosition[0]+1;
					location = new Pair<Integer,Integer>(Integer.valueOf(currentPosition[0]),Integer.valueOf(currentPosition[1]));
					break;
				default:
					location = new Pair<Integer,Integer>(Integer.valueOf(currentPosition[0]),Integer.valueOf(currentPosition[1]));
					break;
			}
			
//			System.out.println("-------------------------------");
//			System.out.println(location.getLeft()+" "+location.getRight());
//			System.out.println("-------------------------------");
			if(list.contains(location)){
				System.out.println("===============================");
				System.out.println(location.getLeft()+" "+location.getRight());
				System.out.println((Math.abs(currentPosition[0])+Math.abs(currentPosition[1])));
				System.out.println("===============================");
				break;
			}
			
			list.add(location);
		}
		
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

