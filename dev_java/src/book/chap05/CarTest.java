package book.chap05;

import book.cahp06.Tivoli;
public class CarTest {
	void methodA(Tivoli myCar) {
		myCar.speed +=50;
	}
	public static void main(String[] args) {
		CarTest ct = new CarTest();
////		Tivoli myCar = new Tivoli(50);
//		myCar.speed =30;
//		System.out.println("methodA 호출 전"+myCar.speed);
//		ct.methodA(myCar);
//		System.out.println("methodA 호출 후"+myCar.speed);
////		Tivoli herCar = new Tivoli(50);
//		herCar.speed=50;
	}
}
