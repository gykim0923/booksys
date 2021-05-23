package booksys.application.domain;

import java.util.Arrays;

public class Manager {
	 private String menuName ;
	private int bpCount;
	private int gzCount;
	private int rpCount;
	private int tmCount;
	private int creamCount;
	private int mCount[];
	private int max;
	private int maxIndex;
	 private static int totalSales;
	 public Manager (int ts, String mn)
	  {
		totalSales= ts;
	    menuName = mn ;
	    
	  }
	 public String getBestMenu(String mn)
	  {
	    switch (mn) {
	    case "불고기피자": 
	    	mCount[0]+=1;
	    	break;
	    case "고르곤졸라": 
	    	mCount[1]+=1;
	    	break;
	    case "로제파스타": 
	    	mCount[2]+=1;
	    	break;
	    case "토마토파스타": 
	    	mCount[3]+=1;
	    	break;
	    case "크림파스타": 
	    	mCount[4]+=1;
	    	break;
	    
	    }
	    for (int i = 0; i < mCount.length; i++) {
	    	if (mCount[i] > max) {
	    	max = mCount[i];
	    	maxIndex = i;
	    	}
	    	}
	    switch (maxIndex) {
	    case 0: 
	    	return "불고기피자";
		case 1: 
	    	return "고르곤졸라";
		case 2: 
	    	return "로제파스타";
		case 3: 
	    	return "토마토파스타";
		case 4: 
	    	return "크림파스타";
	    
	    }

	    	
	  }
	  static int getTotalSales(int sales)
	  {
		totalSales+=sales;
	    return totalSales;
	  }
	  

}
