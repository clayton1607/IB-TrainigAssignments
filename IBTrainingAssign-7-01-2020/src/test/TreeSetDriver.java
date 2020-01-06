package test;

import java.util.TreeSet;

class PersonL implements Comparable<PersonL>{
	String firstName,lastName;
	PersonL(String firstName,String lastName){
		this.firstName= firstName;
		this.lastName= lastName;
	}
	public int compareTo(PersonL p) {
		return this.firstName.compareTo(p.firstName);
	}
	public String toString() {
		return this.firstName;
	}
}
public class TreeSetDriver {
	public static void main(String[] args) {
		TreeSet<PersonL> ts = new TreeSet<PersonL>();
		PersonL p1= new PersonL("Roy","Man");
		PersonL p2= new PersonL("Toy","Man");
		PersonL p3= new PersonL("Can","Man");
		PersonL p4= new PersonL("Van","Man");
		PersonL p5= new PersonL("Troy","Man");
		PersonL p6= new PersonL("Roy","Man");
		ts.add(p1);
		ts.add(p2);
		ts.add(p3);
		ts.add(p4);
		ts.add(p5);
		ts.add(p6);
		System.out.println(ts);
				
	}
}
