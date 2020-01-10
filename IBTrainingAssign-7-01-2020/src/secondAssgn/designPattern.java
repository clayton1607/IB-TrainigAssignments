package secondAssgn;

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
		 return ("Account number "+getAccNumber()+" of "+getAccHolderName()+" in "+getBankName());  
		 
		 
	 }
 }
 
 
 // Facade Pattern
 public class designPattern {
		public static void main(String[] args) {
			earlySingleton objA= earlySingleton.getInstance();
			System.out.println(objA.printStatemnt());
			
			lazySingleton objB= lazySingleton.getInstance();
			System.out.println(objB.printStatemnt());
			
			BankCustomer bd= new BankCustomer();
			System.out.println(bd.giveBankDetails());
			
		}
	}
 

