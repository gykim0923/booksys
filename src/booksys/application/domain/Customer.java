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
  private int point;
  public Customer(String n, String p,int po)
  {
    name = n ;
    phoneNumber = p ;
    point = po;
  		
  }
  public int calcPoint(int price) {
		point += 500;
		return price;
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
