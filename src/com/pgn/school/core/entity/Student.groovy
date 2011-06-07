package com.pgn.school.core.entity

import com.pgn.school.core.value.Name
import com.pgn.school.core.value.Dob
import com.pgn.school.core.value.Gender

import com.pgn.school.core.repository.StudentRepository
import com.pgn.school.core.value.Event
import com.pgn.school.core.repository.EventsRepository

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

  Term currentTerm

  static Student registerNew(String id, Name name, Dob dob, Gender g) {
    Student s = new Student(id:id, name:name, dob:dob, gender:g)
    StudentRepository.instance().add s
    s
  }

  void registerIn(Term classroom) {
    this.currentTerm = classroom
  }

  def valueOf(Class actionType, String actionProperty) {
    Event e = EventsRepository.instance().find(actionType, this)
    e.value(actionProperty)
  }
}
