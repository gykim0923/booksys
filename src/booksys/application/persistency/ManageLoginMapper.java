package booksys.application.persistency;

import java.sql.* ;

import booksys.storage.Database;

public class ManageLoginMapper {
	public int login (String ManagerID, String Managerpassword)
	  {
	    String sql = "SELECT Managerpassword FROM Manager WHERE ManagerID= ?";
	    //manager��� db�� ��������.
	    try
	    {
		    PreparedStatement pstmt2
			= Database.getConnection().prepareStatement(sql) ;
		    ResultSet rset2 =  pstmt2.executeQuery() ;
		    if(rset2.next()) {
		    	if(rset2.getString(1).equals(Managerpassword))
		    		return 1; //�α��� ����
		    	else 
		    		return 0; //��й�ȣ ����ġ
		    }
		    return -1; //�Ŵ��� ���̵� �߸��Է���
	    } catch (SQLException e) {
	      e.printStackTrace() ;
	    }
	    return -2; //�����ͺ��̽�����
	  }
}