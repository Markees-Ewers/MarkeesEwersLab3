package edu.westga.cs1302.cms.test.model.student;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.cms.model.Student;

public class TestToString {
	@Test
	void testToString(){
		Student student = new Student("John", 85);
		assertEquals("John :85", student.toString());
	}

}
