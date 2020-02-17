package book.chap02;



public class SungJuk {
/*
 * 내 안에 있는 메소드라 하더라도 메소드 선언시 static이 없으면 main메소드에서
 * 호출 할 수 없다.
 * 총점을 구해주는 메소드가 있다. 이름은 hap임.
 * 파라미터가 있다 | 없다
 * 같은 이름의 메소드 선언가능 -> 파라미터의 갯수로 구분/ 파라미터 갯수가 달라야함.
 */
	int hap(int kor, int eng) {	//합을 구하는 메소드
		int tot = 0;
		tot =kor + eng;
		return tot;
	}//end of hap
	//평균운 소수점이 나올 수 있다.
	//리턴값은 실수형으로 선언한다.
	//메소드 선언하기
	//반환타입 메소드이름(파라미터1,파라미터2,....)
	double avg(int tot, int subject) {	//평균을 구하는 메소드
		return (double)tot / subject;
	}//end of avg
	void methodA() {}
		/*	자바 컴파일러 진행 순서
		 * 31 - 34 - 35(국어) - 36(영어) - 37 - 13[80,60]값을복사 - 14 - 15(점수합) - 16(리턴 hap끝)
		 * 39(140출력) - 41 - 22[tot]값을복사 - 23[tot/2.0]리턴 avg끝 - 42(출력)
		 */
	public static void main(String[] args) {
		//insert here - hap메소드에서 합을 구한 값을 여기서 사용하고 싶어요
		//어떡하지?
		SungJuk sj = new SungJuk();
		int kor = 80;
		int eng = 65;
		int subject = 2;
		int tot = sj.hap(kor, eng);
		//위에서 계산한 결과인 tot변수를 avg메소드에서 사용하고 싶다.
		System.out.println("합 : "+tot); //kor+eng
		//평균구하고 싶어요?
		double avg = sj.avg(tot,subject);
		System.out.println("두 과목 평균 : "+avg);
	}

}
