package book.chap05;
/*
 * 쿼리문을 작성할 떄 String을 사용하면 안되는 이유에 대해 말할 수 있다.
 * String은 원본이 절대로 바뀌지 않는다.
 * 따라사 변경하려면 반드시 새로운 변수에 그 값을 다시 담아야 한다.
 * 이렇게 되며 같은 이름의 변수가 n번만큼 생성되므로 비효율 적이다.
 * 따라서 이럴떄는 StringBuilder를 사용한다.
 * 
 */
public class StringTest {
//주소번지를 비교한다.
//주소번지가 가리키는 값을 비교한다.
	public static void main(String[] args) {
		String s1 = "apple";
		String s2 = "apple";	//apple이란 값이 존재하기 때문에 s1이 가진 apple의 주소번지를 가져옴
		String s3 = new String("apple");
		String s4 = new String("apple");
		System.out.println(s1==s2);
		System.out.println(s3==s4);//주소번지 비교
		//그 주소번지가 가리키는 값이 같니?
		System.out.println(s3.equals(s4));
	}
}
