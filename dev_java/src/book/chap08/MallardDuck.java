package book.chap08;

public class MallardDuck extends Duck {
	public void name() {
		super.name="MallardDuck";
		super.name();
	}
	
	public void quack() {
		System.out.println("나는 꿱꿱소리 로 웁니다.");
	}
	public void fly() {
		System.out.println("나는 날고 있어요.");
	}
	
	@Override
	public void swimming() {
		//재정의
		System.out.println("청둥 오리는 물위에 뜨기도 하고 잠수도 가능합니다.");
	}
}
