package book.chap12;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class ParentTest {
	public static void main(String[] args) {
		
/*
 * 자바에서는 생성부의 이름으로 객체가 생성된다.
 * 따라서 부모클래스 타입으로 양쪽에 있는 메소드가 호출 되면 아들타입에 정의된 메소드가
 * 호출된다. 부모 클래스의 메소드는 은닉메소드가 된다.
 * 그러나 만일 아들에 동일한 메소드 가존재하지 않으면 아들객체 이지만 
 * 부모에 있는 메소드가 호출된다.
 */
		Parent p = new Child();
		p.withChild();
		p.onlyParent();
//		p.onlyChild();
		
	}
}
