package com.pgn.school

import com.pgn.school.core.entity.Student

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:40 PM
 * Do not use without permission.
 */
interface Evaluation {

  enum Result { Pass, Fail }

  Result evaluate(Student student)
}
