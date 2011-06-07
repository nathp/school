package com.pgn.school.core.entity

import com.pgn.school.core.entity.Student
import com.pgn.school.core.repository.StudentRepository
import com.pgn.school.core.value.AcademicYear
import com.pgn.school.core.repository.ActionsRepository
import com.pgn.school.Action
import com.pgn.school.core.StudentCollection

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:05 PM
 * Do not use without permission.
 */
class Term {
  String name
  AcademicYear year

  void doAction(Action action) {
    new StudentCollection({students()}).doAction action
  }

  List students() {
    StudentRepository.instance().find { it.currentTerm  = this} as List
  }
}
