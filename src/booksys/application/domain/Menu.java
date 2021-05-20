package booksys.application.domain;

public class Menu {
	
	  private String menuName ;
	  private int menuPrice ;
	  
	  public Menu (String mn, int mp)
	  {
	    menuName = mn ;
	    menuPrice = mp ;
	  }

	  public String getMName()
	  {
	    return menuName ;
	  }

	public int getPrice() {
		return menuPrice;
	}
}
