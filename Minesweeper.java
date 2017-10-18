
package minesweeper;


public class Minesweeper {

   
    public static void main(String []args)
    {
       
		int x = 20;		//Width of the board
		int y = 20;		//Height of the board
		int d = 25;		//The difficulty of the game, the percentage of mines in the board. The number of mines per board is random, but this number is the probability that a cell will become
					//a mine.
 
		new Mining(x, y, d);
    
}
}
    
