/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.persistency ;

import booksys.application.domain.Booking ;
import booksys.application.domain.Reservation ;
import booksys.application.domain.Customer ;
import booksys.application.domain.Menu;
import booksys.application.domain.Table ;
import booksys.storage.* ;

import java.sql.* ;
import java.util.Enumeration ;
import java.util.Hashtable ;
import java.util.Vector ;

public class BookingMapper
{
  // Singleton:
  
  private static BookingMapper uniqueInstance ;

  public static BookingMapper getInstance()
  {
    if (uniqueInstance == null) {
      uniqueInstance = new BookingMapper() ;
    }
    return uniqueInstance ;
  }

  public Vector getBookings(Date date)
  {
    Vector v = new Vector() ;
    try
    {
      Statement stmt
	= Database.getInstance().getConnection().createStatement() ;
      ResultSet rset
	= stmt.executeQuery("SELECT * FROM Reservation WHERE date='"
			    + date + "'") ;
      while (rset.next()) {
	int oid = rset.getInt(1) ;
	int covers = rset.getInt(2) ;
	Date bdate = rset.getDate(3) ;
	Time btime = rset.getTime(4) ;
	int table = rset.getInt(5) ;
	int menu = rset.getInt(6) ;
	int cust = rset.getInt(7) ;
	Time atime = rset.getTime(8) ;
	PersistentTable t = TableMapper.getInstance().getTableForOid(table) ;
	PersistentMenu m =
			  MenuMapper.getInstance().getMenuForOid(menu) ;
	PersistentCustomer c =
	  CustomerMapper.getInstance().getCustomerForOid(cust) ;
	
	PersistentReservation r
	  = new PersistentReservation(oid, covers, bdate, btime, t, m, c, atime) ;
	v.add(r) ;
      }
      rset.close() ;
      rset = stmt.executeQuery("SELECT * FROM WalkIn WHERE date='"
			       + date + "'") ;
      while (rset.next()) {
	int oid = rset.getInt(1) ;
	int covers = rset.getInt(2) ;
	Date bdate = rset.getDate(3) ;
	Time btime = rset.getTime(4) ;
	int table = rset.getInt(5) ;
	int menu = rset.getInt(6) ;
	PersistentTable t = TableMapper.getInstance().getTableForOid(table) ;
	PersistentMenu m =
			  MenuMapper.getInstance().getMenuForOid(menu) ;
	PersistentWalkIn w
	  = new PersistentWalkIn(oid, covers, bdate, btime, t, m) ;
	v.add(w) ;
      }
      rset.close() ;
     stmt.close() ;
    }
    catch (SQLException e) {
      e.printStackTrace() ;
    }
    return v ;
  }
  
  public PersistentReservation createReservation(int covers,
						 Date date,
						 Time time,
						 Table table,
						 Menu menu, 
						 Customer customer,
						 Time arrivalTime)
  {
    int oid = Database.getInstance().getId() ;
    performUpdate("INSERT INTO Reservation " + "VALUES ('"
		  + oid + "', '"
		  + covers + "', '"
		  + date + "', '"
		  + time + "', '"
		  + ((PersistentTable) table).getId() + "', '"
		  + ((PersistentMenu) menu).getId() + "', '" // data x null error
		  + ((PersistentCustomer) customer).getId() + "', "
		  + (arrivalTime == null ? "NULL" :
		     ("'" + arrivalTime.toString() + "'"))
		  + ")" ) ;
    return new PersistentReservation(oid,
				     covers,
				     date,
				     time,
				     table,
				     menu,
				     customer,
				     arrivalTime) ;
  } 
  
  public PersistentWalkIn createWalkIn(int covers,
				       Date date,
				       Time time,
				       Table table, 
				       Menu menu)
  {
    int oid = Database.getInstance().getId() ;
    performUpdate("INSERT INTO WalkIn " + "VALUES ('"
		  + oid + "', '"
		  + covers + "', '"
		  + date + "', '"
		  + time + "', '"
		  + ((PersistentTable) table).getId()+ "', '"
		  + ((PersistentMenu) menu).getId()+ "')" ) ;
    return new PersistentWalkIn(oid, covers, date, time, table, menu) ;
  } 

  public void updateBooking(Booking b)
  {
    PersistentBooking pb = (PersistentBooking) b ;
    boolean isReservation = b instanceof Reservation ;
    StringBuffer sql = new StringBuffer(128) ;
    
    sql.append("UPDATE ") ;
    sql.append(isReservation ? "Reservation" : "WalkIn") ;
    sql.append(" SET ") ;
    sql.append(" covers = ") ;
    sql.append(pb.getCovers()) ;
    sql.append(", date = '") ;
    sql.append(pb.getDate().toString()) ;
    sql.append("', time = '") ;
    sql.append(pb.getTime().toString()) ;
    sql.append("', table_id = ") ;
    sql.append(((PersistentTable) pb.getTable()).getId()) ;
    sql.append("', menu_id = ") ;
    sql.append(((PersistentMenu) pb.getMenu()).getId()) ;
    if (isReservation) {
      PersistentReservation pr = (PersistentReservation) pb ;
      sql.append(", customer_id = ") ;
      sql.append(((PersistentCustomer) pr.getCustomer()).getId()) ;
      sql.append(", arrivalTime = ") ;
      Time atime = pr.getArrivalTime() ;
      if (atime == null) {
	sql.append("NULL") ;
      }
      else {
	sql.append("'" + atime + "'") ;
      }
    }
    sql.append(" WHERE oid = ") ;
    sql.append(pb.getId()) ;

    performUpdate(sql.toString()) ;
  }
  
  public void deleteBooking(Booking b)
  {
    String table = b instanceof Reservation ? "Reservation" : "WalkIn" ;
    performUpdate("DELETE FROM " + table + " WHERE oid = '"
		  + ((PersistentBooking) b).getId() + "'" ) ;
  }

  private void performUpdate(String sql)
  {
    try {
      Statement stmt
	= Database.getInstance().getConnection().createStatement() ;
      int updateCount
	= stmt.executeUpdate(sql) ;
      stmt.close() ;
    }
    catch (SQLException e) {
      e.printStackTrace() ;
    }
  }
  //�삁�빟�젙蹂댁닔�젙
  public void editReservation(Booking b , Time editTime, int editCovers)
{
	  PersistentBooking pb = (PersistentBooking) b ;
	    
	    StringBuffer sql = new StringBuffer(128) ;
	    sql.append("UPDATE Reservation SET covers = " + editCovers +  ", time = '" + editTime.toString() //�옉���뵲�샂�몴
	    + "'"+ " WHERE oid = "+pb.getId());
	    b.setTime(editTime);
	    b.setCovers(editCovers);

	    performUpdate(sql.toString()) ;		
	   
} 

}
