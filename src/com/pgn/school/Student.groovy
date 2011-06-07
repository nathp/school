package com.pgn.school

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:03 PM
 * Do not use without permission.
 */
class Student {
  String id
  Name name
  Dob dob
  Gender gender

  Classroom classroom

  static Student registerNew(String id, Name name, Dob dob, Gender g) {
    Student s = new Student(id:id, name:name, dob:dob, gender:g)
    Students.instance().add s
    s
  }

  void registerIn(Classroom classroom) {
    this.classroom = classroom
    Classrooms.instance().notify this, classroom
  }
}