package book.chap05;

public class MemberSimulation {

	public static void main(String[] args) {
		//Member 클래스를 두 개 만들 수 있는 방을 선언 
		Member mems[] = null;//아직은 방이 할당되지 않았어요
		//객체배열 선언 김유신,이순신 저장2개이므로 크기 2
		mems = new Member[2];//생성하기
		//여기를 지나면 입장할 수 있어요.
		String mem_name=null;
		Member mem = new Member();
		//mem.mem_name에 김유신을 저장 
		mem.mem_name="김유신";//초기화 null ==>김유신
		mem.mem_id="test";
		mem.mem_pw="123";
		//앗 mem주소번지를 잘라내려고 해요...
		//잘리기 전에 담아 두어야함니다. 일단 null이 되고 나면 가비지컬렉터가
		//넌 쓰레기값이야 라고 딱지를 붙입니다. 그러면 접근을 못해요 ㅠㅠ
		//그래서 반드시 그 전에 담아두어야 하는 거군요
		//after
		mems[0] = mem;
		mem = null;
		mem = new Member();
		mem.mem_name="이순신";
		mem.mem_id="nono";
		mem.mem_pw="333";
		mems[1]=mem;
		System.out.println("이름\tID\tPW");
		System.out.println("=====================");
		for(int i=0;i<mems.length;i++) {
			String name = mems[i].mem_name;
			String id = mems[i].mem_id;
			String pw = mems[i].mem_pw;
			System.out.println(name+"\t"+id+"\t"+pw);
		}
		
		
		
		/*mems[0].mem_name="김유신";
		mems[1].mem_name="이순신";
		for(int i = 0 ; i < mems.length;i++) {
			System.out.println(mems[i].mem_name);
		}*/
		/*mems[0]=new Member("김유신");
		mems[1]=new Member("이순신");
		for(int i=0;i<mems.length;i++) {
		System.out.println(mems[i].mem_name);
		}*/
	}

	
}
