///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (MeasuringCupsPuzzleException.java)
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
 * A special (unchecked) exception class used only by methods in this project.
 */
public class MeasuringCupsPuzzleException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Initialize the exception with a more specific error message
	 *
	 * @param message
	 *            the error message
	 */
	public MeasuringCupsPuzzleException(String message) {
		super(message);
	}
}
