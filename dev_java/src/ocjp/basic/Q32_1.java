package ocjp.basic;
/*
 * 전역변수
 * 인스턴스 변수로 호출할 수 있다.
 * 지역변수
 * 인스턴스 변수로 호출할 수 없다.
 */
public class Q32_1 {
	//자바에서는 원시타입의 디폴트값이 있다. double 0.0 boolean false
	int x;		//전역변수는 초기화를 생략할 수 있다. 왜냐하면 생성자가 해줌.
	boolean check() {
		x++;
		return true;
	}
	public static void main(String[] args) {
		new Q32_1().check();//바로사용 재호출x
		Q32_1 q32 = new Q32_1();//선언하여 사용 재호출o
		q32.check();//17에서 선언한 q32사용
		System.out.println("x : "+q32.x);//17에서 선언한 q23에 x값 : 0->1
//		int y=10; //지변 - 메소드 안에서 선언한 변수는 지역변수임.
//		System.out.println("y : "+q32.y);	//인스턴스 변수로 호출할 수 없음.
	}
}
