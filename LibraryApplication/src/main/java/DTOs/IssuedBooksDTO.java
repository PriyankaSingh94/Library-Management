package main.java.DTOs;

import java.util.Date;

public class IssuedBooksDTO {
	
	private int issuedId;
	private int libId;
	private int bookId;
	private Date issuedDate;
	private Date returnDate;
	
	public int getIssuedId() {
		return issuedId;
	}
	public void setIssuedId(int issuedId) {
		this.issuedId = issuedId;
	}
	public int getLibId() {
		return libId;
	}
	public void setLibId(int libId) {
		this.libId = libId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	

}
