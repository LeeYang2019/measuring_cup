///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (MeasuringCupsPuzzleQueue.java)
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
import java.util.LinkedList;
import java.util.Queue;

/**
 * A queue of MeasuringCupsPuzzleState nodes
 */
public class MeasuringCupsPuzzleQueue implements MeasuringCupsPuzzleADT {

	Queue<MeasuringCupsPuzzleState> queue;

	/**
	 * Construct a new queue
	 */
	public MeasuringCupsPuzzleQueue() {
		this.queue = new LinkedList<MeasuringCupsPuzzleState>();
	}

	/**
	 * Add a node to the queue
	 * 
	 * @param state
	 *            the node to add
	 */
	@Override
	public void add(MeasuringCupsPuzzleState state) {
		queue.offer(state); //insert the state to the queue
	}

	/**
	 * Remove the last (FIFO) node from the queue
	 * 
	 * @return the least recent node that has been inserted into the queue;
	 *         which is now removed from the queue as a result of this function
	 *         call
	 */
	@Override
	public MeasuringCupsPuzzleState remove() {
		return this.queue.poll(); //Retrieve and remove from the front
	}

	/**
	 * @return true if the queue is empty and false otherwise
	 */
	@Override
	public boolean isEmpty() {
		
		//if the size is 0 then it is empty
		if (queue.size() == 0)
		{
			return true;
		}
		return false;
	}

	/**
	 * Update the queue by removing all of its members.
	 */
	@Override
	public void clear() {
		this.queue.clear(); //remove all element
	}

	/**
	 * @return a String representation of the queue by visiting each member in
	 *         FIFO order, calling its toString, and joining the resulting
	 *         String to the return string by separating member Strings with a
	 *         space character
	 */
	public String toString() {
		Iterator<MeasuringCupsPuzzleState> queueIterator = this.queue.iterator();
		String result = "";
		while (queueIterator.hasNext()) {
			result += queueIterator.next().toString();
			if (queueIterator.hasNext()) {
				result += " ";
			}
		}
		return result;
	}
}
