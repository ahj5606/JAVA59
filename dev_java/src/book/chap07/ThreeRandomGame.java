package book.chap07;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class ThreeRandomGame {
	int comNum[] = new int[3];
	int userNum[]= new int[3];
	
	public void makeNum() { //컴퓨터 숫자를 만들어 주는 메소드
		Random rd = new Random();		
		comNum[0]=rd.nextInt(10);
			do {
				comNum[1]=rd.nextInt(10);
				
			}while(comNum[0]==comNum[1]); //같으면 다시 실행해서 숫자를 다시 생성.
			
			do {
				comNum[2]=rd.nextInt(10);
			}while(comNum[2]==comNum[0] || comNum[2]==comNum[1]);//같으면 다시 실행해서 숫자를 다시 생성.
		
	}//end of makeNum
	
	public void inNum() { //사용자가 숫자를 입력하는 메소드
		Scanner scan = new Scanner(System.in);
		String user=scan.nextLine();
		int userInt=Integer.parseInt(user);
		int user1 = userInt/100;	//받아온값을 100으로 나눔 정수형이므로 100의자리 미만의 10,1의자리는 버려짐
		int user2 = (userInt/10)%10; //받아온값을 10으로 나눠서 1의 자리를 버림, 그 후  10으로 나눈 나머지는 10의 자리의 수
		int user3 = userInt%10; // 10으로 나눈 나머지값 = 1의자리
		userNum[0]=user1;
		userNum[1]=user2;
		userNum[2]=user3;
		//int[] userNum = Stream.of(user.split("")).mapToInt(Integer::parseInt).toArray(); String 형태로 저장된 숫자들을 int형 배열에 하나씩 순서대로 저장.
		
	}//end of inNum
	
	public String account() {
		int loCnt=0;
		int numCnt=0;
	
		for(int i =0;i<comNum.length;i++) {
			for(int j=0;j<comNum.length;j++) {
				if(comNum[i]==userNum[j]) {		
					if(i==j) {	//위치가 같으면 증가
						loCnt++;
					}else {
						numCnt++;
					}
				}
			}
		}
		String user=loCnt+"스트라이크,"+numCnt+"볼";
		return user;
	}
	
	public boolean isWin(String user) { //정답을 맞췃을때 true값을 반환해주는 메소드
		if(user.equals("3스트라이크,0볼")) {	//위치와 숫자가 전부다 맞았을때 정답
			System.out.println("정답!");
			return true;
		}else { //그 외에는 맞은 정보만 출력
			System.out.println(user);
			return false;
		}
	}
	
	public static void main(String[] args) {
		ThreeRandomGame trg = new ThreeRandomGame();
		trg.makeNum();
		boolean win = false;
		String reset =null;
		Scanner scan = new Scanner(System.in);
		
//		System.out.println("만들어진 숫자");				//확인해볼려고 추가함
//		for(int i:trg.comNum) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
		
		do {
			System.out.print("계속하기:'y' 숫자 리셋:'r' 종료:'E'  :");
			reset=scan.nextLine();
			if(reset.equals("y")||reset.equals("Y")) { //Y,y를 눌럿을때 계속진행
				System.out.print("숫자입력 (3자리) : ");
				trg.inNum();
				System.out.println("입력한 숫자 : ");	//자신이 입력한 숫자를 보여줌.
				for(int i:trg.userNum) {
					System.out.print(i+" ");
				}
				System.out.println();
				
				String user = trg.account(); 
				win=trg.isWin(user);
				
			}else if(reset.equals("r")||reset.equals("R")) { //'r' 'R'을 눌럿을때 컴퓨터 숫자 리셋
				trg.makeNum();
				
//				System.out.println("만들어진 숫자");				//확인해볼려고 추가함
//				for(int i:trg.comNum) {
//					System.out.print(" "+i);
//				}
//				System.out.println();
			}else if(reset.equals("E")||reset.equals("e")) { //E,e를 눌럿을때 프로그램 종료
				win=true;
			}
			
		}while((!win));
		
		
	}
}
