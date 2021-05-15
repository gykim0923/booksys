package booksys.application.persistency;

import booksys.storage.*;

import java.sql.* ;
import java.util.Enumeration ;
import java.util.Hashtable ;
import java.util.Vector ;

public class MenuMapper {
	private Hashtable cache ;

	  private PersistentMenu getFromCache(int oid)
	  {
	    Integer key = new Integer(oid) ;
	    return (PersistentMenu) cache.get(key) ;
	  }

	  private PersistentMenu getFromCacheByDetails(String mname)
	  {
		PersistentMenu m = null ;
	    Enumeration enums = cache.elements() ;
	    while (m == null & enums.hasMoreElements()) {
	    	PersistentMenu tmp = (PersistentMenu) enums.nextElement() ;
	      if (mname.equals(tmp.getMenuName())) {
	    	  m = tmp ;
	      }
	    }
	    return m ;
	  }
	  
	  private void addToCache(PersistentMenu m)
	  {
	    Integer key = new Integer(m.getId()) ;
	    cache.put(key, m) ;
	  }
	  
	  // Constructor:
	  
	  private MenuMapper()
	  {
	    cache = new Hashtable() ;
	  }

	  // Singleton:
	  
	  private static MenuMapper uniqueInstance ;

	  public static MenuMapper getInstance()
	  {
	    if (uniqueInstance == null) {
	      uniqueInstance = new MenuMapper() ;
	    }
	    return uniqueInstance ;
	  }

	  public PersistentMenu getMenu(String mname)
	  {
		PersistentMenu m = getFromCacheByDetails(mname) ;
	    if (m == null) {
	      m = getMenuSQL("SELECT * FROM Menu WHERE menuName=" + mname + "") ; //STACKOVERFLOW ¹ß»ý,ÇØ°á
	      if (m != null) {
	    	  addToCache(m) ;
	      }
	    }
	    return m ;
	  }

	  PersistentMenu getMenuForOid(int oid)
	  {
		PersistentMenu m = getFromCache(oid) ;
	    if (m == null) {
	      m = getMenuSQL("SELECT * FROM Menu WHERE oid ='" + oid + "'") ; //º¯°æ
	      if (m != null) {
	    	  addToCache(m) ;
	      }
	    }
	    return m ;
	  }

	  private PersistentMenu getMenuSQL(String sql)
	  {
		PersistentMenu m = null ;
	    try {
	      Statement stmt
		= Database.getInstance().getConnection().createStatement() ;
	      ResultSet rset = stmt.executeQuery(sql) ;
	      while (rset.next()) {
		int oid    = rset.getInt(1) ;
		String menuName = rset.getString(2) ;
		 m = new PersistentMenu(oid, menuName) ;
	      }
	      rset.close() ;
	      stmt.close() ;
	    }
	    catch (SQLException e) {
	      e.printStackTrace() ;
	    }
	    return m ;
	  }

	  public Vector getMenuName()
	  {
	    Vector v = new Vector() ;
	    try {
	      Statement stmt
		= Database.getInstance().getConnection().createStatement() ;
	      ResultSet rset
		= stmt.executeQuery("SELECT * FROM Menu ORDER BY oid") ;
	      while (rset.next()) {
		v.addElement(new String(rset.getString(2))) ;
	      }
	      rset.close() ;
	      stmt.close() ;
	    }
	    catch (SQLException e) {
	      e.printStackTrace() ;
	    }
	    return v ;
	  }    
}