package book.chap08;

public class CarTest {
	public static void main(String[] args) {
		//myCar로 접근할 수 있는 변수의 갯수는 몇개 일까요?
		//myCar로 호출할 수 있는 메소드의 갯수는 몇개 일까요?
		Car myCar = null;
		/*
		 * myCar의 타입이 Car타입이어서 Tivoli타입의 변수나 메소드는 한개도 접근, 호출
		 * 불가합니다.
		 * 이것은 new Tivoli()로 인스턴스화 한 경우에도 동일하게 적용됩니다.
		 * 다시 말하지만 타입이 Car타입이어서 생성부의 이름이 설사 Tivoli가 온다 하더라도
		 * Tivoli타입의 변수나 메소드는 접근,호출이 불가하다는 것이죠.
		 * 이런경우 메소드는 부모와 자식 클래스 모두에 선언해 놓으면[메소드 오버라이드] 호출은 가능합니다.
		 *만일 부모에는 존재하고 자식에는 존재하지 않는 메소드의 경우 둘다 무조건 부모메소드가 호출된다.
		 *
		 * 그러나 변수는....?
		 */
		myCar = new Car();
		System.out.println(myCar.speed);
		myCar.stop();
		myCar = null;
		myCar = new Tivoli();//20번에서 21번으로 진행되는 과정에서 candidate상태
		System.out.println(myCar.speed);
		myCar.stop();
		
		//herCar로 접근할 수 있는 변수의 갯수는 몇개 일까요?
		//herCar로 호출할 수 있는 메소드의 갯수는 몇개 일까요?
		Tivoli herCar = new Tivoli();
		System.out.println(herCar.carColor);
		System.out.println(herCar.volumn);
		System.out.println(herCar.speed);
		herCar.stop();
		herCar.volumnDown();
		herCar.volumnUp();
		//Car himCar = null;
	}
}
