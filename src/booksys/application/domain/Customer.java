/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.domain ;

public class Customer
{
  private String name ;
  private String phoneNumber ;
  private int point ;

  public Customer(String n, String p, int pt)
  {
    name = n ;
    phoneNumber = p ;
    point = pt;
  }

  public String getName()
  {
    return name ;
  }

  public String getPhoneNumber()
  {
    return phoneNumber ;
  }
  
  public int getPoint()
  {
    return point ;
  }
  
}
