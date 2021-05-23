package booksys.application.persistency;

import booksys.application.domain.Menu;

class PersistentMenu extends Menu {
	private int oid ;

	PersistentMenu(int id, String mn, int mp)
	{
	    super(mn, mp) ;
	    oid = id ;
	 }

	int getId() {
	    return oid ;
	 }

}
