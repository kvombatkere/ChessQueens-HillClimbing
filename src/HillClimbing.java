import java.util.Arrays;

//Karan Vombatkere
//Feb 12, 2018

//Hill Climbing Algorithm for 8 Queens
public class HillClimbing {
	
	static State hillClimb(Problem p) {
		 Node node = new Node(p.getInitialState());
		 System.out.println("Performing Hill Climbing Greedy Local Search");
		 System.out.println("Node p Initial State:" + Arrays.toString(p.getInitialState().queenPos) + " with value ="+ p.value(node));

		 while (true) {
			 
			 Node next = null;
			 for (Node n : node.expand()) {
				 //Use strict inequality to facilitate faster descent/ascent
				 if (p.value(n) < p.value(node)) {
					 next = n;
					 node = n;
					 p.numMoves++;
					 System.out.println("State Chosen:" + Arrays.toString(n.nodeState.queenPos) + " with value ="+ p.value(n));

				 }
			 }
			 
			 if (next == null) {
				 return node.getState();
			 } else {
				 node = next;
			 }
		 }
	}
	
	
	//Main method to test/run code
	public static void main(String[] args) {
		System.out.println("==================================================================");
		Problem testQueens = new Problem();
		testQueens.currentState.displayBoard();
		System.out.println("==================================================================");

		//Perform random restart to guarantee a solution is found
		while(true) {
			testQueens.currentState = hillClimb(testQueens);
			
			if(testQueens.isGoal(testQueens.currentState)) {
				break;
			}
			//Restart if a solution state is not found
			testQueens.setInitialState();
		}
		
		//Display Final Output
		System.out.println("==================================================================");
		System.out.println("Number of Moves to Solution: "+ testQueens.numMoves);
		System.out.println("Number of Random Restart iterations to Solution: "+ testQueens.numAttempts);
		testQueens.currentState.displayBoard();

	}
	
}
