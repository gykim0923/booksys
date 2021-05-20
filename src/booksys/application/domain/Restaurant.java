/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.domain ;

import booksys.application.persistency.* ;

import java.sql.Date ;
import java.sql.Time ;
import java.util.Vector ;

class Restaurant
{
  BookingMapper  bm = BookingMapper.getInstance() ;
  CustomerMapper cm = CustomerMapper.getInstance() ;
  TableMapper    tm = TableMapper.getInstance() ;
  MenuMapper	 mm = MenuMapper.getInstance() ;
  
  Vector getBookings(Date date)
  {
    return bm.getBookings(date) ;
  }

  Customer getCustomer(String name, String phone)
  {
    return cm.getCustomer(name, phone) ;
  }
  
  Table getTable(int n)
  {
    return tm.getTable(n) ;
  }

  static Vector getTableNumbers()
  {
    return TableMapper.getInstance().getTableNumbers() ;
  }
  
  //
  Menu getMenu(String mname, int mprice)
  {
    return mm.getMenu(mname, mprice) ; // data o null error
  }

  static Vector getMenuName()
  {
    return MenuMapper.getInstance().getMenuName() ;
  }
  
  static Vector getMenuPrice()
  {
    return MenuMapper.getInstance().getMenuPrice() ;
  }

  public Booking makeReservation(int covers, Date date,
				     Time time, int tno, String mname, int mprice, String name, String phone)
  {
    Table t = getTable(tno) ;
    Menu m = getMenu(mname, mprice) ; // data o null error
    Customer c = getCustomer(name, phone) ;
    return bm.createReservation(covers, date, time, t, m, c, null) ; // data x null error
  }

  public Booking makeWalkIn(int covers, Date date,
			   Time time, int tno, String mname, int mprice)
  {
    Table t = getTable(tno) ;
    Menu m = getMenu(mname, mprice) ;
    return bm.createWalkIn(covers, date, time, t, m) ;
  }

  public void updateBooking(Booking b)
  {
    bm.updateBooking(b) ;
  }
  
  public void removeBooking(Booking b) {
    bm.deleteBooking(b) ;
  }
  //예약정보수정
  public void editReservation(Booking b , Time editTime, int editCovers) {
	   bm.editReservation(b, editTime,editCovers);
	 	  
  }
}
