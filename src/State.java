//Karan Vombatkere
//Feb 12, 2018

//Specify State for 8 Queens
public class State {
	
	//Integer Array that keeps track of the column position of the queens in each row
	int[] queenPos;
	
	//Constructor to instantiate a state
	public State(int[] initialPos) {
		this.queenPos = initialPos;
	}
	
	
	//Method to display the queens on the board
	public void displayBoard() {
		System.out.println("Displaying Board State for 8 Queens:");
		System.out.println("---------------------------------");

		for(int i = 0; i<8 ; i++) {//index for rows
			
			for(int j = 0; j< 8; j++) {//index for columns
				
				if(j == this.queenPos[i]) {//Print a queen if a queen exists in the column
					System.out.print("| Q ");
				}
				else {
					System.out.print("|   ");//print a blank if queen is not in that location
				}
			}
			System.out.print("|");
			System.out.println("\n---------------------------------");

		}
	}
	
}
