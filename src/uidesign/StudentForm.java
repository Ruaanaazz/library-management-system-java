package uidesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dbase.BookOperations;
import dbase.StudentOperations;
import entity.Student;

public class StudentForm extends JFrame implements ActionListener{
	JLabel title, subTitle1, subTitle2,nameLbl, stud_idLbl,branchLbl,semLbl,mobileLbl,emailLbl;
	JTextField stud_idTxt, nameTxt, branchTxt, semTxt, mobileTxt, emailTxt;
	JButton addBtn, findBtn, updateBtn,deleteBtn;
	JTable table;
	JPanel panel1;
	DefaultTableModel tableModel;
	StudentOperations studentOperations = new StudentOperations();
	public StudentForm() {
		setLayout(null);
		title = new JLabel("Library Management System");
		title.setFont(new Font ("arial", Font.BOLD, 20));
		title.setForeground(Color.RED);
		title.setBounds(200, 50, 350, 50);
		add(title);
		
		subTitle1 = new JLabel("Add Student....");
		subTitle1.setFont(new Font ("arial", Font.BOLD, 20));
		subTitle1.setForeground(Color.blue);
		subTitle1.setBounds(50, 100, 300, 50);
		add(subTitle1);
		
		stud_idLbl = new JLabel("Student id:");
		nameLbl = new JLabel("Name :");
		branchLbl = new JLabel("branch:");
		semLbl = new JLabel("Sem:");
		mobileLbl = new JLabel("Mobile:");
		emailLbl = new JLabel("Email:");
		
		stud_idTxt = new JTextField(20);
		nameTxt = new JTextField(20);
		branchTxt = new JTextField(20);
		semTxt = new JTextField(20);
		mobileTxt = new JTextField(20);
		emailTxt = new JTextField(20);
		
		addBtn = new JButton("add");
		findBtn = new JButton("find");
		updateBtn = new JButton("update");
		deleteBtn =new JButton("delete");
		
		panel1 = new JPanel();
		GridLayout gl = new GridLayout(6,3,10,10);
		panel1.setLayout(gl);
		panel1.setBounds(50,150,460,250);
		panel1.setBackground(Color.gray);
		
		panel1.add(stud_idLbl);
		panel1.add(stud_idTxt);
		panel1.add(addBtn);
		
		panel1.add(nameLbl);
		panel1.add(nameTxt);
		panel1.add(findBtn);
		
		
		panel1.add(branchLbl);
		panel1.add(branchTxt);
		panel1.add(updateBtn);
		
		panel1.add(semLbl);
		panel1.add(semTxt);
		panel1.add(deleteBtn);
		
		panel1.add(mobileLbl);
		panel1.add(mobileTxt);
		panel1.add(new JLabel(" "));
		
		panel1.add(emailLbl);
		panel1.add(emailTxt);
		panel1.add(new JLabel(" "));
		
		add(panel1);
		 tableModel = new DefaultTableModel();
	        tableModel.addColumn("Stud_id");
	        tableModel.addColumn("Name");
	        tableModel.addColumn("Branch");
	        tableModel.addColumn("Sem");
	        tableModel.addColumn("Mobile");
	        tableModel.addColumn("Email");
	        table = new JTable(tableModel);
	        JScrollPane sp = new JScrollPane(table);
	        sp.setBounds(50, 410, 600, 200);
	  
	        add(sp);
	        loadStudentData();
	        addBtn.addActionListener(this);
	        findBtn.addActionListener(this);
	        deleteBtn.addActionListener(this);
	        updateBtn.addActionListener(this);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String btnText = e.getActionCommand();
	            if (btnText.equalsIgnoreCase("ADD")) {
	            	Student student = new Student();
	            	student.setStud_id(stud_idTxt.getText());
	            	student.setName(nameTxt.getText());
	            	student.setBranch(branchTxt.getText());
	            	student.setSem(Integer.parseInt(semTxt.getText()));
	            	student.setMobile(mobileTxt.getText());
	            	student.setEmail(emailTxt.getText());

	               int status = studentOperations.addStudent(student);

	                if (status == 1)
	                    JOptionPane.showMessageDialog(this, "student Added Successfully");
	                else
	                    JOptionPane.showMessageDialog(this, "Insert Failed!");

	             }
	            else if(btnText.equalsIgnoreCase("find")) {
	            	String stud_id = stud_idTxt.getText();
	                Student student = studentOperations.findStudent(stud_id);

	                if (student == null) {
	                    JOptionPane.showMessageDialog(this, "Record Not Found.");
	                } else {
	                    nameTxt.setText(student.getName());
	                    branchTxt.setText(student.getBranch());
	                    semTxt.setText(""+student.getSem());
	                    mobileTxt.setText(student.getMobile());
	                    emailTxt.setText(student.getEmail());
	            	
	                } 
	                }else if(btnText.equalsIgnoreCase("delete")) {
	                	String stud_id = stud_idTxt.getText();
	                	// find the book on book_no
	                	Student student = studentOperations.findStudent(stud_id);
	                	if(student == null) {
	                		JOptionPane.showMessageDialog(this, "Record Not Found.");
	                	}else {
	                		int response = JOptionPane.showConfirmDialog(this, "want to delete this book?");
	                		System.out.println("response="+response);
	                		if(response ==0) {
	                	int n= studentOperations.deleteStudent(stud_id);
	                	JOptionPane.showMessageDialog(this, "Record deleted.");
	                	}
	                	}
	             	
	                }else if(btnText.equalsIgnoreCase("update")) {
	                	Student student = new Student();
	                	student.setStud_id(stud_idTxt.getText());
	                	student.setName(nameTxt.getText());
	                	student.setBranch(branchTxt.getText());
	                	student.setSem(Integer.parseInt(semTxt.getText()));
	                	student.setMobile(mobileTxt.getText());
	                	student.setEmail(emailTxt.getText());

		               int status = studentOperations.updateStudent(student);

		                if (status == 1)
		                    JOptionPane.showMessageDialog(this, "student updated Successfully");
		                else
		                    JOptionPane.showMessageDialog(this, "updation Failed!");
	                }
	          loadStudentData();   
}
	    public void loadStudentData() {
	    	List <Student> studentsList = studentOperations.getAllStudents();
	    	tableModel.setRowCount(0);
	    	for(Student student:studentsList) {
	   
	    		tableModel.addRow(new Object[] {student.getStud_id(),
	    				student.getName(),
	    				student.getBranch(),
	    		student.getSem(),
	    		student.getMobile(),
	    		student.getEmail()});
	    		
	    	}
	    }

}
