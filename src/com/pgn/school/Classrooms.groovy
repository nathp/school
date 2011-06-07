package com.pgn.school

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:21 PM
 * Do not use without permission.
 */
class Classrooms {
  final static Classrooms object = new Classrooms()

  static Classrooms instance() {
      object
  }

  Map map = [:]

  class ClassroomWithStudents {
    Set kids = [] as Set
    def leftShift(Student student) { kids << student }
  }

  void notify(Student s, Classroom c) {
    def kids = map.s
    if (!kids) { kids = new ClassroomWithStudents(); map.s = kids }
    kids << s
  }
}
