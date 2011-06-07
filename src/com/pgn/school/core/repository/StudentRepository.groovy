package com.pgn.school.core.repository

import com.pgn.school.core.entity.Student
import com.pgn.school.core.value.Gender
import com.pgn.school.core.value.Dob
import com.pgn.school.core.value.Name

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:27 PM
 * Do not use without permission.
 */
class StudentRepository {

  private final static StudentRepository instance = new StudentRepository()

  Set kids = [] as Set

  static StudentRepository instance() {
    instance
  }

  void add(Student student) {
    kids << student
  }

  Student lookup(String studentId) {
    kids.find {it.id == studentId}
  }

  def find(Closure c) {
      kids.find c
  }

  Student registerNew(String id, Name name, Dob dob, Gender gender) {
    Student s = new Student(id:id, name:name, dob:dob, gender:gender)
    add s
    s
  }
}
