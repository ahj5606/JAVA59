package study.sungjuk;

public class Bank {
	String name = null;
	String account =null;
	int cash =0;
	/*모든클래스의 상위 클래스가 Object인데 이 클래스에는 toString메소드가 정의 되어 있다.
	 * 이 메소드를 자식 클래스가 재정의 해서 사용할 수 있는데 이를 오버라이딩 이라고 한다.
	 * 메소드이름은 format이다.
	 * %s는 문자열 형식을 지원하는 예약어 이다.
	 * %n은 개행처리를 지원한다.
	 * %s가 세번 나왔으므로 파라미터도 3개가 되어야한다.
	 */
	@Override
	public String toString() {
		return String.format("예금주 : %s, 계좌번호 : %s, 잔액 : %s%n",name,account,cash);
	}
	public void take(int money) {
		//잔액이 인출 금액보다 큰가요?
		if(money>cash) {
			System.out.println("잔액이 부족합니다.");
		}else {
			System.out.println("인출금액"+money);
			System.out.println("잔액"+cash);
		}
	}
	public void dsposit(int money) {
		cash+=money;
		System.out.println("입금액"+money);
		System.out.println("잔액"+cash);
	}
	
}
