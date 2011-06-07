package com.pgn.school

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:05 PM
 * Do not use without permission.
 */
class Classroom {
  String name
  AcademicYear year

  void doAction(Action action) {
    each { Student s ->
      def event = action.actOn(s)
      ActionsRepository.instance().save(action, event, s)
    }
  }

  def each(Closure c) {
    students().each c
  }

  List students() {
    StudentRepository.instance().find { it.classroom = this} as List
  }
}
