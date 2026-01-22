package dbase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutils.DBConnection;
import entity.Book;

public class BookOperations {
public int addBook(Book book) {
	int status = 0;
	try {
		Connection conn = DBConnection.getConnection();
		String qry = "insert into book(book_no,title,author,publisher,cost,pages) values (?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(qry);
		pst.setInt(1, book.getBook_no());
		pst.setString(2, book.getTitle());
		pst.setString(3, book.getAuthor());
		pst.setString(4, book.getPublisher());
		pst.setInt(5, book.getCost());
		pst.setInt(6, book.getPages());
		
		status = pst.executeUpdate();
		
	}catch(Exception e) {
		System.out.println("error in addbook():"+e.getMessage());
	}
	return status;
}

public Book findBook(int book_no) {

    Book book = null;

    try {
        Connection conn = DBConnection.getConnection();
        String qry = "select book_no, title, author, publisher, cost, pages from book where book_no=?";
        PreparedStatement pst = conn.prepareStatement(qry);

        pst.setInt(1, book_no);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            book = new Book();
            book.setBook_no(rs.getInt("book_no"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setPublisher(rs.getString("publisher"));
            book.setCost(rs.getInt("cost"));
            book.setPages(rs.getInt("pages"));
        }

        pst.close();
        conn.close();

    } catch (Exception e) {
        System.out.println("Error in findBook(): " + e.getMessage());
    }

    return book;
}

public List<Book> getAllBooks(){
	List<Book> booksList = new ArrayList<Book>();
	try {
		Connection conn = DBConnection.getConnection();
		String qry = "select book_no,title,author,publisher,cost,pages from book";
		PreparedStatement pst = conn.prepareStatement(qry);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Book book = new Book();
			book.setBook_no(rs.getInt("book_no"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPublisher(rs.getString("Publisher"));
			book.setCost(rs.getInt("Cost"));
			book.setPages(rs.getInt("Pages"));
			booksList.add(book);
		}
		pst.close();
		conn.close();
	}catch(Exception e) {
		System.out.println("error in addbook:"+e.getMessage());
	}
	return booksList;
}
public int deleteBook(int book_no) {
	 int status = 0;
	 try {
	        Connection conn = DBConnection.getConnection();
	        String qry = "delete from book where book_no=?";
	        PreparedStatement pst = conn.prepareStatement(qry);
	        pst.setInt(1, book_no);
	        status = pst.executeUpdate();

	        pst.close();
	        conn.close();

	    } catch (Exception e) {
	        System.out.println("Error in findBook(): " + e.getMessage());
	    }
return status;
}
public int updateBook(Book book) {
	int status = 0;
	try {
		Connection conn = DBConnection.getConnection();
		String qry = "update book set title=?,author=?,publisher=?,cost=?,pages=? where book_no=?";
		PreparedStatement pst = conn.prepareStatement(qry);
		pst.setString(1, book.getTitle());
		pst.setString(2, book.getAuthor());
		pst.setString(3, book.getPublisher());
		pst.setInt(4, book.getCost());
		pst.setInt(5, book.getPages());
		pst.setInt(6, book.getBook_no());	
		status = pst.executeUpdate();
		
	}catch(Exception e) {
		System.out.println("error in addbook():"+e.getMessage());
	}
	return status;
}
}
