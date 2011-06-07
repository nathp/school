package com.pgn.school

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:27 PM
 * Do not use without permission.
 */
class Students {
  final static Students instance = new Students()

  Set kids = [] as Set

  static Students instance() {
    instance
  }

  void add(Student student) {
    kids << student
  }

  Student lookup(String studentId) {
    kids.find {it.id = studentId}
  }
}
