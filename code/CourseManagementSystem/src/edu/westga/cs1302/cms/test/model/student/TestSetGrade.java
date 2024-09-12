package edu.westga.cs1302.cms.test.model.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.cms.model.Student;

class TestSetGrade {

	@Test
	public void testSetGradeValid() {

		Student student = new Student("John", 75);
		int newGrade = 90;

		student.setGrade(newGrade);

		assertEquals(newGrade, student.getGrade());
	}

	@Test
	public void testSetGradeLessThanZero() {

		Student student = new Student("John", 75);

		assertThrows(IllegalArgumentException.class, () -> {
			student.setGrade(-1);
		});
	}

	@Test
	public void testSetGradeGreaterThanHundred() {

		Student student = new Student("John", 75);

		assertThrows(IllegalArgumentException.class, () -> {
			student.setGrade(101);
		});
	}

	@Test
	public void testSetGradeZero() {

		Student student = new Student("John", 75);

		student.setGrade(0);

		assertEquals(0, student.getGrade());
	}

	@Test
	public void testSetGradeHundred() {

		Student student = new Student("John", 75);

		student.setGrade(100);

		assertEquals(100, student.getGrade());
	}

	@Test
	public void testChangeGradeValid() {

		Student student = new Student("John", 75);
		int newGrade = 85;

		student.setGrade(newGrade);

		assertEquals(newGrade, student.getGrade());
	}
}
