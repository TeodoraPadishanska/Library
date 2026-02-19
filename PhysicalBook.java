package libraryManagment;

public class PhysicalBook extends Book{

	PhysicalBook(String title, String author, int availableCopies, double baseRate) {
		super(title, author, availableCopies, baseRate); 
	}
	PhysicalBook(int id, String title, String author, int availableCopies, double baseRate) {
		super(id, title, author, availableCopies, baseRate); 
	}

	@Override
	public double calculateFee(Borrowing borrowing) {
		double fee = borrowing.book.baseRate * borrowing.days;
		if(borrowing.days > 7 && borrowing.member.membershipType.equalsIgnoreCase("NORMAL")) {
			fee+=borrowing.days-7;
		}
		return fee;
	}
	
	public String category() {
		return " [PHYSICAL] ";
	}
	
	
//	public double calculateFee(Borrowing borrowing) {
//		int borrowDay = borrowing.borrowDate.getDayOfMonth();
//		int returnDay = borrowing.returnDate.getDayOfMonth();
//		int borrowMonth = borrowing.borrowDate.getMonthValue();
//		int returnMonth = borrowing.returnDate.getMonthValue();
//		int daysBorrowed;
//		
//		double fee = borrowing.days * borrowing.book.baseRate;
//		
//		if(returnDay > borrowDay && borrowMonth == returnMonth) {
//			if(returnDay - borrowDay > borrowing.days) {
//				fee+=(returnDay - (borrowDay + borrowing.days));
//			}
//		}else if(returnDay > borrowDay && borrowMonth < returnMonth) {
//			
//			if(borrowMonth >= 7) {
//				if(borrowMonth == 2) {
//					daysBorrowed = 28 - borrowDay + returnDay;
//				}else if(borrowMonth % 2 == 0) {
//					daysBorrowed = 30 - borrowDay + returnDay;
//				}else {
//					daysBorrowed = 31 - borrowDay + returnDay;
//				}
//			}else {
//				if(borrowMonth % 2 == 0) {
//					daysBorrowed = 31 - borrowDay + returnDay;
//				}else {
//					daysBorrowed = 30 - borrowDay + returnDay;
//				}
//			}
//			
//			if(daysBorrowed > borrowing.days) {
//				fee += daysBorrowed - borrowing.days;
//			}
//		}
//		
////		else if() {			//za mnogo dulgo vreme, returnDay < borrowDay && borrowMonth > returnMonth
////			
////		}
//		
//		return fee;
//		
//	}
	
	
//	@Override
//	public String line(Borrowing borrowing) {
//		return null;
//	}
//	
	
	
}
