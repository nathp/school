package com.pgn.school

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 5:04 PM
 * Do not use without permission.
 */
class ActionsRepository {
  private static ActionsRepository instance = new ActionsRepository()

  static ActionsRepository instance() { instance }

  def events = []


  static class StudentEvent {
    Action action
    Event event
    Student student
  }

  void save(Action action, Event event, Student student) {
    events.add(new StudentEvent(action: action, event: event, student: student))
  }

  Event find(Class klazz, Student s) {
    def allEvents = events.findAll {it.action.getClass() == klazz && it.student == s }.collect {it.event}
    allEvents ? allEvents[0] : Event.NONE
  }
}
