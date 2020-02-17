package ocjp.control;

public class Q63 {
	public static void main(String[] args) {
		int i;
		for (i=0;i<= 10;i++){
			int j = 10;
			if( i>6) break;//i=7 이면 break;
		}//요기로 탈출
		System.out.println(i); // i가 for문 안에서의 지역변수이기 떄문에 에러
		int j =5;
		System.out.println(j);
	}
}
