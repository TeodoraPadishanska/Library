package libraryManagment;

public class EBook extends Book{

	EBook(String title, String author, int availableCopies, double baseRate) {
		super(title, author, availableCopies, baseRate); 
	}
	EBook(int id, String title, String author, int availableCopies, double baseRate) {
		super(id, title, author, availableCopies, baseRate); 
	}
	
	@Override
	public double calculateFee(Borrowing borrowing) {
		return borrowing.book.baseRate * borrowing.days;
	}
	
	public String category() {
		return " [EBOOK] ";
	}

}
