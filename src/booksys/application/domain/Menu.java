package booksys.application.domain;

import java.util.ArrayList;

public class Menu {
	private ArrayList<Menu> menuItems1;
	
	public Menu(ArrayList<Menu> menuItems) {
		this.menuItems1 = menuItems;
	}

	
	// 메뉴판에 메뉴가 있는지 찾는 코드
	public Menu 메뉴선택(String menuName) {
		for (Menu menuItem : menuItems1) { // foreach문은 : 뒤에 배열이 들어가고 배열의 길이만큼 돈다
			if (menuItem.getMenuName().equals(menuName)) {
				
				// menuItems 리스트 안에 menuName와 같은 이름의 커피가 있다면 리턴
				//(리턴하면 함수를 빠져나간다)
				return menuItem;
			}
		}
		return null;
	}

	  public Menu choose(String menuName) {
			for (Menu menuItem : menuItems1) { // foreach문은 : 뒤에 배열이 들어가고 배열의 길이만큼 돈다
				if (menuItem.getMenuName().equals(menuName)) {
					
					// menuItems 리스트 안에 menuName와 같은 이름의 커피가 있다면 리턴
					//(리턴하면 함수를 빠져나간다)
					return menuItem;
				}
			}
			return null;
		}
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
