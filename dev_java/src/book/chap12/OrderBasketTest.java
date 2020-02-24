package book.chap12;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OrderBasketTest extends JFrame{
	String cols[] = {"날짜","판매수량","매출액"};
	String data[][] = new String[0][3];
	DefaultTableModel dtm_order = new DefaultTableModel(data,cols);
	//서로 연관(의존성)이 있는 클래스 사이에서 별도의 메소드나 코딩 없이
	//생성자의 파라미터를 통해서 값을 초기화 할 수 있다.
	JTable jt_order = new JTable(dtm_order);
	JScrollPane jsp_order = new JScrollPane(jt_order);
	public OrderBasketTest(){
		
		dataSetMapping();
		this.add(jsp_order);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("OrderBasket");
		this.setSize(500,400);
		this.setVisible(true);
		
	}
	
	public void tableData() {
		OrderBasketDB ordb = new OrderBasketDB();
		OrderBasketVO orVOs[] = ordb.result();
		
		for(int i=0 ; i<orVOs.length;i++) {
			Vector row = new Vector();
			row.add(orVOs[i].getIndate_vc());
			row.add(orVOs[i].getT_qty()+"개");
			row.add(orVOs[i].getT_price()+"원");
			
			dtm_order.addRow(row);
		}
		
	}
	
	public void dataSetMapping() {
		OrderBasketDataSet ds = new OrderBasketDataSet();
		ArrayList<OrderBasketVO> al = ds.getList();
		for(int x=0;x<al.size();x++) {
			Vector v = new Vector();
			v.add(al.get(x).getIndate_vc()+"                                                                                                                        ");
			v.add(al.get(x).getT_qty());
			v.add(al.get(x).getT_price());
			dtm_order.addRow(v);
		}
	}
	
	public static void main(String[] args) {
		new OrderBasketTest();
	}
}
