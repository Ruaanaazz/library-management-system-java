package uidesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
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
import entity.Book;

public class BookForm extends JFrame implements ActionListener{
	JLabel title, subTitle1, subTitle2,titleLbl, booknoLbl,authorLbl,publisherLbl,costLbl,pagesLbl;
	JTextField booknoTxt, titleTxt, authorTxt, publisherTxt, costTxt, pagesTxt;
	JButton addBtn, findBtn, updateBtn,deleteBtn;
	JTable table;
	JPanel panel1;
	DefaultTableModel tableModel;
	BookOperations bookOperations = new BookOperations();
	public BookForm() {
		setLayout(null);
		title = new JLabel("Library Management System");
		title.setFont(new Font ("arial", Font.BOLD, 20));
		title.setForeground(Color.RED);
		title.setBounds(200, 50, 350, 50);
		add(title);
		
		subTitle1 = new JLabel("Add book....");
		subTitle1.setFont(new Font ("arial", Font.BOLD, 20));
		subTitle1.setForeground(Color.blue);
		subTitle1.setBounds(50, 100, 300, 50);
		add(subTitle1);
		
		booknoLbl = new JLabel("book no:");
		titleLbl = new JLabel("title :");
		authorLbl = new JLabel("author:");
		publisherLbl = new JLabel("publisher:");
		costLbl = new JLabel("cost:");
		pagesLbl = new JLabel("pages:");
		
		booknoTxt = new JTextField(20);
		titleTxt = new JTextField(20);
		authorTxt = new JTextField(20);
		publisherTxt = new JTextField(20);
		costTxt = new JTextField(20);
		pagesTxt = new JTextField(20);
		
		addBtn = new JButton("add");
		findBtn = new JButton("find");
		updateBtn = new JButton("update");
		deleteBtn =new JButton("delete");
		
		panel1 = new JPanel();
		GridLayout gl = new GridLayout(6,3,10,10);
		panel1.setLayout(gl);
		panel1.setBounds(50,150,460,250);
		panel1.setBackground(Color.gray);
		
		panel1.add(booknoLbl);
		panel1.add(booknoTxt);
		panel1.add(addBtn);
		
		panel1.add(titleLbl);
		panel1.add(titleTxt);
		panel1.add(findBtn);
		
		
		panel1.add(authorLbl);
		panel1.add(authorTxt);
		panel1.add(updateBtn);
		
		panel1.add(publisherLbl);
		panel1.add(publisherTxt);
		panel1.add(deleteBtn);
		
		panel1.add(costLbl);
		panel1.add(costTxt);
		panel1.add(new JLabel(" "));
		
		panel1.add(pagesLbl);
		panel1.add(pagesTxt);
		panel1.add(new JLabel(" "));
		
		add(panel1);
		 tableModel = new DefaultTableModel();
	        tableModel.addColumn("BookNo");
	        tableModel.addColumn("Title");
	        tableModel.addColumn("Author");
	        tableModel.addColumn("Publisher");
	        tableModel.addColumn("Cost");
	        tableModel.addColumn("Pages");
	        table = new JTable(tableModel);
	        JScrollPane sp = new JScrollPane(table);
	        sp.setBounds(50, 410, 600, 200);
	  
	        add(sp);
	        loadBookData();
	        addBtn.addActionListener(this);
	        findBtn.addActionListener(this);
	        deleteBtn.addActionListener(this);
	        updateBtn.addActionListener(this);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String btnText = e.getActionCommand();
	            if (btnText.equalsIgnoreCase("ADD")) {
	            	Book book = new Book();
	                book.setBook_no(Integer.parseInt(booknoTxt.getText()));
	                book.setTitle(titleTxt.getText());
	                book.setAuthor(authorTxt.getText());
	                book.setPublisher(publisherTxt.getText());
	                book.setCost(Integer.parseInt(costTxt.getText()));
	                book.setPages(Integer.parseInt(pagesTxt.getText()));

	               int status = bookOperations.addBook(book);

	                if (status == 1)
	                    JOptionPane.showMessageDialog(this, "Book Added Successfully");
	                else
	                    JOptionPane.showMessageDialog(this, "Insert Failed!");

	             }
	            else if(btnText.equalsIgnoreCase("find")) {
	            	int book_no = Integer.parseInt(booknoTxt.getText());
	                Book book = bookOperations.findBook(book_no);

	                if (book == null) {
	                    JOptionPane.showMessageDialog(this, "Record Not Found.");
	                } else {
	                    titleTxt.setText(book.getTitle());
	                    authorTxt.setText(book.getAuthor());
	                    publisherTxt.setText(book.getPublisher());
	                    costTxt.setText("" + book.getCost());
	                    pagesTxt.setText("" + book.getPages());
	            	
	                } 
	                }else if(btnText.equalsIgnoreCase("delete")) {
	                	int book_no = Integer.parseInt(booknoTxt.getText());
	                	// find the book on book_no
	                	Book book = bookOperations.findBook(book_no);
	                	if(book == null) {
	                		JOptionPane.showMessageDialog(this, "Record Not Found.");
	                	}else {
	                		int response = JOptionPane.showConfirmDialog(this, "want to delete this book?");
	                		System.out.println("response="+response);
	                		if(response ==0) {
	                	int n= bookOperations.deleteBook(book_no);
	                	JOptionPane.showMessageDialog(this, "Record deleted.");
	                	}
	                	}
	             	
	                }else if(btnText.equalsIgnoreCase("update")) {
	                	Book book = new Book();
		                book.setBook_no(Integer.parseInt(booknoTxt.getText()));
		                book.setTitle(titleTxt.getText());
		                book.setAuthor(authorTxt.getText());
		                book.setPublisher(publisherTxt.getText());
		                book.setCost(Integer.parseInt(costTxt.getText()));
		                book.setPages(Integer.parseInt(pagesTxt.getText()));

		               int status = bookOperations.updateBook(book);

		                if (status == 1)
		                    JOptionPane.showMessageDialog(this, "Book updated Successfully");
		                else
		                    JOptionPane.showMessageDialog(this, "updation Failed!");
	                }
	          loadBookData();   
}
	    public void loadBookData() {
	    	List <Book> booksList = bookOperations.getAllBooks();
	    	tableModel.setRowCount(0);
	    	for(Book book:booksList) {
	    		tableModel.addRow(new Object[] {book.getBook_no(),
	    				book.getTitle(),
	    		book.getAuthor(),
	    		book.getPublisher(),
	    		book.getCost(),
	    			book.getPages()});
	    		
	    	}
	    }}
	    