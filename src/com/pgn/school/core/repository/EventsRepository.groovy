package com.pgn.school.core.repository

import com.pgn.school.core.entity.Student
import com.pgn.school.core.value.Event
import com.pgn.school.Action

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 5:04 PM
 * Do not use without permission.
 */
class EventsRepository {
  private static EventsRepository instance = new EventsRepository()

  static EventsRepository instance() { instance }

  def events = []


  static class StudentEvent {
    Action action
    Event event
    Student student
  }

  void save(Action action, Event event, Student student) {
    events.add(new StudentEvent(action: action, event: event, student: student))
  }

  Event find(Class actionClass, Student s) {
    def allEvents = events.findAll {it.action.getClass() == actionClass && it.student == s }.collect {it.event}
    allEvents ? allEvents[0] : Event.NONE
  }
}
