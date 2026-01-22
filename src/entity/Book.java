package entity;

public class Book {
private int book_no;
private String title;
private String author;
private String publisher;
private int cost;
private int pages;
public Book() {
	super();
}
public Book(int book_no, String title, String author, String publisher, int cost, int pages) {
	super();
	this.book_no = book_no;
	this.title = title;
	this.author = author;
	this.publisher = publisher;
	this.cost = cost;
	this.pages = pages;
}
public int getBook_no() {
	return book_no;
}
public void setBook_no(int book_no) {
	this.book_no = book_no;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public int getPages() {
	return pages;
}
public void setPages(int pages) {
	this.pages = pages;
}
@Override
public String toString() {
	return "Book [book_no=" + book_no + ", title=" + title + ", author=" + author + ", publisher=" + publisher
			+ ", cost=" + cost + ", pages=" + pages + "]";
}


		
		

	}


