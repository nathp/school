package com.pgn.school.core

import com.pgn.school.Action
import com.pgn.school.core.entity.Student
import com.pgn.school.core.repository.EventsRepository

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 8:21 PM
 * Do not use without permission.
 */
class StudentCollection {

  def students = { }

  StudentCollection(Closure students) {
    this.students = students
  }

  void doAction(Action action) {
    students().each { Student s ->
      def event = action.actOn(s)
      EventsRepository.instance().save(action, event, s)
    }
  }
}
