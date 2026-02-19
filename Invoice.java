package libraryManagment;

public class Invoice {

	Member member;
	
	void printInvoice() {
		System.out.println("=========== LIBRARY INVOICE ==========="+
			"\n Member: " + member.name +
			"\n Borrowing details:");
		
			for(Borrowing b : member.borrowings) {
				if(b.book.category().equals(" [PHYSICAL] ") && b.member.membershipType.equalsIgnoreCase("NORMAL") && 
						b.days > 7) {
					System.out.println(b + " days" + " + 1.0 * " + (b.days - 7) + " = "+ b.book.calculateFee(b) + "\n");
				}else {
					System.out.println(b + " days = " + b.book.calculateFee(b) + "\n");
				}
			}
		System.out.println("Total fee: " + member.getTotalFee());
	}
}
