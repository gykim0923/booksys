package booksys.application.domain;
import java.awt.List;
import java.util.*;


public class Menu {
	
	 private String menuName ;
	 private int menuPrice;
	 /* HashMap<String, Integer> menuInfo = new HashMap<String, Integer>(); */
	
	 
	  public Menu (String mn, int mp)
	  {
	    menuName = mn ;
	    menuPrice= mp;
	  }

	  public String getMenuName()
	  {
	    return menuName ;
	  }
	  public int getMenuPrice()
	  {
	    return menuPrice ;
	  }
	 /* public void MenuList() { 
	  menuInfo.put("불고기피자", 14000);

		menuInfo.put("고르곤졸라", 12000);

		menuInfo.put("로제파스타", 9000);		

		menuInfo.put("토마토파스타", 9000);

		menuInfo.put("크림파스타", 9000);

		
	  }
	  
	  Set<String> keySet = menuInfo.keySet();
	  Iterator<String> keyIterator = keySet.iterator();
     
	  public Integer choosenMenuPrice(String menuName) { 
		  while (keyIterator.hasNext()){
			  String key = keyIterator.next();
			  Integer value = menuInfo.get(key);
	          if(key.equals(menuName)) { 
				  return value; } }
		return 0;
	      }   */
	

	
	
	




}
