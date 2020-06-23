import java.util.Arrays;

//Karan Vombatkere
//Feb 12, 2018

//Class to specify the 8 queens problem
public class Problem {
	
	public State currentState;
	public State initialState;
	
	public int numMoves;
	public int numAttempts;
	
	//Constructor -> instantiate with random initial state
	public Problem(){
		//Call Method to generate a random initial state and initialize other Variables
		this.numAttempts = 0;
		this.setInitialState();
	}
	
	//Method to return a copy of the initial state of the problem
	public State getInitialState() {	
		int [] copyInitStatePos = Arrays.copyOf(this.initialState.queenPos, this.initialState.queenPos.length);
		State initState = new State(copyInitStatePos);
		
		return initState;
	}
	
	//Method to set the initial set again
	public void setInitialState() {
		this.initialState = this.genRandomState();
		this.currentState = this.getInitialState();
		//Reset number of moves and increment restart
		this.numMoves = 0;
		this.numAttempts++;
		System.out.println("New 8 Queen Board Problem Initialized!" + Arrays.toString(this.currentState.queenPos));
	}
	
	//Method to generate a random initial state
	public State genRandomState() {
		//Initialize required variable
		int [] newState = {0,0,0,0,0,0,0,0};
		
		//Fill Array with random values
		for(int i = 0; i<8 ; i++) {
			newState[i] = (int) (Math.random()*8); //generate a random number between 0 and 7
		}
		
		State randomState = new State(newState);//Create the state object with the queens randomly placed
		
		return randomState;
	}
	
	//Method to compute the value of a node based on its state
	//We use the heuristic of number of queens attacking each other
	public int value(Node n) {
		return this.stateValue(n.nodeState);
	}
	
	//Method to compute value of a state
	public int stateValue(State s) {
		//Specify integer that keeps track of number of pairs of queens attacking each other in a particular state
		int numPairs = 0;
		
		//Check if queens are in same column (same row is never possible)
		for(int j = 0; j < 8; j++) {//column index
			
			int queenCount = 0;
			
			for(int i = 0; i < 8; i++) {//row index
				//Count number of queens in a column
				if(s.queenPos[i] == j) {
					queenCount++;
				}
			}
			numPairs += this.numDistinctPairs(queenCount);
		}
		//System.out.println("Number of distinct pairs of Queens in Same Column = "+numPairs);
		int queenCount = 0;

		//Check diagonals for each queen
		for(int q=0; q<8;q++) {//each column

			int p = s.queenPos[q]; //get the coordinates of queen in that column (p,q)

			//Once we have position of queen check all diagonals wrt to this queen
			//Now condition for element(x,y) to lie on diagonal coordinates of board element (p,q) would be p+q == x+y or p-q == x-y 
			for(int x = 0; x < 8; x++) {
				for(int y = 0; y < 8; y++) {
					if((p+q)==(x+y) || (p-q)==(x-y)) { //condition for diagonal element wrt to p,q
						if((s.queenPos[y] == x)&&(p!=x && q!=y)) {
							queenCount++;
						}
					}
						
				}
			}

		}
		numPairs += this.numDistinctPairs(queenCount);

		return numPairs;		
	}
	
	//Method to compute the number of queens in a diagonal
	
	
	//Method to recognize a goal state
	public boolean isGoal(State s) {
		if(stateValue(s) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Method to return nC2 or number of pairs given n Queens
	public int numDistinctPairs(int n) {
		//There are no pairs possible if n < 2
		if(n <= 1) {return 0;}
		
		else { //Return n(n-1)/2 pairs for n >= 2
			int distinctPairs = ((n)*(n-1))/(2);
			return distinctPairs;	
		}
	}
	
}
