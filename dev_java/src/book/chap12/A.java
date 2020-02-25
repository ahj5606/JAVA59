package book.chap12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class A {
//클래스 A에서 메소드 4개를 호출해 보자.
	
	public static void main(String[] args) {
		B b = new B();
		Collection<String> cola = new ArrayList<String>();
		Collection<String> colv = new Vector<String>();
		List<String> lia = new ArrayList<String>();
		List<String> liv = new Vector<String>();
		ArrayList<String> al = new ArrayList<String>();//싱글스레드안전 - 동기화 구현이 안되어 있다. - 속도빠름
		Vector<String> v = new Vector<String>();//멀티스레드에서 안전 -동기화 구현함 -속도 느림
		
		b.methodA(cola);
		b.methodA(colv);
		b.methodA(lia);
		b.methodA(liv);
		b.methodA(al);   //ArrayList를 파라미터로 가지는 메소드가 
		//없을경우 상위타입을 파라미터로 가지는 메소드를 호출한다.
		//전부다 동일.
		b.methodA(v);
		
	}
}
