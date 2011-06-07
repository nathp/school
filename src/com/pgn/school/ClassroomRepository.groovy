package com.pgn.school

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:21 PM
 * Do not use without permission.
 */
class ClassroomRepository {
  private final static ClassroomRepository object = new ClassroomRepository()

  static ClassroomRepository instance() {
    object
  }

  List rooms = []

  Classroom forName(String s) {
    rooms.find { it.name = s }
  }

  Classroom newClassroom(String name, AcademicYear academicYear) {
    def room = new Classroom(name: name, year: academicYear)
    rooms << room
    room
  }
}
