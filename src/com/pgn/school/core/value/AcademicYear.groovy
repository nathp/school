package com.pgn.school.core.value

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:03 PM
 * Do not use without permission.
 */
class AcademicYear {
  Date from
  Date to


  static forPeriod = {String fromDate, String toDate ->
    new AcademicYear(from: Date.newDate(fromDate), to:Date.newDate(toDate))
  }
}
