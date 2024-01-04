package code;

import java.util.Random;
import java.util.Scanner;

public class MontyHall {

	public static void main(String[] args) {
		boolean swapChoice;
		int prizeDoor=0;
		int usersChosenDoor=0;
		int doorToReveal=0;
		int usersSwappedDoor=0;
		
		int totalTrials=1000;
		int switchWins=0;
		int stayWins=0;
		
		Scanner kb = new Scanner(System.in);
		Random rando = new Random();
		
		for (int i = 0; i < totalTrials; i++) {
		prizeDoor=choosePrizeDoor(rando);
		
		System.out.println("There are three doors two of which have goats behind them\nwhile one of them has a car. pick door 1, 2 or 3.");
		usersChosenDoor=onlyPositive(kb);
		
		doorToReveal=findNumberException(usersChosenDoor,prizeDoor);
		
		//go through three numbers to reveal the door that is not users choice and not the prize door
		
		System.out.println("youve selected door "+usersChosenDoor+" Door "+doorToReveal+" has a goat\nbehind it now there is just one door left\nwould you like to switch doors? y/n");
		swapChoice=getAnAnswer(kb);
		
		if (swapChoice){
						usersSwappedDoor=findNumberException(usersChosenDoor,doorToReveal);
						usersChosenDoor=0;
					   }
		if  (usersSwappedDoor==prizeDoor||usersChosenDoor==prizeDoor) {
				System.out.println("Congrats you won a brand new car");
				if (usersSwappedDoor == prizeDoor) {
			        switchWins++;
			    								   } 
				else
					if(usersChosenDoor == prizeDoor) {
			        stayWins++;
													 }
			    													  }													  
		else {
				System.out.println("Im sorry you chose wrong but atleast you get to keep the goat.");	
			 }
		
		 
		double switchWinPercentage = (double) switchWins / totalTrials * 100;
		double stayWinPercentage = (double) stayWins / totalTrials * 100;

		System.out.println("Switch win percentage: " + switchWinPercentage + "%");
		System.out.println("Stay win percentage: " + stayWinPercentage + "%\n");
		}
		kb.close();
	}
	
	public static int choosePrizeDoor(Random random) {
	return random.nextInt(3) + 1;
	}
	
	public static int onlyPositive(Scanner kb) {
		int user=kb.nextInt();
		while((!(user>0))&&(!(user<=3))) {
			System.out.println("**Choose a number between 1 and 3**");
			  user=kb.nextInt();
										   }
		return user;
	}
	
	private static int findNumberException(int notThisOne, int notThisTwo) {
		int foundANumber=0;
		for(int findANumber=1;findANumber<=3;findANumber++) {
			if((findANumber!=notThisOne)&&(findANumber!=notThisTwo)) {
			    foundANumber = findANumber;
			  												 	 	 }
										  					}
		return foundANumber;
	}
	
	public static boolean getAnAnswer(Scanner kb) {
		 char answer = kb.next().charAt(0);
		    return answer == 'y' || answer == 'Y';
	}
}