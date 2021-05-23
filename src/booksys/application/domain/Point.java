package booksys.application.domain;

public class Point extends Customer {
	
	private int point ;

	  Point(String n, String p, int pt)
	  {
	    super(n, p) ;
	    point = pt ;
	  }

	  int getPoint() {
	    return point ;
	  }

}
