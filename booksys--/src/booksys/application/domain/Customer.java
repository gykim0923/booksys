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
  int point ;  //point���� �������
  

  public Customer(String n, String p, int point)
  {
    name = n ;
    phoneNumber = p ;
    point = 0;  //ó�� ����Ʈ�� 0���� �ʱ�ȭ
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
