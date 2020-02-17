package book.chap07;

import java.util.Scanner;

public class UserTest {
	/*****************************************************************************
	 *사용자가 입력한 값에 대한 힌트를 출력하는 메소드입니다.
	 *
	 *@param user 사용자가 입력한 세자리 숫자입니다,. 
	 * @return 컴퓨터가 채번한 숫자와 사용자가 입력한 숫자를 비교한 후 힌트문을 전달합니다.
	 **********************************************************************************/

	public String account() {
		ThreeRandomGame trg = new ThreeRandomGame();
		int Strike=0;
		int ball=0;
	
		for(int i =0;i<trg.comNum.length;i++) {
			for(int j=0;j<trg.comNum.length;j++) {
				if(trg.comNum[i]==trg.userNum[j]) {		
					if(i==j) {	//위치가 같으면 증가
						Strike++;
					}else {
						ball++;
					}
				}
			}
		}
		String user=Strike+"스트라이크,"+ball+"볼";
		return user;
	}
	public static void main(String[] args) {
		System.out.println("세 자리 숫자를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int imsi =0;
		int cnt =0;
		while(cnt<10) {
			imsi = scan.nextInt();
			System.out.println("사용자가 입력한 숫자는 "+imsi+"입니다.");
			cnt++;
		}
	}
}
