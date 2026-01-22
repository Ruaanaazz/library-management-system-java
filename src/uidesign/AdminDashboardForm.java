package uidesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminDashboardForm extends JFrame implements ActionListener{
	JButton booksBtn, studentsBtn, bookIssueBtn, fineBtn, logoutBtn;
	JLabel title,menuTitle;
	
	public AdminDashboardForm() {
		setLayout(null);
		title = new JLabel("Library Management System");
		title.setFont(new Font ("arial", Font.BOLD, 20));
		title.setForeground(Color.RED);
		title.setBounds(200, 50, 350, 50);
		add(title);
		
		menuTitle = new JLabel("Main menu");
		menuTitle.setFont(new Font ("arial", Font.BOLD, 20));
		menuTitle.setForeground(Color.RED);
		menuTitle.setBounds(280, 100, 300, 50);
		add(menuTitle);	
		
		booksBtn = new JButton("books");
		booksBtn.setBounds(300,160,130,50);
		add(booksBtn);
		
		studentsBtn = new JButton("Students");
		studentsBtn.setBounds(300,220,130,50);
		add(studentsBtn);
		
		bookIssueBtn = new JButton("Book issue");
		bookIssueBtn.setBounds(300,280,130,50);
		add(bookIssueBtn);
		
		fineBtn = new JButton("Fines");
		fineBtn.setBounds(300,340,130,50);
		add(fineBtn);
		
		logoutBtn = new JButton("logout");
		logoutBtn.setForeground(Color.RED);
		logoutBtn.setBounds(300,400,130,50);
		add(logoutBtn);
		
		booksBtn.addActionListener(this);
		studentsBtn.addActionListener(this);
		bookIssueBtn.addActionListener(this);
		fineBtn.addActionListener(this);
		logoutBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnText = e.getActionCommand();
		if(btnText.equalsIgnoreCase("BOOKS")) {
			BookForm bookForm = new BookForm();
		bookForm.setSize(1000,700);
		bookForm.setVisible(true);
		}else if(btnText.equalsIgnoreCase("STUDENTS")) {
			StudentForm studentForm = new StudentForm();
			studentForm.setSize(1000,700);
			studentForm.setVisible(true);
			
		}else if(btnText.equals("BOOK ISSUE")) {
			
		}else if(btnText.equals("fines")) {
			
		}else if(btnText.equals("logout")) {
			System.exit(1);
	}
	}
}