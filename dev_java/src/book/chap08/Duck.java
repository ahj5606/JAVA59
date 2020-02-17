package book.chap08;

public class Duck {
	private String swimming ="물에 뜰수 있어요";
	protected String quack = null;
	protected String fly = null;
	protected String name = null;
	public void name() {
		System.out.println("내 이름은 "+name+" 입니다.");
	}
	public void swimming() {
		System.out.println(swimming);
	}
	public void quack() {}
	public void fly() {}
}
