package com.pgn.school;
import org.junit.*
import static org.mockito.Mockito.*
import junit.framework.TestCase

public class SimpleStudentLifeCycleTestsTest extends TestCase {
  void test_should_be_able_to_assign_a_student_to_a_class () {
    Classroom classA = Classes.newClassroom("1", AcademicYear.forPeriod("01062010", "31032011"))

    Student student = Student.registerNew("s1", new Name("prasanth", "nath"), Dob.from("14021980"), Gender.Male)

    student.registerIn(classA)
    assertTrue Students.instance().lookup("s1").classroom.name == "1"
  }
}
