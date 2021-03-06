package book.cahp06;
/*
 * 10번 12번 14번의 주소번지는 모두 다른 값일 것이다.   O
 * 10번 12번은 같지만 14번은 다를 것이다.
 * 10번 12번 14번 모두 같은 주소값을 가질 것이다.
 */
public class Tivoli {
	public int speed =0;
	//디폴트 생성자 구현하기 - 파라미터가 없는 생성자임
	//JVM이 대신  만들어 줄 수 있는 생성자 - 파라미터를 결정하기 않아도 되니까 제공가능함.
	public Tivoli(){
	//this - 자기자신 주번
	//this() - 자기자신 생성자 호출 
		this(50); //생성자 호출하기 
	}
	Tivoli(int speed){
		this.speed = speed;
	}
	public static void main(String[] args) {
		Tivoli myCar = new Tivoli(); //디폴트 생성자 호출하기 -11-14(50)
		//myCar.speed = 30;
		System.out.println("myCar 주.번 : "+myCar);//10번의 주.번 값
		System.out.println("나는 현재 "+myCar.speed+" 로 가는 중이야");//11번 초기화30
		//자바에서는 같은 이름의 변수를 중복선언불가
		myCar = new Tivoli();//새로 초기화
		myCar.speed = 50;
		System.out.println("나는 현재 "+myCar.speed+" 속도를 내고 있어");//15번 초기화 50
		System.out.println("myCar2 주.번 : "+myCar);//14번의 주.번 값
		Tivoli herCar = new Tivoli();
		herCar.speed = 100;
		System.out.println("나는 현재 "+herCar.speed+" 속도로 달리고 있어");//19번 초기화 100
		System.out.println("herCar 주.번 : "+herCar);//18번의 주.번 값
		
	}
}
