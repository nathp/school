package com.pgn.school

import com.pgn.school.core.entity.Student
import com.pgn.school.core.value.Event

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:43 PM
 * Do not use without permission.
 */
interface Action {
  Event actOn(Student s)
}
