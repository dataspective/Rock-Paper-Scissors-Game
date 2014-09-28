/**
 * 2014-9-27
 * @author Derek Fermaint
 *
 * Program to play game of rock, paper, scissors against computer
 * 
 * Random number generated between 1-3 without displaying it to the user
 * 	1 == rock
 * 	2 == paper
 *	3 == scissors
 * 
 * User enters own choice of rock, paper, scissors at keyboard
 * 
 * Display computer's choice
 * 
 * Compute winner
 * 	rock over paper
 * 	paper over scissors
 * 	scissors over paper
 * 	tie if both are the same
 * 
 * Displays winner
 */
import java.util.Scanner;

public class RockPaperScissors {
	private int compIRandom;
	private int humIChoice;
	private String compSRandom;
	private String humSChoice;
	private String humKChoice;
	private String humCapChoice;
	
	//wanted to minimize references
	private final int ONE = 1;
	private final int TWO = 2;
	private final int THREE = 3;
	
	//new scanner
	Scanner in = new Scanner(System.in);
	
	/**
	 * constructor that calls computerChoice() and humanChoice()
	 * humanChoice() calls displayWinner() inside itself
	 */
	public RockPaperScissors() 
	{
		computerChoice();
		humanChoice();
	}
	
	/**
	 * generates random number from 1 to 3
	 * if 1 then rock
	 * if 2 then paper
	 * if 3 then scissors
	 * for whatever reason if there's an issue with the Math method, it
	 * will display an error message; just in case.
	 */
	public void computerChoice()
	{
		compIRandom = (int) (Math.ceil(Math.random() * THREE));
		if (compIRandom == ONE)
		{
			compSRandom = "Rock";
		}
		else if (compIRandom == TWO)
		{
			compSRandom = "Paper";
		}
		else if (compIRandom == THREE) 
		{
			compSRandom = "Scissors";
		}
		else 
		{
			System.out.println("Error in: 'computerChoice()' please review method");
		}
	}
	
	/**
	 * first message that user sees, this prompts user to enter rock, paper or scissors
	 * turns the user's entered characters into lower case for the if block to make a decision
	 * if block does three things:
	 * 		creates an integer value for the user choice
	 * 		creates a capitalized version of the string value of the user choice
	 * 		calls the displayWinner()
	 * if the user enters a string character value that wasn't prompted, the computer
	 * will display that there's an error, and then reinitialize the method itself for the user
	 */
	public void humanChoice()
	{
		System.out.print("Hello, and welcome to Rock, Paper, Scissors. Please try to beat the computer in this game.\n");
		System.out.print("Start by choosing either rock, paper or scissors. \nEnter it into the console now: ");
		humKChoice = in.nextLine();
		
		humSChoice = humKChoice.toLowerCase();
		
		if (humSChoice.equals("rock"))
		{
			humIChoice = ONE;
			humCapChoice = humSChoice.substring(0,1).toUpperCase() + humSChoice.substring(1);
			
			displayWinner();
		}
		else if (humSChoice.equals("paper"))
		{
			humIChoice = TWO;
			humCapChoice = humSChoice.substring(0,1).toUpperCase() + humSChoice.substring(1);
			
			displayWinner();
		}
		else if (humSChoice.equals("scissors") || humSChoice.equals("scissor"))
		{
			humIChoice = THREE;
			humCapChoice = humSChoice.substring(0,1).toUpperCase() + humSChoice.substring(1);
			
			displayWinner();
		}
		else
		{
			System.out.println("WARNING: There was an error in your submission, please retype.\n\n\n");
			humanChoice();
		}
	}
	
	/**
	 * uses a nested if block, parent block makes sure that its parent method (humanChoice()) was passed accurately, then it
	 * compares the human choice and computer choice from their integer values
	 * if both are the same, displays a tie
	 * if computer has anything that follows the traditional rock, paper, scissors rules, as a winner
	 * 		 then will display to the user that they've lost
	 * if user has anything that that follows the traditional rock, paper, scissors rules, as a winner
	 * 		then will display to the suer that they've won
	 * for any reason if there's an error, displays that there's an error in this method
	 */
	public void displayWinner()
	{
		if (humIChoice == ONE || humIChoice == TWO || humIChoice == THREE)
		{
			System.out.println("You chose: " + humCapChoice);
			System.out.println("The computer chose: " + compSRandom);
			
			if (compIRandom == humIChoice)
			{
				System.out.println("There's a tie!");
			}
			else if ((compIRandom == ONE && humIChoice == THREE) || (compIRandom == TWO && humIChoice == ONE) || (compIRandom == THREE && humIChoice == TWO))
			{
				System.out.println("I'm sorry, but human intelligence is ancient technology. You lose!");
			}
			else
			{
				System.out.println("Congratulations! Man is still smarter than its machines. You win!");
			}
		}
		else
		{
			System.out.println("Error in 'humanChoice() please review method");
		}
	}

}
