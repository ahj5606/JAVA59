package book.chap12;

public class Child extends Parent{
	@Override
	public void withChild() {
		System.out.println("이건 같이있어요");
	}
	public void onlyChild() {
		System.out.println("이건 자식에만 있어요");
	}
}
