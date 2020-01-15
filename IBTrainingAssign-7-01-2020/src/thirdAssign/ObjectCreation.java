package thirdAssign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Cloneable,Serializable{
	String firstName;
	String lastName;
	public Person(){}
	Person(String firstName,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
	}
	protected  Object  clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public String fullName() {
		return this.firstName+this.lastName;
	}
}
class PersonSingleton implements Serializable{
	private static PersonSingleton p = new PersonSingleton();
	private PersonSingleton() {};
	public static PersonSingleton getPersonSingleton() {
		System.out.println("Hey there single instance incoming");
		return p;
	}
	protected Object readResolve() {
		return getPersonSingleton();
	}
	public String printSout() {
		return "BYe World!!";
	}
	
	
}
public class ObjectCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Using New Keyword
		Person p1 = new Person("Ram","Kapur");
		System.out.println(p1.fullName());
		
		//Using New Instance
		Class clsPerson=null;
		try {
			clsPerson = Class.forName("Person");
			try {
				Person obj = (Person) clsPerson.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Using Serlization
		Person p2 = new Person("Hello","World");
		try {
			FileOutputStream f = new FileOutputStream("file.txt");
			ObjectOutputStream oos = new ObjectOutputStream(f); 
            oos.writeObject(p2); 
            oos.close(); 
            f.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Deserlization
		Person p3=null;
		FileInputStream f;
		try {
			f = new FileInputStream("file.txt");
			ObjectInputStream oos = new ObjectInputStream(f); 
	        p3 = (Person)oos.readObject(); 
	        oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(p3.fullName());
		
		
		//Using Serlization for Sincgleton Class
		PersonSingleton p4=PersonSingleton.getPersonSingleton();
		try {
			FileOutputStream f1 = new FileOutputStream("file1.txt");
			ObjectOutputStream oos = new ObjectOutputStream(f1); 
            oos.writeObject(p4); 
            oos.close(); 
            f1.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Deserlization
		PersonSingleton p5=null;
		FileInputStream f1;
		try {
			f1 = new FileInputStream("file1.txt");
			ObjectInputStream oos = new ObjectInputStream(f1); 
	        p5 = (PersonSingleton)oos.readObject(); 
	        oos.close();
	        System.out.println(p5.printSout());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
		

		
		
        
	}

}
