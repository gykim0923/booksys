package booksys.application.domain;

public class Menu {
	
	  private String menuName ;
	  private int menuPrice;
	  public Menu (String mn)
	  {
	    menuName = mn ;
	  }

	  public String getMenuName()
	  {
	    return menuName ;
	  }

	  public int getMenuPrice()
	  {
	    return menuPrice ;
	  }
}
