package driver;

import dbase.AdminOperations;
import entity.Admin;
import uidesign.AdminLoginForm;
public class Mainprg {

	public static void main(String[] args) {
		// test admin login
//		AdminOperations adminOperations = new  AdminOperations();
//		Admin admin = new Admin("admin","12345");
//		boolean userExist = adminOperations.validateAdminLogin(admin);
//		System.out.println("userexists:"+userExist);
		AdminLoginForm adminLoginForm = new AdminLoginForm();
		adminLoginForm.setTitle("Admin login");
		adminLoginForm.setSize(800,800);
		adminLoginForm.setVisible(true);
	}

}
