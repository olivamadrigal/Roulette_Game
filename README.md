# Roulette_Game
Roulette Wheel Game in Java

# Instructions
Write an interface called GameInterface which has only abstract instance methods called initGame, playGame, and
displayResults. Each of these methods have an no parameters & no return value (void).

Write a Java program to play Roulette (with the European wheel, simplified version) with one user/player. Prog. 6 will be the console version, and Prog. 7 will be the GUI version. Both Prog. 6 & 7 versions will use many of the same classes and methods. 

The simplified game to play is described below.
The following classes are to be included (with ONLY instance methods): RouletteWheel (see 1. below), RouletteSpot (see 2. below), RouletteTable (see 3. below). You will also have a RouletteGame (see 4. below). (Optional: write a class for RoulettePlayer)

1. The RouletteWheel class should contain private instance variables for the "chosen" number (int between 0 and 36, inclusive, where 0 and 36 are public static final constants) and an array of 37 elements, where each element is boolean (true if red, false if black) OR an enumerated type for RED and BLACK OR Color. The constructor OR DECLARATION should initialize the array so each element has its correct color (see game description). Include instance methods to "spin the wheel" (use the random method in the Math class to get a number 0 - 36, inclusive), another to return the "chosen" int, and another to return the "chosen" int's color.

2. The RouletteSpot class represent sone betting spot on the
roulette table, and should contain private instance variables for its payoff (assume payoff:1), and the user's bet on that
"spot". The constructor should assign the payoff parameter to the payoff instance variable, and leave the bet as 0. Include accessors for each variable, a mutator for the bet, and a method to return the winnings on the spot (payoff*bet + bet).
Optional: Each spot may have an array of bets to allow for multiple players, but this will be harder to implement in the GUI (Prog7) version.

3. The RouletteSpot class contains all the possible bet spots (several RouletteSpot objects) as private instance variables. The ones required for this assignments are:
odd, even, red, black (each have 1:1 payoff) (NOTE: 0 is NONE of these)
1st third (1-12), 2nd third (13-24), and 3rd third (25-36) (each have 2:1 payoff)
an array of RouletteSpot objects for 0 to 36, inclusive (each have 35:1 payoff).
Include a public instance method for initializing all RouletteSpot's bet to 0. Include public instance methods for assigning a bet to each of the above RouletteSpots (calling its mutator). You should have one method with another parameter for the number RouletteSpot (0-36). Include public instance methods for returning the winnings for each spot.
Optional: You may put all the spots in one array, but if you do, you MUST declare public static constants for the non-single number spots (for example, public static final int ODD = 37;).

4. The Roulette Game class implements GameInterface,and contains private instance variables for a RouletteTable, a RouletteWheel. Optional: a RoulettePlayer OR an int for the player's money. The constructor should instantiate the RouletteTable and RouletteWheel. Override the initGame method (should call the RouletteTable's initialize method). Override the playGame method to get one or more bets from the user (this MUST be another method-- allow more than one spot to be bet on), then spin the wheel, then call displayResults. Override displayResults so it displays the winning number, and what the winnings are (could either display each winning spot separately, or just the total).
