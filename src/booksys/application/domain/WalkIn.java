/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.domain ;

import java.sql.Date ;
import java.sql.Time ;

public class WalkIn extends BookingImp
{
  public WalkIn(int c, Date d, Time t, Table tab, Menu menu)
  {
    super(c, d, t, tab, menu) ;
  }

  public String getDetails() {
    return "Walk-in (" + covers + ")" ;
  }
}
