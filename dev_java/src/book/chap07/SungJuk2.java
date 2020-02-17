package book.chap07;
//수업시간에 한 코드
public class SungJuk2 {
	int jumsus[][]= {
			{100,80,90},	//1row 강호동
			{60,70,90},		//2row 유재석
			{80,70,70},
			{90,90,90},
			{80,80,80},
	};
	static int korTotal=0;
	String names[] = {"강호동","유재석","강감찬","김유신","이성계"};
	String subjects[] = {"국어","영어","수학"};
	public static void main(String[] args) {
		SungJuk2 sj = new SungJuk2();
		System.out.println("no\tkor\tneg\tmath\ttotal\tavg");
		System.out.println("=====================================================");
		int i =0;
		int j =0;
		int engTotal=0;
		int mathTotal=0;
		
		
		for(i=0;i<sj.jumsus.length;i++) {
			System.out.print(sj.names[i]);
			int total=0;
			double avg=0;
			for(j=0;j<sj.jumsus[i].length;j++) {
				//for문에서 증감연산자는 반복문이 진행되는 동안 계속 증감이 일어난다.
				//for문에 있는 조건문에서 
				System.out.print("\t"+sj.jumsus[i][j]);
				total+=sj.jumsus[i][j];
				avg=total/3.0;
			}
			System.out.println("\t"+total+"\t"+avg);
		}
		
		for(i=0;i<sj.jumsus.length;i++) {
			
			
				korTotal+=sj.jumsus[i][0];
				engTotal+=sj.jumsus[i][1];
				mathTotal+=sj.jumsus[i][2];
			
		}
		System.out.println("==========================================================");
		System.out.print("총점\t"+korTotal+"\t"+engTotal+"\t"+mathTotal);
	}
}
