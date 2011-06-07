package com.pgn.school

/**
 * Copy right of Prasanth Nath.
 * Date: 6/7/11, Time: 3:03 PM
 * Do not use without permission.
 */
class AcademicYear {
  com.pgn.school.Date from
  com.pgn.school.Date to


  static forPeriod = {String fromDate, String toDate ->
    new AcademicYear(from: com.pgn.school.Date.newDate(fromDate), to:com.pgn.school.Date.newDate(toDate))
  }
}
