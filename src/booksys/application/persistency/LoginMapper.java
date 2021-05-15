package booksys.application.persistency;

import java.sql.* ;

import booksys.storage.Database;

public class LoginMapper {
	public int login (String userName, String userPhone)
	  {
	    String sql = "SELECT phoneNumber FROM Customer WHERE name= ?";
	    try
	    {
		    PreparedStatement pstmt
			= Database.getConnection().prepareStatement(sql) ;
		    ResultSet rset =  pstmt.executeQuery() ;
		    if(rset.next()) {
		    	if(rset.getString(1).equals(userPhone))
		    		return 1; //로그인 성공
		    	else 
		    		return 0; //전화번호 불일치
		    }
		    return -1; //고객 이름 존재하지않음
	    } catch (SQLException e) {
	      e.printStackTrace() ;
	    }
	    return -2; //데이터베이스오류
	  }
}