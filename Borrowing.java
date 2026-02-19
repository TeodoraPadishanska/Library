package libraryManagment;

import java.time.LocalDate;

public class Borrowing {

	Book book;
	int days;
	LocalDate borrowDate = LocalDate.now();
	LocalDate returnDate = borrowDate.plusDays(days);
	Member member;
	

	void setDays(int days) {
		this.days = days;
	}
	
	public String toString() {
		return " Book: " + book.getTitle() + book.category() + " fee: " + book.getBaseRate() + " * " + days;
	}
}
