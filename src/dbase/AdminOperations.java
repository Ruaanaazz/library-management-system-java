package dbase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.net.httpserver.Authenticator.Result;

import dbutils.DBConnection;
import entity.Admin;
// as we alr created var in admin.java we gonna simply pass it as object
public class AdminOperations {
public boolean validateAdminLogin(Admin admin) {
	boolean userExist = false;
	
	try {
	Connection conn = DBConnection.getConnection();
	String qry ="select * from admin where username=? and password = ?";
	PreparedStatement pst = conn.prepareStatement(qry);
	pst.setString(1, admin.getUsername());
	pst.setString(2, admin.getPassword());
	ResultSet rs = pst.executeQuery();
	if(rs.next()) {//if row exists
		userExist = true;
	}//else {
		// row doesnt exists
	//	userExist = false;
	//}
	rs.close();
	pst.close();
	conn.close();
	}catch(Exception e) {
		System.out.println("error : adminOperation.validateAdminLogin:"+e.getMessage());
		// or use e.printstacktrace
	}
	return userExist;
	
}
}
