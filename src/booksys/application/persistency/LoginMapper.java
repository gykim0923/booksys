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
		    		return 1; //�α��� ����
		    	else 
		    		return 0; //��ȭ��ȣ ����ġ
		    }
		    return -1; //�� �̸� ������������
	    } catch (SQLException e) {
	      e.printStackTrace() ;
	    }
	    return -2; //�����ͺ��̽�����
	  }
}