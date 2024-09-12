package edu.westga.cs1302.cms.model;

// TODO: Auto-generated Javadoc
/**
 * Stores and manages information for a single student.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class Student {
	
	/** The name. */
	private String name;
	
	/** The grade. */
	private int grade;

	/**
	 * Create a new student with the specified name.
	 *
	 * @param name  the name of the new student
	 * @param grade the grade for the new student
	 * @throws IllegalArgumentException when precondition is violated
	 * @precondition name != null && name.length() >= 3
	 * @precondtion grade !> 100 || grade < 0
	 * @postcondition getName() == name
	 */
	public Student(String name, int grade) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("Name must be provided.");
		}
		if (name.length() < 3) {
			throw new IllegalArgumentException("Name must have at least 3 characters.");
		}
		if (grade > 100 || grade < 0) {
			throw new IllegalArgumentException("Grade must be between 0 and 100");
		}
		this.name = name;
		this.grade = grade;
	}

	/**
	 * Return the name of the student.
	 *
	 * @return the name of the student
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the grade for the student.
	 *
	 * @return the grade for the student
	 */
	public int getGrade() {
		return this.grade;
	}

	/**
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade(int grade) {
		if (grade < 0 || grade > 100) {
			throw new IllegalArgumentException("Grade must be between 0 and 100");
		}
		this.grade = grade;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.name + " :" + this.grade;
	}

}
