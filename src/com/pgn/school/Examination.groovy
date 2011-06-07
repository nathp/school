package com.pgn.school

import com.pgn.school.Evaluation.Result

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:42 PM
 * Do not use without permission.
 */
class Examination implements Action {
  String date
  Evaluation evaluation

  static final String midtermresult = "midtermresult"

  Examination(String date, Evaluation evaluation) {
    this.date = date
    this.evaluation = evaluation
  }

  Event actOn(Student s) {
    Result r =  evaluation.evaluate(s)
    def event = new Event(studentId: s.id)
    event.save(midtermresult, r)
    event
  }
}
