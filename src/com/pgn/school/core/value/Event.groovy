package com.pgn.school.core.value

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:54 PM
 * Do not use without permission.
 */
class Event {
  static Event NONE = new Event()

  String studentId
  Map map = [:]

  Event save(String key, Object value) {
    map[key] = value
    this
  }

  Object value(String s) {
    map[s]
  }
}
