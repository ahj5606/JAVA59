package book.cahp06;
/*
 * 변수 2개 선언
 */
class STest{//선언과 초기화
	int i = 1;//non-static타입 
	static int j = 2;//정적변수(static 타입) 선언
}
/*
 * 메소드 한개 선언 - methodA()
 * STest 객체를 메모리에 로딩하였음. -인스턴스화
 * STest클래스의 변수 i 를 1증가시킴
 * 정적변수인 j를 1증가시킴 
 */
class STest2{//변조
	void methodA() {
		STest st = new STest(); //인스턴스화
		st.i = st.i + 1; //2 17번에서 생성된 객체에관한 i값
		STest.j = STest.j + 1; //정적변수 이므로 인스턴스화 하지 않고 사용가능
		//st.i : 2출력    //STest.j : 3출력
		System.out.println("mathodA ==>st.i = "+st.i+"  STest.j = "+STest.j);
	}
}
//관찰하기
public class StaitcTest {
//28-28(먼저생성 -원본)-30-31-16-17(복사본)
	public static void main(String[] args) {
		STest st = new STest();
		STest2 st2 = new STest2();
		st2.methodA();
		st.i += 3;//1->3 17번에서 생성된 객체가 아니라 28번에서 생성된 객체를 가리킴
		//st.i : 4출력    //STest.j : 3출력
		STest.j =5;
		System.out.println("main ==>st.i = "+st.i+"  STest.j = "+STest.j); //정적변수는 주소 복사본을 만든게 아니라 원본을 변경시키는것
		
	}
}
/*
 * 결론(완결편)
 * 같은 이름의 변수로 클래스를 인스턴스화 할 수 있다.
 * 이 떄 주소번지는 서로 다른 값을 가지고 있다.
 * static이 붙은 변수는  인스턴스화 없이 사용할 수 있다.
 * 그리고 또 static이 붙은 변수는 하나가 공유되는 것이다.
 * 그렇기 때문에 위에서 methodA에서 출력한 j값과 main메소드 안에서 출력된 j 값이 
 * 서로 같다.
 * 그러나 변수 i는 static이 없으니까.. 하나가 아니라 복사본이 변경되는 것이다.
 * 따라서 methodA에서 출력한 i값과 main메소드 안에서 출력된i값이
 * 서로 다를 수 밖에 없다.
 */
