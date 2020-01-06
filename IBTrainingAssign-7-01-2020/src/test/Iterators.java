package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Iterators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Fail-fast
		ArrayList<Integer> ls = new ArrayList<Integer>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		Iterator<Integer> itr = ls.iterator();
		while(itr.hasNext()) {
			Integer a=itr.next();
			System.out.println(a);
			if (a == 1){
//				ls.remove(1);
				itr.remove();
			}
		}
		System.out.println(ls);
		CopyOnWriteArrayList<Integer> ls1 = new CopyOnWriteArrayList<Integer>();
		ls1.add(1);
		ls1.add(2);
		ls1.add(3);
		Iterator<Integer> itr1 = ls1.iterator();
		while(itr1.hasNext()) {
			Integer a=itr1.next();
			System.out.println(a);
			if (a == 1){
				ls1.remove(1);
			}
		}
		System.out.println(ls1);
	}

}
