package book.chap05;
/*
 * 오라클 서버에서 관리하고 있는 회원집합을 활용하기 위해 Member클래스를 설계하였다.
 * 장점: 배열을 사용하지 않으면서도 변수 3개를 각각 관리할 수 있게 되었다.
 * 		심지어 서로 타입이 다르더라도 이것은 가능한 일이다.
 * 단점:변수가 배열이 아니다 그래서 여러개(동시에)를 담을 수 없다.
 * 		한번에 한 사람에 대한 정보만 담을 수 있어요.
 * 
 * 여러 사람의 정보를 담을 수는 없나요? - 객체배열을 사용하기 - 문제해결방법
 */
public class Member {
	String mem_id = null;//member테이블의 컬럼명 - 변수
	String mem_pw = null;//비번
	//mem_name에는 한번에 하나의 이름만 담을 수있다.
	//나는 꼭 두 친구의 이름을 기억하고 싶은데... 이건 안되는 건가요??
	//가능한 방법이 있는지 말해 봅시다.
	String mem_name = null;//이름
	
	/*public Member(String mem_name) {
		this.mem_name=mem_name;
	}*/
}
