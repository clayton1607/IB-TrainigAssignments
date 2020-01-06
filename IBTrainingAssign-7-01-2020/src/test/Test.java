package test;

import java.util.HashSet;

class Persons{
	String firstName,lastName;
	Persons(String firstName,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public String toString() {
		return firstName;
	}
}
class Person{
	String firstName,lastName;
	Person(String firstName,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public String toString() {
		return firstName;
	}
	public boolean equals(Object person){
		Person p = (Person)person;
		System.out.println(this.firstName.equals(p.firstName));
		return this.firstName.equals(p.firstName);
	}
	public int hashCode() {
		return this.firstName.hashCode();
	}
}
public class Test {
	public static void main(String[] args) {
		HashSet<Persons> hs = new HashSet<Persons>();
		Persons p1 = new Persons("Ram","Kapur");
		Persons p2 = new Persons("Ram","Kapur");
		Persons p3 = new Persons("Joy","Kapur");
		hs.add(p1);
		hs.add(p2);
//		System.out.println(p1.equals(p2));
//		System.out.println(p1.hashCode());
//		System.out.println(p2.hashCode());
//		System.out.println(p1);
		System.out.println(hs);
		Person pr1 = new Person("Ram","Kapur");
		Person pr2 = new Person("Ram","Kapur");
		Person pr3 = new Person("Joy","Kapur");
		HashSet<Person> hs1 = new HashSet<Person>();
		hs1.add(pr1);
		hs1.add(pr2);
		hs1.add(pr3);
//		System.out.println(pr1.hashCode());
//		System.out.println(pr2.hashCode());
		System.out.println(hs1);
	}
}
