package libraryManagment;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Member member = new Member();
		
		System.out.println("Name: ");
		member.name = scan.nextLine();
		System.out.println("Membership type (NORMAL/PREMIUM):");
		member.membershipType = scan.nextLine();

		List<Book> avalibleBooks = new ArrayList<>();
		Book book1 = new PhysicalBook("The Great Gatsby", "F. Scott Fitzgerald", 5, 1.50);
		avalibleBooks.add(book1);
		Book book2 = new PhysicalBook("1984", "George Orwell", 3, 1.00);
		avalibleBooks.add(book2);
		Book book3 = new EBook("Digital Fortress", "Dan Brown", 0, 0.99);
		avalibleBooks.add(book3);
		Book book4 = new EBook("The Catcher in the Rye", "J.D. Salinger", 0, 1.20);
		avalibleBooks.add(book4);
		Book book5 = new PhysicalBook("To Kill a Mockingbird", "Harper Lee", 10, 1.80);
		avalibleBooks.add(book5);
		Book book6 = new EBook("Moby Dick", "Herman Melville", 0, 1.00);
		avalibleBooks.add(book6);
		
		System.out.println("\n            Available books         ");
		for(Book b : avalibleBooks) {
			System.out.println(b);
		}
		
		int option = 1;
		while(option != 0) {
			System.out.println("\n Choose an option: " + 
							"\n 1) Borrow a book" + 
							"\n 0) Print invoice");
			option = scan.nextInt();
			
			if(option == 1) {
				Borrowing borrowing = new Borrowing();
				System.out.println("Choose book id: ");
				int id = scan.nextInt();
				for(Book b : avalibleBooks) {
					if(b.id == id) {
						if(b.availableCopies > 0 || b.category().equals(" [EBOOK] ")) {
							borrowing.book = b;
							if(b.category().equals(" [PHYSICAL] ")) {
								b.availableCopies--;
							}
						}else {
							System.out.println("No available copies");
							return;
						}
					}
				}
//				if(borrowing.book.equals(null)) {
//					System.out.println("Invalid option. No books with this id number.");
//					return;
//				}
				System.out.println("Number of days: ");
				borrowing.days = scan.nextInt();
				borrowing.member = member;
				member.borrowings.add(borrowing);
			}else if(option == 0) {
				break;
			}else {
				System.out.println("Invalid option");
			}
			
		}
		Invoice invoice = new Invoice();
		invoice.member = member;
		invoice.printInvoice();
		
		
		
		
		
		
		
	}

}
