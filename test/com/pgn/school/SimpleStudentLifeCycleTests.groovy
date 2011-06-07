package com.pgn.school;


import static org.mockito.Mockito.*
import junit.framework.TestCase

public class SimpleStudentLifeCycleTestsTest extends TestCase {

  void test_should_be_able_to_assign_a_student_to_a_class() {
    Classroom classA = ClassroomRepository.instance().newClassroom("1", AcademicYear.forPeriod("01062010", "31032011"))

    Student student = Student.registerNew("s1", new Name("prasanth", "nath"), Dob.from("14021980"), Gender.Male)

    student.registerIn(classA)
    assertTrue StudentRepository.instance().lookup("s1").classroom.name == "1"
  }

  void test_should_conduct_an_examination_to_a_class() {
    Classroom classA = ClassroomRepository.instance().newClassroom("1", AcademicYear.forPeriod("01062010", "31032011"))
    Student student = Student.registerNew("s1", new Name("prasanth", "nath"), Dob.from("14021980"), Gender.Male)
    student.registerIn(classA)

    Evaluation evaluation = mock(Evaluation)
    doReturn(Evaluation.Result.Pass).when(evaluation).evaluate student
    classA.doAction(new Examination("08082010", evaluation))

    assertEquals Evaluation.Result.Pass, StudentRepository.instance().lookup("s1").valueOf(Examination, Examination.midtermresult)
  }
}
