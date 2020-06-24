///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (MeasuringCupsPuzzleADT.java)
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
 * Define the inferface shared by {@link MeasuringCupsPuzzleStack} and
 * {@link MeasuringCupsPuzzleQueue}
 */
public interface MeasuringCupsPuzzleADT {
	void add(MeasuringCupsPuzzleState state);

	MeasuringCupsPuzzleState remove();

	boolean isEmpty();

	void clear();
}
