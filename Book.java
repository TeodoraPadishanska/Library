package libraryManagment;

public abstract class Book {

	int id;
	String title;
	String author;
	int availableCopies;
	double baseRate;		//такса на ден
	static int nextId = 1;
//	String line = "=========== LIBRARY INVOICE ==========="+
//			"\n Member: " + 
//			"\n Borrowing details:";
	
	
//	try {
//		int a = 5 / 0;
//		
//	} catch(ArithmeticException e){
//		System.out.println("Error: cannot devide by 0");
//	}
//	finally {
//		
//	}
	
	
	Book(String title, String author, int availableCopies, double baseRate){
		this.title = title;
		this.author = author;
		if(availableCopies >= 0) {
			this.availableCopies = availableCopies;
		}else {
			throw new IllegalArgumentException("Must be positive");
		}
		if(baseRate > 0) {
			this.baseRate = baseRate;
		}else {
			throw new IllegalArgumentException("Must be more than 0");
		}
		this.id = nextId;
		nextId+=1;
	}
	Book(int id, String title, String author, int availableCopies, double baseRate){
		this.id = id;
		this.title = title;
		this.author = author;
		if(availableCopies >= 0) {
			this.availableCopies = availableCopies;
		}else {
			throw new IllegalArgumentException("Must be positive");
		}
		if(baseRate > 0) {
			this.baseRate = baseRate;
		}else {
			throw new IllegalArgumentException("Must be more than 0");
		}
		nextId = id+1;
	}
	
	
	int getId() {
		return id;
	}
	String getTitle() {
		return title;
	}
	String getAuthor() {
		return author;
	}
	int getAvailableCopies() {
		return availableCopies;
	}
	double getBaseRate() {
		return baseRate;
	}
	static int getNextId() {
		return nextId;
	}
	
	public abstract double calculateFee(Borrowing borrowing);
	public String category() {
		return " [BOOK] ";
	}
//	public void addLine(Borrowing borrowing) {
//		line+="\n Book: " + getTitle() + category() + " fee: " + getBaseRate() + " * " + borrowing.days +
//				" days = " + calculateFee(borrowing);
//	}
	
	public String toString() {
		return "#" + id + " " + getTitle() + category() + getAvailableCopies() + " copies available";
	}
	
	
}
