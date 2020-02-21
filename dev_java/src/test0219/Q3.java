package test0219;
/*
 * 3. 다음 요구사항을 만족하는 은행 계좌 클래스를 정의하여 소스코드와 결과화면 
  스크린 샷을 제출하시오
   [요구사항]
   가. 속성으로 예금주,계좌번호,잔액을 갖는다.
      예금주는 String,계좌번호 String,잔액은 int로 정의하여라
   나. 메소드로 인출 및 입금 메소드를 갖는다.
       인출 메소드는 인자로 인출할 금액을 받고 잔액이 부족시에는
       “잔액이 부족합니다”라는 메시지를 잔액이 충분할때는 인출한 금액을 출력하는 
       메소드이다
       입금 메소드는 인자로 입금할 금액을 받고 입금액을 잔액에 더하고
       입금한 금액을 출력하는 메소드이다
   다. toString()메소드를 오버라이딩하여 계좌정보 즉 얘금주,계좌번호,잔액을
      출력하는 메소드를 정의하여라
      예]예금주:자바맨,계좌번호:123-456,잔액:1000원
 */
public class Q3 extends Object{
	//변수선언 - 고유명사 - 그 이름으로 클래스가 연상되는 그런 아이들 - 전역변수
	String name = null;//예금주
	String account = null; //계좌번호
	int cash = 0; //잔액
	//디폴트 생성자
	
	public Q3(){
		
	}
	
	public Q3(String name , String account , int cash){
		this.name = name;
		this.account = account;
		this.cash = cash;
	}
	//메소드 선언- 리턴타이과 파라미터
	//DB연동하기 - SELECT, INSERT, UPDATE, DELETE 무조건 먼저 작성해보기
	//쿼리문 안에는 ? 가있다. - 사용자가 입력하는 값을 넣어줄 곳 - 파라미터 
	//처리 결과를 사용자에게 응답해야 한다 - 리턴타입, 리턴 값
	public void inMoney(int inMoney) { //입금하기
		this.cash +=inMoney;
		System.out.println("입금한 금액은 "+inMoney+" 이며  입금후 잔액은 "+cash+" 입니다.");
	}
	public void outMoney(int outMoney) { //얼마를 가져갈 거니? - 파라미터 
		if(cash<outMoney) {
			System.out.println("잔액이 부족합니다.");
			return;//if문에 return continu 사용 
		}else {
			this.cash -=outMoney;
			System.out.println("인출한 금액은 "+outMoney+"입니다"+"남은 잔액 은"+cash+"입니다.");
		}
	}
	/*
	 * 원래는 부보가 가진 메소드 이므로 별도로 정의하지 않아도 호출할 수 있다.
	 * 그러나 추가로 작성하고 싶은 내용이 있다면 언제든지 재정의할 수 있다.
	 * 재정의 할 때 반환값을 문자열로 바꾸었으므로 주소번지 대신
	 * return의 문자를 출력되게 되는 것이다.
	 * 설계한 클래스의 기본정보를 출력할 때 많이 활용된다.
	 * 또한 UI/UX 화면단을 구현해주는 외부 클래스에도 적용할 수 있다.
	 */
	@Override
	public String toString() { //Object클래스 상속. 
		String accountINFO = String.format("예금주 : %s, 계좌번호 : %s, 잔액 : %s원",name,account,cash);
		return accountINFO;
	}
	public static void main(String[] args) {
		Q3 q3 = new Q3("자바맨","123-456",10000);
		System.out.println(q3);
	}
}
