package com.pgn.school.core.repository

import com.pgn.school.core.value.AcademicYear
import com.pgn.school.core.entity.Term

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:21 PM
 * Do not use without permission.
 */
class TermRepository {
  private final static TermRepository object = new TermRepository()

  static TermRepository instance() {
    object
  }

  List rooms = []

  Term forName(String s) {
    rooms.find { it.name = s }
  }

  Term newClassroom(String name, AcademicYear academicYear) {
    def room = new Term(name: name, year: academicYear)
    rooms << room
    room
  }
}
