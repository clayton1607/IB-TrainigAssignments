package test;

import java.util.HashSet;
import java.util.Set;

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

class PersonWithHashCode{
	String firstName,lastName;
	PersonWithHashCode(String firstName,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public String toString() {
		return firstName;
	}
	public int hashCode() {
		return this.firstName.hashCode();
	}
}

class PersonWihtEquals{
	String firstName,lastName;
	PersonWihtEquals(String firstName,String lastName){
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
}
public class EqualsNHashCode {
	public static void main(String[] args) {
		Set<Persons> hs = new HashSet<Persons>();
		Persons p1 = new Persons("Ram","Kapur");
		Persons p2 = new Persons("Ram","Kapur");
		Persons p3 = new Persons("Joy","Kapur");
		hs.add(p1);
		hs.add(p2);
		System.out.println(p1.equals(p2));
//		System.out.println(p1.equals(p2));
//		System.out.println(p1.hashCode());
//		System.out.println(p2.hashCode());
//		System.out.println(p1);
		System.out.println(hs);
		Person pr1 = new Person("Ram","Kapur");
		Person pr2 = new Person("Ram","Kapur");
		Person pr3 = new Person("Joy","Kapur");
		Set<Person> hs1 = new HashSet<Person>();
		hs1.add(pr1);
		hs1.add(pr2);
		hs1.add(pr3);
		System.out.println(pr1.equals(pr2));

//		System.out.println(pr1.hashCode());
//		System.out.println(pr2.hashCode());
		System.out.println(hs1);
//		[Joy, Ram]

		
		PersonWithHashCode prH1 = new PersonWithHashCode("Ram","Kapur");
		PersonWithHashCode prH2 = new PersonWithHashCode("Ram","Kapur");
		PersonWithHashCode prH3 = new PersonWithHashCode("Joy","Kapur");
		Set<PersonWithHashCode> hs2 = new HashSet<PersonWithHashCode>();
		hs2.add(prH1);
		hs2.add(prH2);
		hs2.add(prH3);
		//System.out.println(prH1.equals(prH2));
		System.out.println(hs2);
//		[Joy, Ram, Ram]
		
		PersonWihtEquals prE1 = new PersonWihtEquals("Ram","Kapur");
		PersonWihtEquals prE2 = new PersonWihtEquals("Ram","Kapur");
		PersonWihtEquals prE3 = new PersonWihtEquals("Joy","Kapur");
		Set<PersonWihtEquals> hs3 = new HashSet<PersonWihtEquals>();
		hs3.add(prE1);
		hs3.add(prE2);
		hs3.add(prE3);
		
		//System.out.println(prE1.equals(prE2));
		System.out.println(hs3);
//		[Ram, Joy, Ram]
	}
}
