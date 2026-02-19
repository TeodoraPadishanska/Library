package libraryManagment;
import java.text.DecimalFormat;

public class Invoice {

	Member member;
	DecimalFormat df = new DecimalFormat("#.00");
	
	void printInvoice() {
		System.out.println("=========== LIBRARY INVOICE ==========="+
			"\n Member: " + member.name +
			"\n Borrowing details:");
		
			for(Borrowing b : member.borrowings) {
				if(b.book.category().equals(" [PHYSICAL] ") && b.member.membershipType.equalsIgnoreCase("NORMAL") && 
						b.days > 7) {
					System.out.println(b + " days" + " + 1.0 * " + (b.days - 7) + " = "+ b.book.calculateFee(b) + "\n");
				}else {
					System.out.println(b + " days = " + Math.round((b.book.calculateFee(b) * 100.0) / 100.0) + "\n");
				}
			}
			
			
		System.out.println("Total fee: " + Math.round((member.getTotalFee() *100.0)/100.0));
	}
}
