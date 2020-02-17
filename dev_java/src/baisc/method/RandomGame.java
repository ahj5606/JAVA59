package baisc.method;

import java.util.*;

public class RandomGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int comNum = rand.nextInt(10);
		int userNum =0;
		
		System.out.println("답 : "+comNum);
		for(int i=1 ;i <=3;i++) {
			System.out.print("0~9숫자를 입력해 주세요 : ");
			userNum=scan.nextInt();
			if(userNum==comNum) {
				System.out.println("정답");
				break;
			}
			if(i==3) {
				System.out.println("넌 바보");
			}
			else if(userNum>comNum) {
				System.out.println("숫자가 더 작습니다.");
			}
			else if(userNum<comNum) {
				System.out.println("숫자가 더 큽니다.");
			}
				
			
		}
		
	}

}
