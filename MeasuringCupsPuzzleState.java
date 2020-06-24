///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (MeasuringCupsPuzzleState.java)
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

/**
 * A class representing a state of volumes of cupA and cupB.
 */
public class MeasuringCupsPuzzleState {

	private Cup cupA;
	private Cup cupB;
	private MeasuringCupsPuzzleState parentState;

	/**
	 * Construct an object representing the state of two measuring cups and
	 * their previous state
	 * 
	 * @param CupA
	 *            object containing the currentAmount in CupA {@link Cup}
	 * @param CupB
	 *            see CupA {@link Cup}
	 * @param parentState
	 *            an object from this class representing the previous state
	 */
	public MeasuringCupsPuzzleState(Cup CupA, Cup CupB, 
			MeasuringCupsPuzzleState parentState) {
		this.cupA = CupA;
		this.cupB = CupB;
		this.parentState = parentState;
	}

	/**
	 * @return cupA
	 */
	public Cup getCupA() {
		return cupA;
	}

	/**
	 * @return cupB
	 */
	public Cup getCupB() {
		return cupB;
	}

	/**
	 * @return parentState
	 */
	public MeasuringCupsPuzzleState getParentState() {
		return parentState; 
	}

	/**
	 * Compare this state against another state
	 * 
	 * @param measuringCupsPuzzleState
	 *            another object of the same class to compare this object to
	 * @return true if this state's cupA and cupB are the same as the other
	 *         state's cupA and cupB and false otherwise
	 */
	public boolean equals(MeasuringCupsPuzzleState measuringCupsPuzzleState) {
		
		//return true if this states cup a and b is equal to other state's 
		//cup a and b; else, return false
		if (measuringCupsPuzzleState.getCupA().equals(cupA) && 
				measuringCupsPuzzleState.getCupB().equals(cupB))
		{
			return true;
		}
		
		return false;
	}

	/**
	 * @return a string containing cupA and cupB string representations as a
	 *         pair: (cupA, cupB)
	 */
	public String toString() {
		return "(" + this.cupA.toString() + ", " + this.cupB.toString() + ")";
	}
}
