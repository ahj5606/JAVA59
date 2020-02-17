package ocjp.basic;

public class WrapperTest {
	
	public static void main(String[] args) {
		int i = 5;
		//6의 변수 i에 대한 Wrapper 클래스라고 함.
		Integer oi = new Integer(5);
		//원시형 타입 i는 메소드를 호출할 수 없다.
		//System.out.println(i.intValue());일반 참조형 타입에는 불가능
		System.out.println(oi.intValue());//레퍼참조형 타입에는 가능
		int j = 6;
		j = oi;
		Double pi = new Double(3.14);
		double d = pi.doubleValue();
		double d1 = pi;//오토박싱 - 자동으로 원시형과 참조형 사이에 타입을 맞춰줌.
		System.out.println(d1);
		Boolean b = new Boolean(false);
	}
}
