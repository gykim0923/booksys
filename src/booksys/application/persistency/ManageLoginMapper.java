package booksys.application.persistency;

import java.sql.* ;

import booksys.storage.Database;

public class ManageLoginMapper {
	public int login (String ManagerID, String Managerpassword)
	  {
	    String sql = "SELECT Managerpassword FROM Manager WHERE ManagerID= ?";
	    //manager라는 db를 만들어야함.
	    try
	    {
		    PreparedStatement pstmt2
			= Database.getConnection().prepareStatement(sql) ;
		    ResultSet rset2 =  pstmt2.executeQuery() ;
		    if(rset2.next()) {
		    	if(rset2.getString(1).equals(Managerpassword))
		    		return 1; //로그인 성공
		    	else 
		    		return 0; //비밀번호 불일치
		    }
		    return -1; //매니저 아이디를 잘못입력함
	    } catch (SQLException e) {
	      e.printStackTrace() ;
	    }
	    return -2; //데이터베이스오류
	  }
}