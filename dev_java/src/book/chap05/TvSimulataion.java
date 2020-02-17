package book.chap05;

import java.util.Scanner;

public class TvSimulataion {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("TV를 보시겠습니까?:");
		boolean isok = scan.nextBoolean();
		if(isok) {
			System.out.println("true입니다");
		}else {
			System.out.println("false입니까");
		}
		
		Tv tv= new Tv();
		//tv.powerOnOff(); //false =>!false =>true
		//파라미터가 잇어야 내 의사를 표현할 수 있다. => 소통시작
		tv.power(isok);
		//현재 tv는 전원이 켜진 상태 입니까?
		System.out.println(tv.power);//true
		if(tv.power) {
			System.out.println("tv시청중입니다.");
		}else {
			System.out.println("아무도 보고있지 않아요");
			
		}
	}

}
