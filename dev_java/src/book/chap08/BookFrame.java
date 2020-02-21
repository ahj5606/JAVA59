package book.chap08;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Scrollable;
import javax.swing.table.DefaultTableModel;

public class BookFrame extends JFrame{
	String cols[] = {"도서명","저자"};
	String data[][] = new String[0][2];
	DefaultTableModel dtm_book = new DefaultTableModel(data,cols);
	JTable jtb_book = new JTable(dtm_book);
	JScrollPane jsp_book = new JScrollPane(jtb_book);
	public BookFrame() {
		ArrayList<Book1> library = new ArrayList<Book1>();
		Book1 b1 = new Book1();
		b1.b_title="태백산맥";
		b1.b_author="조정래";
		library.add(b1);
		
		b1=null;
		b1 = new Book1();
		b1.b_title="데미안";
		b1.b_author="헤르만 헤세";
		library.add(b1);
		System.out.println("size : "+library.size()); //2
		for(int i=0 ; i<library.size();i++) {
			Vector<String> v =new Vector<>();
			v.add(library.get(i).b_title);
			v.add(library.get(i).b_author);
			dtm_book.addRow(v);
		}
		this.add("Center",jsp_book);
		this.setSize(600,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new BookFrame();
	}
}
