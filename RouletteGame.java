//RouletteGame Class
//Samira C. Oliva Madrigal

import java.util.*;
import java.lang.*;

public class RouletteGame implements GameInterface {

	private RouletteWheel  rWheel;
	private RouletteTable  rTable;
	private double player;
	Scanner scanf = new Scanner(System.in);
	
	//---------------------------------------------
	//Instantiate the RouletteTable & RouletteWheel
	public RouletteGame()
	{		
		rWheel     = new RouletteWheel(); 
		rTable     = new RouletteTable();
	}//_end:constructor
	
	//	rTable.userRouletteSpotNumber(spotOrNum);
	//-----------------------------------------------
	public void displayOptions(){
		
		System.out.println("Bet Choices");
		System.out.println("0 - 36: Play");
		System.out.println("O: Play Odd");
		System.out.println("E: Play Even");
		System.out.println("R: Play Red");
		System.out.println("B: Play Black");
		System.out.println("F: Play first 1/3 (1-12)");
		System.out.println("S: Play second 1/3 (13-24)");
		System.out.println("T: Play third 1/3 (25-36)");
	}//_end:displayOptions
	
	//-----------------------------------------------
	public void initGame(){
		
		rTable.initilializeRSbets();
		
	}//_end:initGame()
		
	//-----------------------------------------------
	public void playGame(){
		promptUserForBets();
		rWheel.spinTheWheel();
		displayResults();
	}//_end:initGame()
		
	//-----------------------------------------------
	public void displayResults(){
		int num;
		RouletteWheel.COLOUR c;
		
		System.out.printf("The winning number is = %d\n", rWheel.getChosenNum());
		if(rWheel.getChosenIntColour() == RouletteWheel.COLOUR.RED)
			System.out.printf("The color is red\n");
		else if(rWheel.getChosenIntColour() == RouletteWheel.COLOUR.BLACK)
			System.out.printf("The color is black\n");
		else 
			System.out.printf("The color is green\n");
		num = rWheel.getChosenNum();
		c   = rWheel.getChosenIntColour();
		player = rTable.totalWinnings(num, c);
		System.out.printf("You won $%.2f\n", player);
		
	}//_end:displayResults()
	
	//-----------------------------------------------
	public void promptUserForBets()
	{
		String   spotOrNum;
		String   continueBets;
		String   userBet;
		boolean  moreBets;
		boolean  invalidBet;
		boolean  invalidSpot;
		char     next;
		int      testSpot;

		moreBets = true;
		while(moreBets)// cannot bet on same spot twice
		{
			displayOptions();
			System.out.printf("Enter your choice: ");
			spotOrNum = scanf.nextLine();
			
			if(spotOrNum.length() == 0)
				System.out.printf("Invalid bet choice-- no bet placed!\n");	
			else  //validate the betting spot
			{
				invalidSpot = true;		
				for(int idx = 0; idx < spotOrNum.length(); idx++)// at most length is 2 digits or a letter
				{
						if(!(Character.isDigit(spotOrNum.charAt(idx))) && !(Character.isLetter(spotOrNum.charAt(idx))))
							invalidSpot = false;//not a digit
				}//
				
				if(invalidSpot == true)// if it's a letter or a number
				{	
					if(!Character.isLetter(spotOrNum.charAt(0)))
					{	
						testSpot = Integer.parseInt(spotOrNum);
						if(!((testSpot >= RouletteWheel.min) && (testSpot <= RouletteWheel.max)))//verify range
								invalidSpot = false;
					}
					else //if it's exactly ONE letter
					{
						
					 if((spotOrNum.length() == 1))
						if(Character.toUpperCase(spotOrNum.charAt(0)) != 'O')
							if(Character.toUpperCase(spotOrNum.charAt(0)) != 'E')
								if(Character.toUpperCase(spotOrNum.charAt(0)) != 'R')
									if(Character.toUpperCase(spotOrNum.charAt(0)) != 'B')
										if(Character.toUpperCase(spotOrNum.charAt(0)) != 'F')
											if(Character.toUpperCase(spotOrNum.charAt(0)) != 'S')
												if(Character.toUpperCase(spotOrNum.charAt(0)) != 'T')
													invalidSpot = false; //none of the letters
					}
				}//_endVERIFY_THE_RANGE_AND_SPEC_INPUT
				if(invalidSpot == false)
					System.out.printf("Invalid Bet! Usage: (0-36), O, E, R, B, F, S, T.\n");
				if(invalidSpot == true) //if spot is valid, validate the bet on the spot
				{	
					System.out.printf("Enter you bet: ");
					userBet    = scanf.nextLine();
					invalidBet = true;
					if(userBet.length() > 0)
					{
						for(int idx = 0; idx < userBet.length(); idx++)// at most length is 2 digits
						{
							if(!(Character.isDigit(userBet.charAt(idx))))
								invalidBet = false;//not a digit
						}
					}
					else
						invalidBet = false;
					if(invalidBet == true)
							rTable.userRouletteSpotNumber(spotOrNum,Integer.parseInt(userBet));
					else
						System.out.println("Invalid Bet! Usage: (interger > 0).\n");
				}//_if
			}
			//---- MORE BETS
			System.out.printf("Continue with betting? (y for yes): ");
			continueBets = scanf.nextLine();
			System.out.println();
			next  = continueBets.charAt(0); 
			if((Character.toUpperCase(next)) == 'Y')
				moreBets = true;
			else
				moreBets = false;
		}
	}//_end:promptUserForBets
	
}//_end:RouletteGame 
