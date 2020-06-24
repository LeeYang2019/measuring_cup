///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (Cup.java)
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
 * A representation of a measuring cup.
 */
public class Cup {

	private int capacity;
	private int currentAmount;

	/**
	 * Construct a measuring cup
	 *
	 * @param capacity
	 *            the maximum volume of the measuring cup
	 * @param currentAmount
	 *            the current volume of fluid in the measuring cup
	 * @throws IllegalArgumentException
	 *             when any of these conditions are true: capacity < 0,
	 *             currentAmount < 0, currentAmount > capacity
	 *
	 */
	public Cup(int capacity, int currentAmount) {

		//initialize private fields
		this.capacity = capacity;
		this.currentAmount = currentAmount;
	}

	/**
	 * @return capacity
	 */
	public int getCapacity() {

		//return the capacity. Throw an exception if the capacity is less than 0.
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}

		return this.capacity;
	}

	/**
	 * @return currentAmount
	 */
	public int getCurrentAmount() {

		//return the current amount. Throw an exception if the current amount
		//is than 0.
		if (currentAmount < 0) {
			throw new IllegalArgumentException();
		}
		return this.currentAmount;
	}

	/**
	 * Compare this cup against another cup
	 *
	 * @param cup
	 *            an other cup to compare against this cup
	 * @return true if the other cup has the same capacity and currentAmount as
	 *         this cup and false otherwise
	 */
	public boolean equals(Cup cup) {

		//return true if this cup is equal to that cup, else return false
		if (cup.getCapacity() == this.getCapacity() && cup.getCurrentAmount() ==
				this.getCurrentAmount()) {
			return true;
		}

		return false;
	}

	/**
	 * @return a string containing the currentAmount
	 */
	public String toString() {
		return String.valueOf(this.currentAmount);
	}
}
