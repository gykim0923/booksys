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
  int point ;  //point변수 만들어줌
  

  public Customer(String n, String p, int point)
  {
    name = n ;
    phoneNumber = p ;
    point = 0;  //처음 포인트는 0으로 초기화
  }

  public String getName()
  {
    return name ;
  }

  public String getPhoneNumber()
  {
    return phoneNumber ;
  }
}
