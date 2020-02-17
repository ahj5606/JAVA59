package oracle.jdbc2;

import java.util.Vector;

public class ZipCodeList {
	public static void main(String[] args) {
		//Vector v2<Object> = new Vector<Object>;// 제네릭을 생략한 경우
		Vector v2 = new Vector();// 제네릭을 생략한 경우
		v2.add("사과");
		v2.add("딸기");
		v2.add(1,"바나나");
		Vector<String> v = new Vector<String>();// String 타입
		v.add("사과");
		v.add("딸기");
		v.add(1,"바나나");
		v2.remove(2);
		v2.remove("바나나");
		//String str = v.get(0);//<>에 String 타입이라고 지정
		for(int i=0;i<v2.size();i++) {
			//String f =v2.get(i);//타입이 Object라서 담을 수가 없어요. 타입이 맞지 않죠
			String f2 =(String)v2.get(i);
			System.out.println("v: "+v2.get(i));
		}
	}
}
