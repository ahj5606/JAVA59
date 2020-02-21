package book.chap08;

import java.util.ArrayList;

class Book1{
	public String b_title = null;
	public String b_author =null;
	
	public Book1(String b_title, String b_author){
		this.b_title = b_title;
		this.b_author =b_author;
	}
	public Book1() {
		
	}
}
public class BookTest {

	public static void main(String[] args) {
		ArrayList<Book1> library = new ArrayList<Book1>();
		Book1 b1 = new Book1();
		b1.b_title ="태백산맥";
		b1.b_author="조정래";
		library.add(b1);
		
		String title = library.get(0).b_title;
		System.out.println("책제목 : " +title);
	}

}
