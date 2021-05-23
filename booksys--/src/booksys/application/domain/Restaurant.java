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
import java.util.ArrayList;
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
    return mm.getMenu(mname, mprice) ;
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
				     Time time, int tno, String mname,int mprice, String name, String phone)
  {
    Table t = getTable(tno) ;
    Menu m = getMenu(mname, mprice) ;
    Customer c = getCustomer(name, phone) ;
    return bm.createReservation(covers, date, time, t, m, c, null) ;
  }
  
  public void point(String name, String phone, int point)
  {
	    ArrayList CustomerList1 = new ArrayList();   
	    ArrayList CustomerList2 = new ArrayList();   
	    Customer c = new Customer(phone, phone, point);
		CustomerList1.add(c);
		CustomerList2.add(c);

	for (int i = CustomerList1.size()-2; i>=0; i--) {
		if(Customer.get(1).name.equals(name)) {
			c.point = c.point + 100; 
				break;
		} else continue;
	}
	  
 }


public Booking makeWalkIn(int covers, Date date,
			   Time time, int tno, String mname,int mprice)
  {
    Table t = getTable(tno) ;
    Menu m = getMenu(mname,mprice) ;
    return bm.createWalkIn(covers, date, time, t, m) ;
  }

  public void updateBooking(Booking b)
  {
    bm.updateBooking(b) ;
  }
  
  public void removeBooking(Booking b) {
    bm.deleteBooking(b) ;
  }
  //占쎌굙占쎈튋占쎌젟癰귣똻�땾占쎌젟
  public void editReservation(Booking b , Time editTime, int editCovers) {
	   bm.editReservation(b, editTime,editCovers);
	  
	  
  }
}
