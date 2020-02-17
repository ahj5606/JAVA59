package ocjp.control;
/*
 * 반복문 사용할 때 주의할 점.
 * 무한 루프를 방지하는 코드를 반드시 작성할 것.
 * 서버가 다운될 수 있다.
 * for문 보다는 while문 에서 자주 발생함.
 * while문에 증감연산자가 있는지 반드시 확인할 것.
 */
public class Q58 {

	public static void main(String[] args) {
		int i =0;
		while(i>3) {
			System.out.println("여기 "+i);		
		}
		//do while문은 조건을 나중에 확인
		//조건을 나중에확인 하므로 한번은 실행됨
		do {
			System.out.println("저기 "+i);
			 i +=4;
		}while(i>3);
	}

}
