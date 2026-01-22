package uidesign;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dbase.AdminOperations;
import entity.Admin;

public class AdminLoginForm extends JFrame implements ActionListener{
	JLabel title,loginTitle,usernameLable,passwordLabel;
	JTextField usernameTxt;
	JPasswordField passwordTxt;
	JButton signinBtn;
public AdminLoginForm() {
	setLayout(null);
	title = new JLabel("Library management system");
	title.setFont(new Font("Arial", Font.BOLD, 20));
	title.setForeground(Color.red);
	title.setBounds(200,50,300,50);
	add(title);
	JPanel p = new JPanel();
	p.setLayout(null);
	p.setBackground(Color.GRAY);
	p.setBounds(100,100,600,300);
	
	loginTitle = new JLabel("Admin Login");
	loginTitle.setFont(new Font("Arial", Font.BOLD, 25));
	loginTitle.setForeground(Color.white);
	loginTitle.setBounds(50,50,200,30);
	p.add(loginTitle);
	
	 usernameLable = new JLabel("Username");
	 usernameLable.setFont(new Font("Arial", Font.BOLD, 20));
	 usernameLable.setBounds(50,100,100,30);
	 p.add(usernameLable);
	 usernameTxt = new JTextField();
	 usernameTxt.setBounds(50,130,300,30);
	 p.add(usernameTxt);
	 
	 passwordLabel = new JLabel("Password");
	 passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
	 passwordLabel.setBounds(50,170,100,30);
	 p.add(passwordLabel);
	 passwordTxt = new 	JPasswordField();
	 passwordTxt.setBounds(50,200,300,30);
	 p.add(passwordTxt);
	 
	 signinBtn = new JButton("Signin");
	 signinBtn.setForeground(Color.BLACK);
	 signinBtn.setBounds(50,250,120,40);
	 p.add(signinBtn);
	 add(p);
	 signinBtn.addActionListener(this);
	 
}
@Override
public void actionPerformed(ActionEvent e) {
String username = usernameTxt.getText();
String password = passwordTxt.getText();
AdminOperations adminOperations = new  AdminOperations();
Admin admin = new Admin(username,password);
boolean userExist = adminOperations.validateAdminLogin(admin);
System.out.println("userexists:"+userExist);
if(userExist) {
	JOptionPane.showMessageDialog(this, "login success.");
	AdminDashboardForm adminDashboardForm = new AdminDashboardForm();
	adminDashboardForm.setTitle("admin dashboard");
	adminDashboardForm.setSize(800,800);
	adminDashboardForm.setVisible(true);
	this.setVisible(false);
}else {
	JOptionPane.showMessageDialog(this, "login failed - u are a chor!!");
}
}

}
