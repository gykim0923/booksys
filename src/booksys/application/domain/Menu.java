package booksys.application.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
public class Menu {
	
	  private String menuName ;
	  HashMap<String, Integer> menuInfo = new HashMap<String, Integer>();
	
	 
	  public Menu (String mn)
	  {
	    menuName = mn ;
	  }

	  public String getMenuName()
	  {
	    return menuName ;
	  }
	  public void MenuList() { 
	  menuInfo.put("불고기피자", 14000);

		menuInfo.put("고르곤졸라", 12000);

		menuInfo.put("로제파스타", 9000);		

		menuInfo.put("토마토파스타", 9000);

		menuInfo.put("크림파스타", 9000);

		
	  }
	  Iterator<String> keys = menuInfo.keySet().iterator();
      
	  public String chooseMenu(String menuName) { 
		  while (keys.hasNext()){
			  String key = keys.next();
	          if(key.equals(menuName)) { 
				  return key; } }
	      }
	  
	ArrayList<String> menu= new ArrayList<String>();
	
	for(int i =0; i<menu.size(); i++) {
		menu.addAll(menu);
}
		



}}
