import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Karan Vombatkere
//Feb 12, 2018

//Class structure for a node, to facilitate node based searching
public class Node {
	
	//Each node has a state
	State nodeState;
	
	//Constructor to create a new node with the state
	public Node(State initialState) {
		this.nodeState = initialState;
	}
	
	//Method to return the state of the node after making a copy
	public State getState() {
		int[] currentStateArr = Arrays.copyOf(this.nodeState.queenPos, this.nodeState.queenPos.length);
		State currState = new State(currentStateArr);
		
		return currState;
	}
	
	
	//Method to return a list of nodes
	//For the 8 queens problem we return a list of neighboring states
	public List<Node> expand(){
		//Create a new list to store list of neighbors
		List<Node> neighbors = new ArrayList<Node>();
		int queenPosition = 0;
		
		for(int i=0; i<8; i++) {//row index
			
			for(int j=0; j<8; j++) {//column index
				
				//Get the position of the queen in the i'th row
				queenPosition = this.nodeState.queenPos[i];
				
				//Add a possible queen position to the list for each i
				if(j != queenPosition) {
					//Create a new state and update the moved queen
					State neighborState = new State(this.getState().queenPos);

					neighborState.queenPos[i] = j;
					//System.out.println(Arrays.toString(neighborState.queenPos));

					
					//Create a new node for the each neighbor
					Node newNeighbor = new Node(neighborState);
					
					neighbors.add(newNeighbor);
				}
			}
		}
		System.out.println("Expanded Node: " + Arrays.toString(this.nodeState.queenPos));
		
		return neighbors;	
	}
	
}
