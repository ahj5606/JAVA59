package test0219;

import java.util.ArrayList;

/*
 * 4. 3번에서 정의한 클래스를 사용하여 
   아래 요구사항을 만족하도록 프로그래밍을 하여 소스코드와 결과화면 스크린 샷을
   제출하시오
   [요구사항]
   가. 은행계좌 클래스를 사용하여 객체를 생성한다
   나. 객체의 멤버(예금주,계좌번호,잔액)를 아래처럼 초기화 하여라
      예금주: 자바맨
      계좌번호: 123-456
      잔액:10000

   다. 15000원을 입금하도록 메소드를 호출하여라
   라. 30000원을 출금하도록 메소드를 호출하여라
 */
public class Q4 {
	public static void main(String[] args) {
		Q3 q3 = new Q3("자바맨","123-456",10000);
		System.out.println(q3);
		q3.inMoney(15000);
		q3.outMoney(30000);
		ArrayList ar = new ArrayList();
		
	}
}
