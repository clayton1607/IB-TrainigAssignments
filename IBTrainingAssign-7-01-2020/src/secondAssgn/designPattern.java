package secondAssgn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Singleton Design pattern
//Early Instantiation

class earlySingleton{
	private earlySingleton() {}
	private static earlySingleton obj = new earlySingleton();
	
	public static earlySingleton getInstance() {
		return obj;
	}
	public String printStatemnt() {
		return "Hey There!!";
	}
}
//Lazy Instantiation
class lazySingleton{
	private lazySingleton() {}
	private static lazySingleton obj;
	
	public static lazySingleton getInstance() {
		if(obj == null) {
			synchronized(lazySingleton.class) {
				if (obj==null) {
					obj= new lazySingleton();
				}
			}
		}
		return obj;
	}
	public String printStatemnt() {
		return "Hey There!!";
	}
}



//Adapter Pattern

//This is the adapter class.  
class BankDetails{  
	private String bankName;  
	private String accHolderName;  
	private String accNumber;  
   
	public String getBankName() {  
		return bankName;  
	}  
	public void setBankName(String bankName) {  
		this.bankName = bankName;  
	}  
	public String getAccHolderName() {  
    return accHolderName;  
	}  
	public void setAccHolderName(String accHolderName) {  
	    this.accHolderName = accHolderName;  
	}  
	public String getAccNumber() {  
	    return accNumber;  
	}  
	public void setAccNumber(String accNumber) {  
	    this.accNumber = accNumber;  
	}
}  
 
 class BankCustomer extends BankDetails{
	 public String giveBankDetails() {
		 Scanner sc= new Scanner(System.in);
		 System.out.println("Enter the account name:");
		 String custName= sc.nextLine();
		 System.out.println("Enter the Bank name:");
		 String custBankName= sc.nextLine();
		 System.out.println("Enter the Account Name:");
		 String custAccName= sc.nextLine();
		 setAccHolderName(custName);
		 setBankName(custBankName);
		 setAccNumber(custAccName);
		 sc.close();
		 return ("Account number "+getAccNumber()+" of "+getAccHolderName()+" in "+getBankName());  
		 
		 
	 }
 }
 
 
 // Template pattern
 
 abstract class Shape{
	 abstract void draw();
	 abstract void formulaArea();
	 abstract void examples();
	 
	 public final void display() {
		 draw();
		 System.out.println("Area Formula:");
		 System.out.println();
		 formulaArea();
		 System.out.println();

		 System.out.println("Examples");
		 System.out.println();
		 examples();
		 System.out.println();
		 
		 
	 }
	 
 }
 class Square extends Shape{
	 void draw() {
		 System.out.println("Shape: Square");
	 }
	 
	 void formulaArea() {
		 System.out.println("a*a :where a is side");
	 }

	 void examples() {
		 System.out.println("");
	 }
 } 
 
 class Circle extends Shape{
	 void draw() {
		 System.out.println("Shape: Circle");
	 }
	 
	 void formulaArea() {
		 System.out.println("Pi * R^2 :where r is radius");
	 }

	 void examples() {
		 System.out.println("Sun, tennsis ball : in 2d");
	 }
 } 
 
 //DAO
 class Books {

	 private int isbn;
	 private String bookName;
	 public Books() {
	 }
	 public Books(int isbn, String bookName) {
		 this.isbn = isbn;
		 this.bookName = bookName;
	 }

	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
 }
 
 
 interface BookInterface{
	 List<Books> getAllBooks();
	 Books getBookByIsbn(int isbn);
	 void saveBook(Books book);
	 void deleteBook(Books book);
	}
 
 class BookDaoImpl implements BookInterface {

	    //list is working as a database
	    private List<Books> books;

	    public BookDaoImpl() {
	        books = new ArrayList<>();
	        books.add(new Books(1, "Java"));
	        books.add(new Books(2, "Python"));
	        books.add(new Books(3, "Android"));
	    }

	    public List<Books> getAllBooks() {
	        return books;
	    }

	    public Books getBookByIsbn(int isbn) {
	        return books.get(isbn);
	    }

	    public void saveBook(Books book) {
	        books.add(book);
	    }

	    public void deleteBook(Books book) {
	        books.remove(book);
	    }
	}
 
 //Facade Design Pattern
 class debitCard{
	 private String cardNo;
	 private String cardHolderName;
	 private String cvv;
	 public debitCard() {}
	 public debitCard(String cardNo,String cardHolderName,String cvv) {
		 this.cardNo=cardNo;
		 this.cardHolderName=cardHolderName;
		 this.cvv=cvv;
	 }
	 public boolean Authenticate() {
		 return true;
	 }
 }
 class creditCard{
	 private String cardNo;
	 private String cardHolderName;
	 private String cvv;
	 public creditCard() {}
	 public creditCard(String cardNo,String cardHolderName,String cvv) {
		 this.cardNo=cardNo;
		 this.cardHolderName=cardHolderName;
		 this.cvv=cvv;
	 }
	 public boolean Authenticate() {
		 return true;
	 }
 }
 
 class Shop{
	 private String cardNo;
	 private String cardHolderName;
	 private String cvv;
	 public void doPayment(String type) {
		 if (type=="1") {
			 
			 Scanner sc= new Scanner(System.in);
			 cardNo=sc.nextLine();
			 cardHolderName=sc.nextLine();
			 cvv=sc.nextLine();
			 debitCard dc = new debitCard(cardNo,cardHolderName,cvv);
			 if (dc.Authenticate()) {
				 System.out.println("Success");
			 }
			 sc.close();
		 }
		 if (type=="2") {
			 Scanner sc= new Scanner(System.in);
			 cardNo=sc.nextLine();
			 cardHolderName=sc.nextLine();
			 cvv=sc.nextLine();
			 creditCard cc = new creditCard(cardNo,cardHolderName,cvv);
			 if (cc.Authenticate()) {
				 System.out.println("Success");
			 }
			 sc.close();
		 }
		 if (type =="3")
			 System.out.println("Pay Cash");
		 
	 }
 }
public class designPattern {
		public static void main(String[] args) {
			Scanner sc= new Scanner(System.in);
			//Singleton
//			earlySingleton objA= earlySingleton.getInstance();
//			System.out.println(objA.printStatemnt());
//			
//			lazySingleton objB= lazySingleton.getInstance();
//			System.out.println(objB.printStatemnt());
//			
//			//Abstract
//			BankCustomer bd= new BankCustomer();
//			System.out.println(bd.giveBankDetails());
//			
//			//Template
//			System.out.println("Enter the Shape:");
//			
//			String shape= sc.nextLine();
//			System.out.println(shape);
//			try {
//				Class c = Class.forName(shape);
//				Shape sp= (Shape)c.newInstance();
//				sp.display();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			catch (InstantiationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
			//DAO
			BookInterface bookDao = new BookDaoImpl();

	        for (Books book : bookDao.getAllBooks()) {
	            System.out.println("Book ISBN : " + book.getIsbn());
	        }
	        //Facade
	        Shop shop = new Shop();
	        System.out.println("Enter mode of Payment 1: Debit card 2: Credit Card 3: Cash");
	        String type = sc.nextLine();
	        shop.doPayment(type);
	        sc.close();
			
		}
	}

 

