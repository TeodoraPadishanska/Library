package libraryManagment;

import java.util.*;

public class Member {

	String name;
	String membershipType;
	List<Borrowing> borrowings = new ArrayList<>();
	
	void addBorrowing(Borrowing borrowing) {
		borrowings.add(borrowing);
	}
	double getTotalFee() {
		double totalFee = 0;
		for(Borrowing b : borrowings) {
			totalFee+=b.book.calculateFee(b);
		}
		return totalFee;
	}
}
