package book.chap05;

import java.util.Scanner;

/*
 *속성 -전원(boolean),채널(int),볼륨(int)
 *default값 전원 -false ,채널 -1,볼륨-1
 *메소드 채널조절(chnUp / chnDown),볼륨조절(volUp/ volDown),전원(powerOnOff)
 *String 타입의 inputKey // 무엇이 눌렷나에따라 동작.
 */
public class Tv {
	boolean power =false;
	int chn = 1;
	int vol = 1;
	

	int chnUp() {	//채널up 채널 ++ 해서 반환
		chn++;
		return chn;
	}
	int chnDown() { //채널down 채널--해서 반환
		chn--;
		return chn;
	}
	int volUp() {//볼륨up 볼륨++ 해서 반환
		vol++;
		return vol;
	}
	int volDown() {//볼륨down 볼륨-- 해서 반환
		vol--;
		return vol;
	}
	boolean powerOnOff() { //파워OnOff 현재상태의 반대상태를 반환
		power=!power;
		return power;
	}
	/*메소드의 파라미터자리는 사용자가 선택한 값, 입력한 값 등을 받아오는 자리 입니다.
	 * u_power=true가 저장됨
	 * 42번라인에서 그 변수에 not이 있으므로 반대인 flase로 변환 후 대입된다.
	 * false -> true
	 */
	void power(boolean u_power) {//호출할 때 결정된 값이 넘어오는 변수 입니다.
		power=!u_power;
	}
	
	
	
	public static void main(String[] args) {
		Tv tv = new Tv();
		String inputKey=null;
		Scanner scan = new Scanner(System.in);
		System.out.println("'p' 전원 'q' 채널 업, 'a' 채널 다운 ,'w' 볼륨 업 , 's'볼륨 다운 ,'z'프로그램종료"); //메뉴
		do {
			inputKey=scan.nextLine();
			if(inputKey.equals("p")) {	//전원on off버튼
				tv.power=tv.powerOnOff();
				if(tv.power) {
					System.out.println("전원ON");
				}else {
					System.out.println("전원OFF");					
				}
			}else if(tv.power&&inputKey.equals("q")) { //전원이 켜저있고 q가들어왓을때 채널up메소드 호출
				tv.chn=tv.chnUp();
				System.out.println("채널 : "+tv.chn);
			}else if(tv.power&&inputKey.equals("a")&&tv.chn>0) {//전원이 켜저있고 a가들어왓을때 채널down메소드 호출 채널 최소값 0
				tv.chn=tv.chnDown();
				System.out.println("채널 : "+tv.chn);
			}else if(tv.power&&inputKey.equals("w")) {//전원이 켜저있고 w가들어왓을때 볼륨up메소드 호출
				tv.vol=tv.volUp();
				System.out.println("볼륨 : "+tv.vol);
			}else if(tv.power&&inputKey.equals("s")&&tv.vol>0) {//전원이 켜저있고 s가들어왓을때 볼륨down메소드 호출 볼륨 최소값 0
				tv.vol=tv.volDown();
				System.out.println("볼륨 : "+tv.vol);
			}else if(tv.power&&tv.chn==0) { //전원이 켜져있고 채널을 0이하로 내리려 할 때
				System.out.println("채널 0이하 없음");
			}else if(tv.power&&tv.vol==0) { //전원이 켜져있고 볼륨을 0이하로 내리려 할 때
				System.out.println("볼륨 0이하 없음");
			}else if(!tv.power&&!inputKey.equals("z")){ //전원이 내려가있을때 프로그램 종료키가 아닌 다른게 입력된 경우
				System.out.println("전원off");
			}
			
		}while(!inputKey.equals("z")); //z가 입력되면 반복문 종료
		
	}

}
