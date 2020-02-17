package ocjp.basic;

public class Q32 {
	int x; // 전역변수 
	
	boolean check() {
		x++; //0->1 ->2  2번호출됨
		return true;
	}
	
	void zzz() {
		x = 0;
		// 앞의 괄호에서 결과가 true 이므로 ||뒤에 문장은 실행되지 않음. // 참이든 거짓이든 실행문이 실행되기 때문 |,||차이
		if((check() | check()) || check()) {	
			x++;
		}
		System.out.println("x = " + x);
	}
	
	 public static void main(String[] args) {
		 (new Q32()).zzz();
	 }
 }

