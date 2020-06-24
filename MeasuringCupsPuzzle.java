///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (MeasuringCupsPuzzle.java)
// File:             (MeasuringCupsSolver.java)
// Semester:         (Introduction to Data Structures) Fall 2016
//
// Author:           (Nhialee Yang nyang5@wisc.edu)
// CS Login:         (nhialee)
// Lecturer's Name:  (Alexander Brooks)
// Lab Section:      (N/A)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     (Yia Xiong)
// Email:            (yxiong58@wisc.edu)
// CS Login:         (yia)
// Lecturer's Name:  (Alexander Brooks)
// Lab Section:      (N/A)
//
//////////////////////////// 80 columns wide ///////////////////////////////////

import java.util.Iterator;

/**
 * A class describing the measuring cups puzzle with a startState
 * {@link MeasuringCupsPuzzleState} and a goalState
 * {@link MeasuringCupsPuzzleState}
 */
public class MeasuringCupsPuzzle {

	private MeasuringCupsPuzzleState startState;
	private MeasuringCupsPuzzleState goalState;

	private MeasuringCupsPuzzleADT measuringCupsPuzzleADT;

	private MeasuringCupsPuzzleStateList pathFromStartToGoal;
	private MeasuringCupsPuzzleStateList processedStates;
	private MeasuringCupsPuzzleState foundGoalState;

	/**
	 * Construct a puzzle object by describing the startState and goalState
	 *
	 * @param startState
	 *            a state describing the capacities and initial volumes of
	 *            measuring cups {@link MeasuringCupsPuzzleState}
	 * @param goalState
	 *            a state describing the desired end volumes of measuring cups
	 *            {@link MeasuringCupsPuzzleState}
	 */
	public MeasuringCupsPuzzle(MeasuringCupsPuzzleState startState,
			MeasuringCupsPuzzleState goalState) {

		this.startState = startState;
		this.goalState = goalState;

		this.pathFromStartToGoal = new MeasuringCupsPuzzleStateList();
		this.processedStates = new MeasuringCupsPuzzleStateList();
		this.foundGoalState = null;
		this.measuringCupsPuzzleADT = null;
	}

	/**
	 * Solve the measuring cups puzzle if it can be solved. Set processedStates
	 * by adding a {@link MeasuringCupsPuzzleState} graph node to the list as
	 * the algorithm visits that node. Set foundGoalState to a
	 * {@link MeasuringCupsPuzzleState} if the graph traversal algorithm labeled
	 * by *algorithm* visits a node with the same values as the desired
	 * goalState
	 *
	 * @param algorithm
	 *            a String describing how the puzzle will be solved; has a value
	 *            equal to the project configuration {@link Config} BFS or DFS;
	 *            e.g. "BFS"
	 * @return true if the puzzle can be solved (and has been solved, see
	 *         {@link retrievePath} to obtain the solution stored in this
	 *         object) and false otherwise
	 */
	public boolean findPathIfExists(String algorithm) {

		//choice of BFS or DFS is made
		//catch invalid algorithm exception and exit if neither BFS nor DFS
		//was passed in
		try {
			chooseADT(algorithm);
		} catch (Exception e) {
		System.out.println(Config.INVALID_ALGORITHM);
		System.exit(0);
		}


		//reset the state of the puzzle
		resetCupPuzzle();

		//start with the start state
		measuringCupsPuzzleADT.add(startState);

		//while measuringCupsPuzzleADT is not empty...
		while (!measuringCupsPuzzleADT.isEmpty())
		{
			//assign the current state to the item in the measuringCupsPuzzleADT
			MeasuringCupsPuzzleState currentState =
					measuringCupsPuzzleADT.remove();

			//if the current state has not been visited, add it to the visited
			//or processed list; otherwise continue.
			if (!isProcessed(currentState))
			{
				processedStates.add(currentState);
			}
			else
			{
				continue;
			}

			//if the current state equals the goal state, assign it to
			//foundGoalState and return true that a path does exist
			if (currentState.equals(goalState))
			{
				foundGoalState = currentState;
				return true;
			}
			else
			{
				//obtain the list of successors and add them to
				//measuringCupsPuzzleADT. The process repeats until all of the
				//successors have been visited and a path is determined
				//to exist or not

				MeasuringCupsPuzzleStateList successorList =
						getSuccessors(currentState);
				Iterator<MeasuringCupsPuzzleState> itr =
						successorList.iterator();

				while (itr.hasNext())
				{
					measuringCupsPuzzleADT.add(itr.next());
				}
			}
		}
		return false;
	}

	/**
	 * Set member measuringCupsPuzzleADT {@link MeasuringCupsPuzzleADT} with a
	 * data type that will be used to solve the puzzle.
	 *
	 * @param algorithm
	 *            a String describing how the puzzle will be solved; has a value
	 *            equal to the project configuration {@link Config} BFS or DFS;
	 *            e.g. "BFS"
	 */
	private void chooseADT(String algorithm) {

		//if BFS or DFS, construct a measuringCupsPuzzleADT queue or stack
		if (algorithm == Config.BFS)
		{
			measuringCupsPuzzleADT = new MeasuringCupsPuzzleQueue();
		}
		else if (algorithm == Config.DFS)
		{
			measuringCupsPuzzleADT = new MeasuringCupsPuzzleStack();
		}
		else
		{
			//throw an illegal argument exception
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Reset the puzzle by erasing all member variables which store some aspect
	 * of the solution (pathFromStartToGoal, processedStates, and
	 * foundGoalState) and setting them to their initial values
	 */
	private void resetCupPuzzle() {
		pathFromStartToGoal.clear();
		processedStates.clear();
		foundGoalState = null;
	}

	/**
	 * Mark the graph node represented by currentState as visited for the
	 * purpose of the graph traversal algorithm being used to solve the puzzle
	 * (set by {@link chooseADT})
	 *
	 * @param currentState
	 *            {@link MeasuringCupsPuzzleState}
	 * @return true if the currentState has been visited and false otherwise
	 */
	private boolean isProcessed(MeasuringCupsPuzzleState currentState) {

		//create an iterator for all the states in the processedStates list
		Iterator<MeasuringCupsPuzzleState> itr = processedStates.iterator();
		MeasuringCupsPuzzleState state = null;

		//iterate through the processedState until there's no more items
		while (itr.hasNext())
		{
			state = itr.next();
			if (state.equals(currentState))
			{
				return true; //if a state in the list matches the currentState
			}
		}
		return false; //otherwise return false.
	}

	/**
	 * Assuming {@link findPathIfExists} returns true, return the solution that
	 * was found. Set pathFromStartToGoal by starting at the foundGoalState and
	 * accessing/setting the current node to the parentState
	 * {@link MeasuringCupsPuzzleState#getParentState} until reaching the
	 * startState
	 *
	 * @return a list of states {@link MeasuringCupsPuzzleStateList}
	 *         representing the changes in volume of cupA and cupB from the
	 *         initial state to the goal state.
	 */
	public MeasuringCupsPuzzleStateList retrievePath() {

		//add foundGoalState to the pathFromStartToGoal list
		pathFromStartToGoal.add(foundGoalState);

		//assign the found goal state to a new MeasuringCupPuzzleState
		MeasuringCupsPuzzleState currentState = foundGoalState;

		//check for the parents of currentState until there's no more parent
		while (currentState.getParentState() != null)
		{
			//find the parent of the currentState and assign to currentState
			pathFromStartToGoal.add(currentState.getParentState());
			currentState = currentState.getParentState();
		}

		//reverses the order so that the states are in correct traversal order
		pathFromStartToGoal.reverse();

		//return the pathFromStartToGoal
		return pathFromStartToGoal;
	}

	/**
	 * Enumerate all possible states that can be reached from the currentState
	 *
	 * @param currentState
	 *            the current volumes of cupA and cupB
	 * @return a list of states {@link MeasuringCupsPuzzleStateList} that can be
	 *         reached by emptying cupA or cupB, pouring from cupA to cupB and
	 *         vice versa, and filling cupA or cupB to its max capacity
	 */
	public MeasuringCupsPuzzleStateList getSuccessors(MeasuringCupsPuzzleState currentState) {

		MeasuringCupsPuzzleStateList successors = new MeasuringCupsPuzzleStateList();

		if (currentState == null) {
			return successors;
		}

		// Fill CupA
		successors.add(fillCupA(currentState));

		// Fill CupB
		successors.add(fillCupB(currentState));

		// Empty CupA
		successors.add(emptyCupA(currentState));

		// Empty CupB
		successors.add(emptyCupB(currentState));

		// Pour from CupA to CupB
		successors.add(pourCupAToCupB(currentState));

		// Pour from CupB to CupA
		successors.add(pourCupBToCupA(currentState));


		//create an iterator to iterate through the list of successors
		Iterator<MeasuringCupsPuzzleState> itr = successors.iterator();

		while (itr.hasNext())
		{
			// remove successors if same as currentState
			MeasuringCupsPuzzleState next = itr.next();
			if (next.equals(currentState))
			{
				successors.remove(currentState);
			}
		}

		//return the list of successors
		return successors;
	}

	/**
	 * @param currentState
	 * @return a new state obtained from currentState by filling cupA to its max
	 *         capacity
	 */
	public MeasuringCupsPuzzleState fillCupA(MeasuringCupsPuzzleState currentState) {

		//fill cupA to it's max
		Cup cupA = new Cup(currentState.getCupA().getCapacity(),
				currentState.getCupA().getCapacity());

		//create a new MeasuringCupPuzzleState with the filled cupA
		MeasuringCupsPuzzleState fillcupA =
				new MeasuringCupsPuzzleState(cupA, currentState.getCupB(),
						currentState);

		return fillcupA;
	}

	/**
	 * @param currentState
	 * @return a new state obtained from currentState by filling cupB to its max
	 *         capacity
	 */
	public MeasuringCupsPuzzleState fillCupB(MeasuringCupsPuzzleState currentState) {

		//fill cupB to it's max
		Cup cupB = new Cup(currentState.getCupB().getCapacity(),
				currentState.getCupB().getCapacity());

		//create a new MeasuringCupsPuzzleState with the filled cupB
		MeasuringCupsPuzzleState fillcupB =
				new MeasuringCupsPuzzleState(currentState.getCupA(), cupB,
						currentState);

		return fillcupB;
	}

	/**
	 * @param currentState
	 * @return a new state obtained from currentState by emptying cupA
	 */
	public MeasuringCupsPuzzleState emptyCupA(MeasuringCupsPuzzleState currentState) {

		//empty cupA by setting it's currentAmount to 0
		Cup cupA = new Cup(currentState.getCupA().getCapacity(), 0);

		//create a new MeasuringCupPuzzleState with the empty cupA
		MeasuringCupsPuzzleState emptyCupA = new MeasuringCupsPuzzleState(cupA,
				currentState.getCupB(), currentState);

		return emptyCupA;
	}

	/**
	 * @param currentState
	 * @return a new state obtained from currentState by emptying cupB
	 */
	public MeasuringCupsPuzzleState emptyCupB(MeasuringCupsPuzzleState currentState) {

		//empty cupB by setting it's currentAmount to 0
		Cup cupB = new Cup(currentState.getCupB().getCapacity(), 0);

		//create a new MeasuringCupsPuzzleState with the empty cupB
		MeasuringCupsPuzzleState emptyCupB =
				new MeasuringCupsPuzzleState(currentState.getCupA(), cupB,
						currentState);

		return emptyCupB;
	}

	/**
	 * @param currentState
	 * @return a new state obtained from currentState pouring the currentAmount
	 *         of cupA into cupB until either cupA is empty or cupB is full
	 */
	public MeasuringCupsPuzzleState pourCupAToCupB(MeasuringCupsPuzzleState currentState) {

		//initialize MeasuringCupPuzzleState aTOb
		MeasuringCupsPuzzleState aTOb = null;

		Cup cupA = null; //initialize Cup cupA

		Cup cupB = null; //initialize Cup cupB

		//if cupA has more than enough to fill cupB
		if (currentState.getCupA().getCurrentAmount() +
				currentState.getCupB().getCurrentAmount() >
		currentState.getCupB().getCapacity())
		{
			//then cupA will have some remaining
			cupA = new Cup(currentState.getCupA().getCapacity(),
					currentState.getCupA().getCurrentAmount() +
					currentState.getCupB().getCurrentAmount() -
					currentState.getCupB().getCapacity());

			//cupB is full
			cupB = new Cup(currentState.getCupB().getCapacity(),
					currentState.getCupB().getCapacity());

			aTOb = new MeasuringCupsPuzzleState(cupA, cupB, currentState);

		}//otherwise if cupA have just enough or not enough to fill cupB
		else if (currentState.getCupA().getCurrentAmount() +
				currentState.getCupB().getCurrentAmount() <=
				currentState.getCupB().getCapacity())
		{
			//cupA is empty
			cupA = new Cup(currentState.getCupA().getCapacity(), 0);

			//the currentAmount of cupB is the sum of the currentAmount of
			//cupA and cupB
			cupB = new Cup(currentState.getCupB().getCapacity(),
					currentState.getCupB().getCurrentAmount() +
					currentState.getCupA().getCurrentAmount());

			aTOb = new MeasuringCupsPuzzleState(cupA, cupB, currentState);
		}

		return aTOb;
	}

	/**
	 * @param currentState
	 * @return a new state obtained from currentState pouring the currentAmount
	 *         of cupB into cupA until either cupB is empty or cupA is full
	 */
	public MeasuringCupsPuzzleState pourCupBToCupA(MeasuringCupsPuzzleState currentState) {

		//initialize MeasuringCupsPuzzleState bTOa
		MeasuringCupsPuzzleState bTOa = null;

		Cup cupA = null; //initialize cupA

		Cup cupB = null; //initialize cupB

		//if cupB has more than enough to fill cupA
		if (currentState.getCupB().getCurrentAmount() +
				currentState.getCupA().getCurrentAmount() >
		currentState.getCupA().getCapacity())
		{
			//then cupB will have some remaining
			cupB = new Cup(currentState.getCupB().getCapacity(),
					currentState.getCupB().getCurrentAmount() +
					currentState.getCupA().getCurrentAmount() -
					currentState.getCupA().getCapacity());

			//cupA is full
			cupA = new Cup(currentState.getCupA().getCapacity(),
					currentState.getCupA().getCapacity());

			bTOa = new MeasuringCupsPuzzleState(cupA, cupB, currentState);

		}//otherwise if cupB have just enough or not enough to fill cupA
		else if (currentState.getCupB().getCurrentAmount() +
				currentState.getCupA().getCurrentAmount() <=
				currentState.getCupA().getCapacity())
		{
			//cupB is empty
			cupB = new Cup(currentState.getCupB().getCapacity(), 0);

			//the currentAmount of cupA is the sum of the currentAmount of
			//cupA and cupB
			cupA = new Cup(currentState.getCupA().getCapacity(),
					currentState.getCupA().getCurrentAmount() +
					currentState.getCupB().getCurrentAmount());

			bTOa = new MeasuringCupsPuzzleState(cupA, cupB, currentState);
		}

		return bTOa;
	}
}
