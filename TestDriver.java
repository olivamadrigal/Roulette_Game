// Lab6 simulate the Roulette game implementing a GameInterface; 
// RouletteWheel, RouletteSpot, RouletteTable and RouletteGame Classes
// Professor Lee-Klawender
// 29 November 2012
// Samira C. Oliva Madrigal

import java.util.*;
public class TestDriver {

	public static void main(String[] args)
	{	
		RouletteGame obj = new RouletteGame();
		boolean newGame;

		obj.initGame(); 
		obj.playGame();	
		newGame = true;
		
		while(newGame == true)
		{
			if(playAgain() == true)
			{
				obj.initGame();
				obj.playGame();	
			}
			else
				newGame = false;
		}

	}//_end:main
	
	//---------------------------------------------------
	public static boolean playAgain()
	{
		Scanner scanf = new Scanner(System.in);
		String again;
		System.out.printf("Play again?\n");
		again = scanf.nextLine();
		
		if(Character.toUpperCase(again.charAt(0))== 'N')
			return false;
		else
			return true;
		
	}//_end:playAgain

}//end:TestDriver
