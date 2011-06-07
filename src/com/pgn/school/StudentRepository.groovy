package com.pgn.school

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:27 PM
 * Do not use without permission.
 */
class StudentRepository {

  final static StudentRepository instance = new StudentRepository()

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
}
