package com.pgn.school;


import static org.mockito.Mockito.*
import junit.framework.TestCase
import com.pgn.school.core.entity.Student
import com.pgn.school.core.repository.StudentRepository
import com.pgn.school.core.value.Gender
import com.pgn.school.core.value.AcademicYear
import com.pgn.school.core.value.Name
import com.pgn.school.core.value.Dob
import com.pgn.school.core.repository.TermRepository
import com.pgn.school.core.entity.Term

public class SimpleStudentLifeCycleTestsTest extends TestCase {

  void test_should_be_able_to_assign_a_student_to_a_class() {
    Term classA = TermRepository.instance().newClassroom("1", AcademicYear.forPeriod("01062010", "31032011"))

    Student student = StudentRepository.instance().registerNew("s1", new Name("prasanth", "nath"), Dob.from("14021980"), Gender.Male)

    student.registerIn(classA)
    assertTrue StudentRepository.instance().lookup("s1").currentTerm.name == "1"
  }

  void test_should_conduct_an_examination_to_a_class_and_retrieve_a_students_grades() {
    Term classA = TermRepository.instance().newClassroom("1", AcademicYear.forPeriod("01062010", "31032011"))
    Student student = StudentRepository.instance().registerNew("s1", new Name("prasanth", "nath"), Dob.from("14021980"), Gender.Male)
    student.registerIn(classA)

    Evaluation evaluation = mock(Evaluation)
    doReturn(Evaluation.Result.Pass).when(evaluation).evaluate student
    classA.doAction(new Examination("08082010", evaluation))

    assertEquals Evaluation.Result.Pass, StudentRepository.instance().lookup("s1").valueOf(Examination, Examination.midtermresult)
  }
}
